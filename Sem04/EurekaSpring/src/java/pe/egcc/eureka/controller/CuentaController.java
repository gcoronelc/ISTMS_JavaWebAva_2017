package pe.egcc.eureka.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import pe.egcc.eureka.model.EmpleadoModel;
import pe.egcc.eureka.model.JsonModel;
import pe.egcc.eureka.service.spec.CuentaServiceSpec;

@Controller
@SessionAttributes(value = {"usuario"})
public class CuentaController {
  
  @Autowired
  private CuentaServiceSpec cuentaService;
    
  @RequestMapping(value = "conSaldo.htm", method = RequestMethod.GET)
  public String conSaldo(){
    return "conSaldo";
  }
  
  @RequestMapping(value = "conSaldo.htm", 
          method = RequestMethod.POST, 
          produces = "application/json")
  @ResponseBody
  public String conSaldo( @RequestParam("cuenta") String cuenta){
    JsonModel jsonModel = new JsonModel();
    try {
      // Proceso
      Double saldo = cuentaService.conSaldo(cuenta);
      if(saldo ==  null){
        throw new Exception("Cuenta " + cuenta + " no existe.");
      }
      jsonModel.setCode(1);
      jsonModel.setRpta("" + saldo);
    } catch (Exception e) {
      jsonModel.setCode(-1);
      jsonModel.setRpta(e.getMessage());
    }
    // Reporte
    Gson gson = new Gson();
    return gson.toJson(jsonModel);
  }
  
  @RequestMapping(value = "procRetiro.htm", method = RequestMethod.GET)
  public String procRetiro(){
    return "procRetiro";
  }
  
  @RequestMapping(value = "procRetiro.htm", method = RequestMethod.POST,
          produces = "application/json")
  @ResponseBody
  public String procRetiro(
          @RequestParam("cuenta") String cuenta,
          @RequestParam("importe") double importe,
          @RequestParam("clave") String clave,
          @ModelAttribute("usuario") EmpleadoModel usuario          
  ){
    JsonModel jsonModel = new JsonModel();
    try {
      System.err.println("CodEmp: " + usuario.getCodigo());
      cuentaService.procRetiro(cuenta, clave, importe, usuario.getCodigo());
      jsonModel.setCode(1);
      jsonModel.setRpta("Proceso ok.");
    } catch (Exception e) {
      jsonModel.setCode(-1);
      jsonModel.setRpta(e.getMessage());
    }
    Gson gson = new Gson();
    return gson.toJson(jsonModel);
  }
  
  
  
          
  
  
  
}
