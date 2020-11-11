package sample.components;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import sample.models.PlatillosDAO;

import java.util.Optional;

public class ButtonCustome extends TableCell<PlatillosDAO,String> {

    private Button btnCelda;
    private PlatillosDAO objPlatillo;

    public ButtonCustome(int opc){
        if( opc == 1 ) {
            btnCelda = new Button("Editar");
            btnCelda.setOnAction( event -> {

            });
        }
        else{
            btnCelda = new Button("Borrar");
            btnCelda.setOnAction(event -> {

                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Mensaje del Sistema :)");
                alerta.setHeaderText("Confirmando acción");
                alerta.setContentText("¿Realmente deseas borrar el registro?");
                Optional<ButtonType> result = alerta.showAndWait();
                if( result.get() == ButtonType.OK ){
                    // Obtenemos el objeto de tipo Platillos de acuerdo al renglón seleccionado
                    objPlatillo = ButtonCustome.this.getTableView().getItems().get(ButtonCustome.this.getIndex());
                    objPlatillo.delPlatillo();

                    // Actualizamos el TableView
                    ButtonCustome.this.getTableView().setItems(objPlatillo.getAllPlatillo());
                    ButtonCustome.this.getTableView().refresh();
                }
            });
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty )
            setGraphic(btnCelda);
    }
}
