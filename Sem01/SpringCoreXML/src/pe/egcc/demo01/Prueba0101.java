package pe.egcc.demo01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba0101 {

    public static void main(String[] args) {
        // Instanciando el contexto
        String contexto = "/pe/egcc/demo01/contexto.xml";
        BeanFactory beanFactory;
        beanFactory= new ClassPathXmlApplicationContext(contexto);
        // Accediendo al objeto
        MateService service = (MateService) beanFactory.getBean("mateService");
        // Probando el servicio
        System.out.println("7 + 8 = " + service.sumar(7, 8));
    }
    
}
