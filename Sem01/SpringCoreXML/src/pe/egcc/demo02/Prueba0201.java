package pe.egcc.demo02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba0201 {

    public static void main(String[] args) {
        // Instanciando el contexto
        String contexto = "/pe/egcc/demo02/contexto.xml";
        BeanFactory beanFactory;
        beanFactory= new ClassPathXmlApplicationContext(contexto);
        // Accediendo al objeto
        MateService mateService = beanFactory.getBean( MateService.class);
        VentaService ventaService = beanFactory.getBean(VentaService.class);
        // Probando el servicio
        System.out.println("7 + 8 = " + mateService.sumar(7, 8));
        System.out.println("Venta = " + ventaService.calVenta(56.8, 6));
    }
    
}
