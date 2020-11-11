package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.PlatillosDAO;
import sample.models.TipoPlatilloDAO;

public class FrmPlatillos extends Stage {
    private TextField txtPlatillo, txtPrecio;
    private ComboBox<TipoPlatilloDAO> cbxTipo;
    private Button btnGuardar;
    private VBox vBox;
    private Scene escena;
    private PlatillosDAO objPlatillo;

    public FrmPlatillos(){
        CrearUI();
        this.setTitle("Gestión de Platillos");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        txtPlatillo = new TextField();
        txtPrecio = new TextField();
        cbxTipo = new ComboBox<>();
        btnGuardar = new Button("Guardar Platillo");
        btnGuardar.setOnAction(event -> Guardar());
        vBox = new VBox();
        vBox.getChildren().addAll(txtPlatillo,txtPrecio,cbxTipo,btnGuardar);
        escena = new Scene(vBox,250,250);
    }

    private void Guardar() {
        objPlatillo = new PlatillosDAO();
        objPlatillo.setNombre_platillo(txtPlatillo.getText());
        objPlatillo.setPrecio(Float.parseFloat(txtPrecio.getText()));
        objPlatillo.setId_tipo(1);  // Valor fijo temporalmente
        objPlatillo.insPlatillo();
    }
}
