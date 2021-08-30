module augustobellinaso.showdomilhao {
    opens augustobellinaso.showdomilhao.controller;

    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;
    requires jlayer;
    requires java.sql;
    requires java.desktop;


    exports augustobellinaso.showdomilhao.application;
    opens augustobellinaso.showdomilhao.application to javafx.fxml;
}