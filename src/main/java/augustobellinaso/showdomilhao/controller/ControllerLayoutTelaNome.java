package augustobellinaso.showdomilhao.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static augustobellinaso.showdomilhao.util.ControllerUtil.*;

public class ControllerLayoutTelaNome implements Initializable {

    private static final String PARTICIPANTE_VOICE = "src/main/resources/augustobellinaso/showdomilhao/songs/vamos-conhecer-agora-o-nosso-participante-voice.mp3";
    private static final String START_GAME_VOICE = "src/main/resources/augustobellinaso/showdomilhao/songs/vai-comecar-o-show-do-milhao-voice.mp3";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changeVoice(PARTICIPANTE_VOICE);
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        changeLayout(getClass(), "/augustobellinaso/showdomilhao/view/LayoutTelaInicial.fxml","/augustobellinaso/showdomilhao/css/buttonStyle.css");
    }

    @FXML
    private void startGame(ActionEvent event) throws IOException {
        changeLayout(getClass(), "/augustobellinaso/showdomilhao/view/LayoutTelaPrincipal.fxml", "/augustobellinaso/showdomilhao/css/buttonStyle.css");
        changeVoice(START_GAME_VOICE);
    }

    @FXML
    private void fechar() {
        exit();
    }


}
