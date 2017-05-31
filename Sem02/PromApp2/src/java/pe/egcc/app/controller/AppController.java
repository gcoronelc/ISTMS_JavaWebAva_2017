package pe.egcc.app.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.egcc.app.model.PromModel;
import pe.egcc.app.service.PromService;

@Controller
public class AppController {

  @Autowired
  private PromService promService;
  
  @RequestMapping(value = "index.htm", method = RequestMethod.GET)
  public String home() {
    return "index";
  }

  @RequestMapping(value = "procesar.htm", 
          method = RequestMethod.POST,
          produces = "text/plain")
  @ResponseBody
  public String procesar(
          @ModelAttribute PromModel promModel
  ) {
    // Proceso
    promModel = promService.procesarPromedio(promModel);
    // Reporte
    Gson gson = new Gson();
    String json = gson.toJson(promModel);
    return json;
  }

}
