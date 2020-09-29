package sample.events;

import javafx.event.Event;
import javafx.event.EventHandler;

public class EventosMemorama implements EventHandler {

    int opcion; // Variable de clase

    public EventosMemorama(int opc){
        opcion = opc;
    }

    @Override
    public void handle(Event event) {
        if( opcion == 1 ){
            System.out.println("Presionaste el primer boton");
        }else{
            System.out.println("Presionaste el segundo boton");
        }
    }

    private void llenarLista(){
        // todo el codigo para llenar la lista
    }
}
