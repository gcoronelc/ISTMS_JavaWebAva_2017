package pe.egcc.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pe.egcc.eureka.model.EmpleadoModel;
import pe.egcc.eureka.service.spec.LogonServiceSpec;

@Controller
@SessionAttributes(value = {"usuario"})
public class AppController {

  @Autowired
  private LogonServiceSpec logonService;

  @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
  public String home() {
    return "index";
  }
  
  @RequestMapping(value = "/main.htm", method = RequestMethod.GET)
  public String main() {
    return "main";
  }

  @RequestMapping(value = "/logon.htm", method = RequestMethod.POST)
  public String logon(
          @RequestParam("usuario") String usuario,
          @RequestParam("clave") String clave,
          Model model
  ) {
    String destino = "main";
    try {
      EmpleadoModel empleado = logonService.validarUsuario(usuario, clave);
      if (empleado == null) {
        throw new Exception("Datos incorrectos.");
      }
      model.addAttribute("usuario", empleado);
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
      destino = "index";
    }
    return destino;
  }

}
