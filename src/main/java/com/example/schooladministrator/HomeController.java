package com.example.schooladministrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeController {
    @FXML
    private Stage stage;
    private Scene scene;


    public void sceneSwitcher(String path, ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void redirectToAddStudentPage(ActionEvent e) throws IOException {
        sceneSwitcher("add-student.fxml", e);
    }

    public void redirectToUpdateInfoPage(ActionEvent e) throws IOException {
        sceneSwitcher("update-info.fxml", e);
    }
    public void redirectToViewInfoPage(ActionEvent e) throws IOException {
        sceneSwitcher("view-info.fxml", e);
    }
}