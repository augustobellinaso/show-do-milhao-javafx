module augustobellinaso.showdomilhao {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;


    exports augustobellinaso.showdomilhao.application;
    opens augustobellinaso.showdomilhao.application to javafx.fxml;
}