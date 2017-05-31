package pe.egcc.app.prueba;

import pe.egcc.app.model.PromModel;
import pe.egcc.app.service.PromService;

public class Prueba01 {
  
  public static void main(String[] args) {
    // Datos
    PromModel model = new PromModel(15, 16, 14, 16, 17, 18);
    // Proceso
    PromService service = new PromService();
    model = service.procesarPromedio(model);
    // Reporte
    System.out.println("Nota Menor: " + model.getPractMenor());    
    System.out.println("Prom. Practica: " + model.getPromPract());    
    System.out.println("Prom. Final: " + model.getPromPract());    
    System.out.println("Estado: " + model.getEstado());    
  }
  
}
