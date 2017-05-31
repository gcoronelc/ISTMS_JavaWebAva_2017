package pe.egcc.eureka.service.spec;

import java.util.List;
import pe.egcc.eureka.model.ClienteModel;

public interface ClienteServiceSpec {
  
  List<ClienteModel> conClientes(String dato);
}
