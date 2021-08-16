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

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private final static Logger logger = Logger.getLogger(App.class);

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Janela Java FX");
            LogUtil.getLogger(App.class).info(primaryStage.getTitle());
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogConfigurator.configure();
        launch();
    }

}