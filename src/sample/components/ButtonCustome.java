package sample.components;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.models.PlatillosDAO;

public class ButtonCustome extends TableCell<PlatillosDAO,String> {

    private Button btnCelda;

    public ButtonCustome(int opc){
        if( opc == 1 )
            btnCelda = new Button("Editar");
        else
            btnCelda = new Button("Borrar");
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty )
            setGraphic(btnCelda);
    }
}
