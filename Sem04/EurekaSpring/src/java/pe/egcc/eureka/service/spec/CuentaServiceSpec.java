package pe.egcc.eureka.service.spec;

public interface CuentaServiceSpec {
    
    Double conSaldo(String cuenta);
    
    void procRetiro(String cuenta, String clave, double importe, String codEmp);
    
}
