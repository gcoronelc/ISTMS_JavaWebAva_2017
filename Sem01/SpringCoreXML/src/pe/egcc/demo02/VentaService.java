package pe.egcc.demo02;

import org.springframework.stereotype.Service;

@Service
public class VentaService {

    public double calVenta(double precio, int cant) {
        return (precio * cant);
    }

}
