module com.example.schooladministrator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.schooladministrator to javafx.fxml;
    exports com.example.schooladministrator;
}