module com.example.schooladministrator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
//    requires de.jensd.fx.fontawesomefx.fontawesome;

    opens com.example.schooladministrator to javafx.fxml;
    exports com.example.schooladministrator;
}