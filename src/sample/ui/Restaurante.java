package sample.ui;

import javafx.stage.Stage;

public class Restaurante extends Stage {

    public Restaurante(){

        CrearUI();
        this.setTitle("Restaurante :)");
        this.show();
    }

    private void CrearUI() {
    }
}

// Java (Clase) -> MySQL(Tabla)
// Java (Objeto) -> MySQL(Registro/Renglon)

// Empleados             (ok)
// Clientes (Domicilio)  (ok)
// Platillos (Precio)    (ok)
// Tipo de Platillo      (ok)
// Insumos (Existencia)
// Proveedores
// Pedidos               (ok)
// Sucursales
// Tipos de pago
// Reservacion
// Mesas                 (ok)
// Tipo de pedido (Enviar/En Restaurante/Llevar)


//                      Mesas
//                       (1)
//                        |
//                       (N)
// Empleados (1) - (N) Pedido (N) - (1) Clientes
//                       (N)
//                        |-------- DetallePedido (Cantidad/Precio/Descuento)
//                       (N)
//                    Platillos (N) - (1) Tipo_Platillo

// 1:N -> La llave primaria de los 1´s pasa a la de los N´s
//

// DAO (Object Access Data)