package augustobellinaso.showdomilhao.controller;

import augustobellinaso.showdomilhao.application.ApplicationShowMilhao;
import augustobellinaso.showdomilhao.application.JLayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLayoutTelaNome implements Initializable {

    private static final String PARTICIPANTE = "src/main/resources/augustobellinaso/showdomilhao/songs/vamos-conhecer-agora-o-nosso-participante-voice.mp3";

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/augustobellinaso/showdomilhao/view/LayoutTelaInicial.fxml"));
        pane.getStylesheets().add(getClass().getResource("/augustobellinaso/showdomilhao/css/buttonStyle.css").toExternalForm());
        ApplicationShowMilhao.changeScene(new Scene(pane, 800, 600));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JLayer jLayer = new JLayer();
        jLayer.tocar(new File(PARTICIPANTE));
        jLayer.start();
    }
}
