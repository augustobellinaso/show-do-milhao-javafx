package augustobellinaso.showdomilhao.application;

import augustobellinaso.showdomilhao.util.LogConfigurator;
import augustobellinaso.showdomilhao.util.LogUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String FILE_MUSIC = "src/main/resources/augustobellinaso/showdomilhao/songs/som-abertura-2.mp3";

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Janela Java FX");
            LogUtil.getLogger(App.class).info(primaryStage.getTitle());
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();

            ContinuousReproduction reproduction = new ContinuousReproduction(FILE_MUSIC, false);
            reproduction.start();
//            JLayer jLayer = new JLayer();
//            File mp3 = new File("src/main/resources/augustobellinaso/showdomilhao/songs/tire-a-carta-do-baralho-voice.mp3");
//            jLayer.tocar(mp3);
//            jLayer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogConfigurator.configure();
        launch();
    }

}