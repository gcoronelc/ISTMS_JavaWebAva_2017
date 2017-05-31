package pe.egcc.demo05;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba0501 {

    public static void main(String[] args) {
        // Instanciando el contexto
        String contexto = "/pe/egcc/demo05/contexto.xml";
        BeanFactory beanFactory;
        beanFactory= new ClassPathXmlApplicationContext(contexto);
        // Accediendo al objeto
        AppController appController;
        appController = beanFactory.getBean(AppController.class);
        // Probando el servicio
        System.out.println("7 + 8 = " + appController.sumar(7, 8));
    }
    
}
