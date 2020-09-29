package sample.ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.events.EventosMemorama;

public class Memorama extends Stage implements EventHandler {

    private Label lblTarjetas;
    private TextField txtNoTarjetas;
    private Button btnAceptar, btnAceptar2;
    private HBox hBox;
    private VBox vBox;
    private GridPane gdpMesa;
    private Button[][] arTarjetas;

    private int noPares;
    private Scene escena;

    public Memorama(){

        CrearUI();
        this.setTitle("Memorama :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        lblTarjetas = new Label("Número de Pares:");
        txtNoTarjetas = new TextField();
        btnAceptar = new Button("Voltear y revolver");
        btnAceptar2 = new Button("Nuevo mensaje");
        btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED,this);
        //btnAceptar2.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventosMemorama(2));
        /*btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventosMemorama());
        btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Aqui va el mensaje");
            }
        });*/

        hBox = new HBox();
        hBox.getChildren().addAll(lblTarjetas,txtNoTarjetas,btnAceptar,btnAceptar2);
        hBox.setSpacing(10);

        gdpMesa = new GridPane();
        vBox = new VBox();
        vBox.getChildren().addAll(hBox,gdpMesa);

        escena = new Scene (vBox,500,500);
    }

    @Override
    public void handle(Event event) {

        noPares = Integer.parseInt(txtNoTarjetas.getText());

        vBox.getChildren().remove(gdpMesa);

        gdpMesa = new GridPane();
        arTarjetas = new Button[2][noPares];
        for (int i=0; i<2; i++){
            for( int j=0; j<noPares; j++){
                arTarjetas[i][j] = new Button("X");
                gdpMesa.add(arTarjetas[i][j],j,i);
            }
        }

        vBox.getChildren().add(gdpMesa);
    }
}
