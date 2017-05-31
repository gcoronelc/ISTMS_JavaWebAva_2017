package pe.egcc.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {
    
    @Autowired
    private MateService mateService;   
    
    public int sumar(int n1, int n2){
        return mateService.sumar(n1, n2);
    }
    
}
