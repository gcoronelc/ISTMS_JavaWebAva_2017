package pe.egcc.app.service;

import java.util.Arrays;
import org.springframework.stereotype.Service;
import pe.egcc.app.model.PromModel;

@Service
public class PromService {

  public PromModel procesarPromedio(PromModel model){
    // Proceso
    int menor = calcMenor(model.getPract1(), model.getPract2(),
            model.getPract3(), model.getPract4());
    int proPract = (model.getPract1() + model.getPract2() 
            + model.getPract3() + model.getPract4() 
            - menor) / 3;
    int proFinal = (proPract + model.getExaParcial() 
            + model.getExaFinal()) / 3;
    String estado = (proFinal >= 13)?"Aprobado":"Desaprobado";
    // Reporte
    model.setPractMenor(menor);
    model.setPromPract(proPract);
    model.setPromFinal(proFinal);
    model.setEstado(estado);
    return model;
  }

  private int calcMenor(int ... notas) {
    Arrays.sort(notas);
    return notas[0];
  }
  
}
