package pe.egcc.eureka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"usuario"})
public class CuentaController {
  
  @RequestMapping(value = "conSaldo.htm", method = RequestMethod.GET)
  public String conSaldo(){
    return "conSaldo";
  }
  
  @RequestMapping(value = "procRetiro.htm", method = RequestMethod.GET)
  public String procRetiro(){
    return "procRetiro";
  }
  
  
  
          
  
  
  
}
