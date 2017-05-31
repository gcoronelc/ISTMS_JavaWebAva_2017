package pe.egcc.demo04;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba0401 {

    public static void main(String[] args) {
        // Instanciando el contexto
        String contexto = "/pe/egcc/demo04/contexto.xml";
        BeanFactory beanFactory;
        beanFactory= new ClassPathXmlApplicationContext(contexto);
        // Accediendo al objeto
        AppController appController;
        appController = beanFactory.getBean(AppController.class);
        // Probando el servicio
        System.out.println("7 + 8 = " + appController.sumar(7, 8));
    }
    
}
