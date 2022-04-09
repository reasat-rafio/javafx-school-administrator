package com.example.schooladministrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    public void submitAction(ActionEvent e) {
        boolean firstNameIsEmpty =  firstName.getText().length() == 0;
        boolean lastNameIsEmpty =  lastName.getText().length() == 0;
        boolean studentIDIsEmpty =  studentId.getText().length() == 0;
        boolean studentClassIsEmpty =  studentClass.getText().length() == 0;
        boolean birthdateIsEmpty =  birthdate.getValue() == null;
        boolean studentAgeIsEmpty =  studentAge.getText().length() == 0;

        boolean isSubmitAble =
                !firstNameIsEmpty && !lastNameIsEmpty
                        && !studentIDIsEmpty && !studentClassIsEmpty
                        && !birthdateIsEmpty && !studentAgeIsEmpty;

        if(isSubmitAble) {
            System.out.println("Can Submit");

        } else {
            if(firstNameIsEmpty)
                 ErrMessageController(firstNameErrMsg, "First Name Is Required");
             else ErrMessageController(firstNameErrMsg);
             if(lastNameIsEmpty)
                 ErrMessageController(lastNameErrMsg, "Last Name Is Required");
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
