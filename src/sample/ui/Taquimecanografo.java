package sample.ui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Taquimecanografo extends Stage implements EventHandler<KeyEvent> {

    // Bandera para detectar cambios de color en las teclas
    boolean banColor = false;

    // Arreglos para etiquetar los botones del teclado
    private String arLblBtn1[] = {"ESC","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12","PWR"};
    private String arLblBtn2[] = {"º","1","2","3","4","5","6","7","8","9","0","'","¡","BS"};

    // Elementos para el toolbar
    private ToolBar tlbMenu;
    private Button btnAbrir;

    // Elementos para la escritura
    private TextArea txtContenido, txtEscritura;

    // Elementos para el teclado
    private HBox[] arHBoxTeclas = new HBox[6];
    private VBox vBoxTeclado;
    private Button[] arBtnTeclado1 = new Button[14];
    private Button[] arBtnTeclado2 = new Button[14];

    // Elementos de agrupacion global
    private VBox vBoxPrincipal;
    private Scene escena;

    public Taquimecanografo(){
        CrearUI();
        this.setTitle("Tutor de Taquimecanografía");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        CrearToolbar();
        CrearEscritura();
        CrearTeclado();

        vBoxPrincipal = new VBox();
        vBoxPrincipal.getChildren().addAll(tlbMenu,txtContenido,txtEscritura,vBoxTeclado);
        vBoxPrincipal.setSpacing(10);
        vBoxPrincipal.setPadding(new Insets(10));
        escena = new Scene(vBoxPrincipal,800,500);
    }

    private void CrearTeclado() {

        vBoxTeclado = new VBox();
        vBoxTeclado.setSpacing(8);

        for (int i=0; i<arHBoxTeclas.length; i++){
            arHBoxTeclas[i] = new HBox();
            arHBoxTeclas[i].setSpacing(10);
        }

        for( int i=0; i<arBtnTeclado1.length; i++ ){
            arBtnTeclado1[i] = new Button(arLblBtn1[i]);
            arBtnTeclado1[i].setStyle("-fx-background-color: #85D4D6;");
            arBtnTeclado2[i] = new Button(arLblBtn2[i]);
            arBtnTeclado2[i].setStyle("-fx-background-color: #85D4D6;");
            arHBoxTeclas[0].getChildren().addAll(arBtnTeclado1[i]);
            arHBoxTeclas[1].getChildren().add(arBtnTeclado2[i]);
        }

        vBoxTeclado.getChildren().addAll(arHBoxTeclas[0],arHBoxTeclas[1]);
    }

    private void CrearEscritura() {
        txtContenido = new TextArea();
        txtContenido.setEditable(false);
        txtContenido.setPrefRowCount(6);
        txtEscritura = new TextArea();
        txtEscritura.setPrefRowCount(6);
        txtEscritura.setOnKeyPressed(this);
        txtEscritura.setOnKeyReleased(this);
        //addEventHandler(KeyEvent.KEY_TYPED,this);
    }

    private void CrearToolbar() {
        tlbMenu = new ToolBar();
        btnAbrir = new Button();
        btnAbrir.setOnAction(event -> eventoTaqui(1));
        btnAbrir.setPrefSize(25,25);

        // Asignamos la imagen al boton dentro del toolbar
        Image img = new Image("sample/assets/open.png");
        ImageView imv = new ImageView(img);
        imv.setFitHeight(25);
        imv.setPreserveRatio(true);
        btnAbrir.setGraphic(imv);
        tlbMenu.getItems().addAll(btnAbrir);
    }

    private void eventoTaqui(int opc) {
        switch (opc){
            case 1:
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Abrir archivo....");
                File file = fileChooser.showOpenDialog(this);
        }
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode().toString()){
            case "BACK_SPACE":
                if( banColor == false )
                    arBtnTeclado2[13].setStyle("-fx-background-color: #1d1d1d;");
                else
                    arBtnTeclado2[13].setStyle("-fx-background-color: #85D4D6;");
                break;
        }

        banColor = !banColor;
    }
}
