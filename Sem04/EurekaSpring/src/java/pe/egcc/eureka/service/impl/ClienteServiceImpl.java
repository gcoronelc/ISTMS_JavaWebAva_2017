package pe.egcc.eureka.service.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import pe.egcc.eureka.model.ClienteModel;
import pe.egcc.eureka.service.spec.ClienteServiceSpec;

@Service
public class ClienteServiceImpl extends AbstractDaoSupport
        implements ClienteServiceSpec {

  @Override
  public List<ClienteModel> conClientes(String dato) {
    String sql = "select \n"
            + "chr_cliecodigo     codigo     ,\n"
            + "vch_cliepaterno    paterno    ,\n"
            + "vch_cliematerno    materno    ,\n"
            + "vch_clienombre     nombre     ,\n"
            + "chr_cliedni        dni        ,\n"
            + "vch_clieciudad     ciudad     ,\n"
            + "vch_cliedireccion  direccion  ,\n"
            + "vch_clietelefono   telefono   ,\n"
            + "vch_clieemail      email    \n"
            + "from cliente\n"
            + "where vch_cliepaterno like ?\n"
            + "or vch_cliematerno like ?\n"
            + "or vch_clienombre like ?";
    dato = "%" + dato + "%";
    Object[] param = {dato, dato, dato};
    List<ClienteModel> lista;
    lista = jdbcTemplate.query(sql, param, 
            new BeanPropertyRowMapper(ClienteModel.class));
    return lista;
  }

}
