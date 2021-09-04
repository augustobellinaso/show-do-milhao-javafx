package augustobellinaso.showdomilhao.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static augustobellinaso.showdomilhao.util.ControllerUtil.*;

public class ControllerLayoutTelaRegras {

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        changeLayout(getClass(), "/augustobellinaso/showdomilhao/view/LayoutTelaInicial.fxml","/augustobellinaso/showdomilhao/css/buttonStyle.css");
    }

    @FXML
    private void fechar() {
        exit();
    }


}
