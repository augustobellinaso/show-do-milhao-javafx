package augustobellinaso.showdomilhao.controller;

import augustobellinaso.showdomilhao.application.ApplicationShowMilhao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControllerLayoutTelaInicial {

    @FXML
    private void jogar(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/augustobellinaso/showdomilhao/view/LayoutTelaNome.fxml"));
        pane.getStylesheets().add(getClass().getResource("/augustobellinaso/showdomilhao/css/buttonStyle.css").toExternalForm());
        ApplicationShowMilhao.changeScene(new Scene(pane, 800, 600));
    }
}
