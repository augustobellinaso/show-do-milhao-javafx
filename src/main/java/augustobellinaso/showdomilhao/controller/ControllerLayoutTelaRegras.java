package augustobellinaso.showdomilhao.controller;

import augustobellinaso.showdomilhao.util.RegrasUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static augustobellinaso.showdomilhao.util.ControllerUtil.*;

public class ControllerLayoutTelaRegras implements Initializable {

    @FXML
    private Label labelRegras;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelRegras.setText(RegrasUtil.getRegras());
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        changeLayout(getClass(), "/augustobellinaso/showdomilhao/view/LayoutTelaInicial.fxml","/augustobellinaso/showdomilhao/css/buttonStyle.css");
    }

    @FXML
    private void fechar() {
        exit();
    }


}
