package pe.egcc.eureka.service.impl;

import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.egcc.eureka.service.spec.CuentaServiceSpec;

@Service
public class CuentaServiceImpl
        extends AbstractDaoSupport implements CuentaServiceSpec {

  @Override
  public Double conSaldo(String cuenta) {
    Double saldo;
    try {
      String sql = "select dec_cuensaldo from cuenta where chr_cuencodigo = ?";
      Object[] param = {cuenta};
      saldo = jdbcTemplate.queryForObject(sql, param, Double.class);
    } catch (EmptyResultDataAccessException e) {
      saldo = null;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error en el proceso \"Consultar Saldo \".");
    }
    return saldo;
  }

  @Override
  @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
  public void procRetiro(String cuenta, String clave, double importe, String codEmp) {
    // Leer datos de la cuenta
    String sql = "select dec_cuensaldo saldo, int_cuencontmov cont "
            + "from cuenta "
            + "where chr_cuencodigo = ? "
            + "and vch_cuenestado = 'ACTIVO' "
            + "and chr_cuenclave = ? "
            + "for update ";
    Map<String, Object> datos;
    datos = jdbcTemplate.queryForMap(sql, cuenta, clave);
    double saldo = Double.parseDouble(datos.get("saldo").toString());
    int cont = Integer.parseInt(datos.get("cont").toString());
    // Validar
    if (saldo < importe) {
      throw new RuntimeException("Error, no hay saldo suficiente.");
    }
    // Actualizar cuenta
    saldo -= importe;
    cont++;
    sql = "update cuenta set dec_cuensaldo = ?, "
            + "int_cuencontmov = ? "
            + "where chr_cuencodigo = ? ";
    jdbcTemplate.update(sql, saldo, cont, cuenta);
    // Imsertar el movimiento
    sql = "insert into movimiento(chr_cuencodigo,int_movinumero,"
              + "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,"
              + "dec_moviimporte) values(?,?,SYSDATE(),?,'004',?)";
    jdbcTemplate.update(sql, cuenta, cont, codEmp, importe);
  }

}
