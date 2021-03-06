package pe.egcc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.egcc.app.service.MateService;

@Controller
public class AppController {
    
    @Autowired
    private MateService mateService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "index";
    }
    
    @RequestMapping(value = "/procesar.egcc", method = RequestMethod.POST)
    public String procesarSuma(
        @RequestParam("num1") int n1,
        @RequestParam("num2") int n2,
        Model model){
        
        // Proceso
        int suma = mateService.sumar(n1, n2);
        
        // Reporte
        model.addAttribute("n1", n1);
        model.addAttribute("n2", n2);
        model.addAttribute("suma", suma);
        return "index";
    }
}
