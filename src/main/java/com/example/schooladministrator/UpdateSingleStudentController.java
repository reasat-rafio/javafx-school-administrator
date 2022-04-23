package com.example.schooladministrator;

import com.example.schooladministrator.Student.Student;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public void init(Student std) {
        firstName.setText(std.getFirstName());
        lastName.setText(std.getLastName());
        studentId.setText(std.getStudentId());
        studentAge.setText(std.getStudentAge());
        studentClass.setText(std.getStudentAge());
        birthdate.setValue(LocalDate.parse(String.valueOf(std.getBirthdate())));
    }
}
