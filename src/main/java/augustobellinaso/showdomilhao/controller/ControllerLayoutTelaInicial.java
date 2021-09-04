package augustobellinaso.showdomilhao.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static augustobellinaso.showdomilhao.util.ControllerUtil.changeLayout;
import static augustobellinaso.showdomilhao.util.ControllerUtil.exit;

public class ControllerLayoutTelaInicial {

    @FXML
    private void jogar(ActionEvent event) throws IOException {
        changeLayout(getClass(),"/augustobellinaso/showdomilhao/view/LayoutTelaNome.fxml", "/augustobellinaso/showdomilhao/css/buttonStyle.css");
    }

    @FXML
    private void fechar() {
        exit();
    }

    @FXML
    private void verRegras(ActionEvent event) throws IOException {
        changeLayout(getClass(),"/augustobellinaso/showdomilhao/view/LayoutTelaRegras.fxml", "/augustobellinaso/showdomilhao/css/regrasStyle.css");
    }

}
