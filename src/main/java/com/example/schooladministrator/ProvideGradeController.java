package com.example.schooladministrator;

import com.example.schooladministrator.Student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProvideGradeController implements Initializable {
    @FXML
    Text name;
    @FXML
    Text ID;
    @FXML
    private TextField midNumber;
    @FXML
    private TextField finalNumber;
    @FXML
    private ComboBox<String> subjectSelector;

    Student student;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList(" Math", "Science" , "English");
        subjectSelector.setItems(list);
    }

    public void init(Student student) throws IOException, ClassNotFoundException {
        this.student = student;
        name.setText(student.getFirstName() + " " + student.getLastName());
        ID.setText(student.getStudentId());
        subjectSelector.getSelectionModel().selectFirst();
    }

    public void selectSubjectAction(ActionEvent event) {
        String selectedSubject = subjectSelector.getSelectionModel().getSelectedItem().toString();
    }

    public void onSubmitAction(ActionEvent e) {

    }

    public void redirectToHomeAction(ActionEvent e){}




}
