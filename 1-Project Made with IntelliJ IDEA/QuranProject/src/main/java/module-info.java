module com.example.QuranProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ojdbc8;
    requires java.desktop;
    requires java.naming;
    requires jpa;
    requires fontawesomefx;
    requires jasperreports;


    opens com.example.QuranProject to javafx.fxml;
    exports com.example.QuranProject;
}