package augustobellinaso.showdomilhao;

import java.io.IOException;

import augustobellinaso.showdomilhao.application.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}