module augustobellinaso.showdomilhao {
    requires javafx.controls;
    requires javafx.fxml;

    opens augustobellinaso.showdomilhao to javafx.fxml;
    exports augustobellinaso.showdomilhao;
    exports augustobellinaso.showdomilhao.application;
    opens augustobellinaso.showdomilhao.application to javafx.fxml;
}