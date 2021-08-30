package augustobellinaso.showdomilhao.application;

import augustobellinaso.showdomilhao.util.LogConfigurator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String FILE_MUSIC = "src/main/resources/augustobellinaso/showdomilhao/songs/som-abertura-2.mp3";

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Show do Milhão");

            Pane telaInicial = FXMLLoader.load(getClass().getResource("/augustobellinaso/showdomilhao/view/LayoutTelaInicial.fxml"));
            Scene scene = new Scene(telaInicial, 800, 600);

            telaInicial.getStylesheets().add(getClass().getResource("/augustobellinaso/showdomilhao/css/buttonStyle.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

            ContinuousReproduction reproduction = new ContinuousReproduction(FILE_MUSIC, false);
            reproduction.start();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogConfigurator.configure();
        launch();
    }

}