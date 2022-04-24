package com.example.schooladministrator;

import com.example.schooladministrator.Student.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EditStudentController {

    @FXML
    Text title;

    Student student;

    public void init(Student student){
        this.student = student;
        title.setText("Update " + student.getFirstName() + "'s" + " Info");
    }

    public void redirectToUpdateStudentBackGroundAction (ActionEvent e) throws IOException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("update-student-general-info.fxml"));
        Parent root = (Parent) loader.load();
        UpdateSingleGeneralInfoController controller = loader.getController();

        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        controller.init(student);
    }

    public void redirectToProvideGradeAction(ActionEvent e) throws IOException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("provide-grade.fxml"));
        Parent root = (Parent) loader.load();
        ProvideGradeController controller = loader.getController();

        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        controller.init(student);
    }

}
