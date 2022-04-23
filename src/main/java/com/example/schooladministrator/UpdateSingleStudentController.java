package com.example.schooladministrator;

import com.example.schooladministrator.Student.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class UpdateSingleStudentController {
    @FXML
    private TextField firstName;
    @FXML
    private Label firstNameErrMsg;
    @FXML
    private TextField lastName;
    @FXML
    private Label lastNameErrMsg;
    @FXML
    private TextField studentId;
    @FXML
    private Label studentIdErrMsg;
    @FXML
    private TextField studentAge;
    @FXML
    private Label studentAgeErrMsg;
    @FXML
    private TextField studentClass;
    @FXML
    private Label studentClassErrMsg;
    @FXML
    private DatePicker birthdate;
    @FXML
    private Label birthdateErrMsg;

    Student student;
    ArrayList<Student> allStudents;
    int selectedStudentIndex = 0;

    public void init(Student std) throws IOException, ClassNotFoundException {
        student = std;

        allStudents = FileIO.getAllTheStudents();

        firstName.setText(std.getFirstName());
        lastName.setText(std.getLastName());
        studentId.setText(std.getStudentId());
        studentAge.setText(std.getStudentAge());
        studentClass.setText(std.getStudentAge());
        birthdate.setValue(LocalDate.parse(String.valueOf(std.getBirthdate())));
    }

    public void  onSubmit(ActionEvent e) throws IOException {

        student.setStudentId(studentId.getText());
        student.setStudentAge(studentAge.getText());
        student.setStudentClass(studentClass.getText());
        student.setBirthdate(String.valueOf(birthdate.getValue()));
        student.setFirstName(firstName.getText());
        student.setLastName(lastName.getText());

        for(int i = 0; i <= allStudents.size(); i++){
            if(Objects.equals(student.getStudentId(), allStudents.get(i).getStudentId())) {
                selectedStudentIndex = i;
                break;
            }
        }

        allStudents.set(selectedStudentIndex,student);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("update-info.fxml")));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
