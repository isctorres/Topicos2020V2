package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.ui.Memorama;
import sample.ui.Taquimecanografo;

public class Main extends Application implements EventHandler {

    private VBox vPrincipal;

    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menSalir;
    private MenuItem itmMemorama, itmPractica2, itmTerminar;
    private Scene escena;

    private ToolBar tlbMenu;
    private Button btnToolbar1;

    @Override
    public void start(Stage primaryStage) throws Exception{

        CrearUI();
        primaryStage.setTitle("Prácticas de Tópicos 2020");
        primaryStage.setMaximized(true);
        primaryStage.setScene(escena);
        primaryStage.addEventHandler(WindowEvent.WINDOW_HIDDEN,this);
        primaryStage.show();
    }

    private void CrearUI() {
        mnbPrincipal = new MenuBar();

        // Creación de los menus
        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Competencia 2");
        menSalir        = new Menu("Salir");

        // Cargar los menus a la barra de menus
        mnbPrincipal.getMenus().addAll(menCompetencia1,menCompetencia2,menSalir);

        // Creamos el menuItem para el memorama de la primer competencia
        itmMemorama = new MenuItem("Memorama");
        itmMemorama.setOnAction(event -> opcionMenu(1));

        itmPractica2 = new MenuItem("Taquimecanógrafo");
        itmPractica2.setOnAction(event -> opcionMenu(2));

        itmTerminar = new MenuItem("Hasta pronto :)");
        itmTerminar.setOnAction(event -> { System.exit(0);});
        // Cargar el item Memorama al menu "competencia1"
        menCompetencia1.getItems().addAll(itmMemorama,itmPractica2);
        menSalir.getItems().add(itmTerminar);

        // Crear una barra de herramientas
        tlbMenu = new ToolBar();
        btnToolbar1 = new Button();
        btnToolbar1.setOnAction(event -> opcionMenu(1));
        btnToolbar1.setPrefSize(35,35);

        // Asignamos la imagen al boton dentro del toolbar
        Image img = new Image("sample/assets/game.png");
        ImageView imv = new ImageView(img);
        imv.setFitHeight(35);
        imv.setPreserveRatio(true);
        btnToolbar1.setGraphic(imv);

        tlbMenu.getItems().add(btnToolbar1);

        vPrincipal = new VBox();
        vPrincipal.getChildren().addAll(mnbPrincipal,tlbMenu);
        escena = new Scene(vPrincipal);
    }

    private void opcionMenu(int opc) {
        switch(opc){
            case 1: new Memorama();         break;
            case 2: new Taquimecanografo(); break;
            case 3: break;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        System.out.println("Se esta mostrando la pantalla");
    }
}
