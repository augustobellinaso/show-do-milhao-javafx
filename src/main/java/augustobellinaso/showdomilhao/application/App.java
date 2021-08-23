package augustobellinaso.showdomilhao.application;

import augustobellinaso.showdomilhao.connection.ConnectionFactory;
import augustobellinaso.showdomilhao.util.LogConfigurator;
import augustobellinaso.showdomilhao.util.LogUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

            Connection connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO jogador (id, nome, pontuacao) VALUES ($next_id, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(2, "Augusto");
                statement.setInt(3, 200);
                statement.execute();
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogConfigurator.configure();
        launch();
    }

}