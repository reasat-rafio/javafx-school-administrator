package com.example.schooladministrator;

import com.example.schooladministrator.Student.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class AddStudentController {
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

    void ErrMessageController (Label errLabel, String message) {
        errLabel.setText(message);
    }
    void ErrMessageController (Label errLabel) {
        errLabel.setText(" ");
    }

    public  void redirectToHomeAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home-view.fxml")));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void submitAction(ActionEvent e) throws IOException, ClassNotFoundException {
        boolean firstNameIsEmpty =  firstName.getText().length() == 0;
        boolean lastNameIsEmpty =  lastName.getText().length() == 0;
        boolean studentIDIsEmpty =  studentId.getText().length() == 0;
        boolean studentClassIsEmpty =  studentClass.getText().length() == 0;
        boolean birthdateIsEmpty =  birthdate.getValue() == null;
        boolean studentAgeIsEmpty =  studentAge.getText().length() == 0;

//?      FLAG TO CHECK IF ANY OF THE FIELDS ARE EMPTY
        boolean isSubmitAble =
                !firstNameIsEmpty && !lastNameIsEmpty
                        && !studentIDIsEmpty && !studentClassIsEmpty
                        && !birthdateIsEmpty && !studentAgeIsEmpty;

        if(isSubmitAble) {
            Student std = new Student(
                    firstName.getText(),lastName.getText(),
                    studentId.getText(), studentAge.getText(),
                    studentClass.getText(),  String.valueOf(birthdate.getValue()));
            FileIO.saveStudents(std);
            FileIO.getAllTheStudents();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(std.getFirstName() + " Added");
            alert.showAndWait();

        } else {
// ->            ERROR MESSAGE
            if(firstNameIsEmpty)
                 ErrMessageController(firstNameErrMsg, "First Name Is Required");
// ->           CLEAN UP
             else ErrMessageController(firstNameErrMsg);

             if(lastNameIsEmpty) ErrMessageController(lastNameErrMsg, "Last Name Is Required");
             else ErrMessageController(lastNameErrMsg);
             if(studentAgeIsEmpty)
                 ErrMessageController(studentAgeErrMsg, "Age Is Required");
             else ErrMessageController(studentAgeErrMsg);
             if(studentClassIsEmpty)
                 ErrMessageController(studentClassErrMsg, "Class Is Required");
             else ErrMessageController(studentClassErrMsg);
             if(birthdateIsEmpty)
                 ErrMessageController(birthdateErrMsg, "Birthdate Is Required");
             else ErrMessageController(birthdateErrMsg);
             if(studentIDIsEmpty)
                 ErrMessageController(studentIdErrMsg, "Id Is Required");
             else ErrMessageController(studentIdErrMsg);
            }
        }
    }
