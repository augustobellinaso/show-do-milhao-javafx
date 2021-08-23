module augustobellinaso.showdomilhao {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;
    requires jlayer;
    requires java.sql;


    exports augustobellinaso.showdomilhao.application;
    opens augustobellinaso.showdomilhao.application to javafx.fxml;
}