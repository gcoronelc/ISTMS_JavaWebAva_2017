package pe.egcc.eureka.service.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import pe.egcc.eureka.model.EmpleadoModel;
import pe.egcc.eureka.service.spec.LogonServiceSpec;

@Service
public class LogonServiceImpl extends AbstractDaoSupport implements LogonServiceSpec {

  @Override
  public EmpleadoModel validarUsuario(String usuario, String clave) {
    EmpleadoModel empleado = null;
    try {
      String sql = "select "
              + "chr_emplcodigo codigo,"
              + "vch_emplpaterno paterno,"
              + "vch_emplmaterno materno,"
              + "vch_emplnombre nombre,"
              + "vch_emplciudad ciudad,"
              + "vch_empldireccion direccion,"
              + "vch_emplusuario usuario "
              + "from empleado "
              + "where vch_emplusuario = ? "
              + "and vch_emplclave = ? "
              + "and chr_emplcodigo in "
              + "( select chr_emplcodigo from asignado "
              + "where dtt_asigfechabaja is null )";
      Object[] args = {usuario, clave};
      empleado = (EmpleadoModel) jdbcTemplate.queryForObject(sql, args, 
              new BeanPropertyRowMapper(EmpleadoModel.class));
    } catch (EmptyResultDataAccessException e) {
      empleado = null;
    }
    return empleado;
  }

}
