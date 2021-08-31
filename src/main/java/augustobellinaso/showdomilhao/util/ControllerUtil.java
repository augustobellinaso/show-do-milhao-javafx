package augustobellinaso.showdomilhao.util;

import augustobellinaso.showdomilhao.application.ApplicationShowMilhao;
import augustobellinaso.showdomilhao.application.JLayer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;

public class ControllerUtil {

    private ControllerUtil() {

    }

    public static void exit() {
        System.exit(0);
    }

    public static void changeVoice(String voice) {
        JLayer jLayer = new JLayer();
        jLayer.tocar(new File(voice));
        jLayer.start();
    }

    public static void changeLayout(Class<?> classe, String layout, String css) throws IOException {
        AnchorPane pane = FXMLLoader.load(classe.getResource(layout));
        pane.getStylesheets().add(classe.getResource(css).toExternalForm());
        ApplicationShowMilhao.changeScene(new Scene(pane, 800, 600));
    }
}
