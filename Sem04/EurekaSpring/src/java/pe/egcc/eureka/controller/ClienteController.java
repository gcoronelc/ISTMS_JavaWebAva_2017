package pe.egcc.eureka.controller;

import com.google.gson.Gson;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.egcc.eureka.model.ClienteModel;
import pe.egcc.eureka.service.spec.ClienteServiceSpec;

@Controller
public class ClienteController {
  
  @Autowired
  private ClienteServiceSpec clienteService;
  
  @RequestMapping(value = "conClientes.htm", method = RequestMethod.GET)
  public String conClientes(){
    return "conClientes";
  }
  
  @RequestMapping(value = "conClientes.htm", method = RequestMethod.POST,
          produces = "application/json")
  @ResponseBody
  public String conClientes(@RequestParam("dato") String dato){
    // Proceso
    List<ClienteModel> lista = clienteService.conClientes(dato);
    // Reporte
    Gson gson = new Gson();
    String repo = gson.toJson(lista);
    return repo;
  }
  
}
