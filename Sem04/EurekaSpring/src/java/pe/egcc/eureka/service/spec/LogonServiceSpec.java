package pe.egcc.eureka.service.spec;

import pe.egcc.eureka.model.EmpleadoModel;

public interface LogonServiceSpec {
  
  EmpleadoModel validarUsuario(String usuario, String clave);
  
}
