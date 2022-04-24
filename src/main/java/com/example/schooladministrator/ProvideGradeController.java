package com.example.schooladministrator;

import com.example.schooladministrator.Modules.Subject;
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
import java.util.ArrayList;
import java.util.Objects;
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
    ArrayList<Subject> result = new ArrayList<Subject>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Math", "Science" , "English");
        subjectSelector.setItems(list);
    }

    public void init(Student student) throws IOException, ClassNotFoundException {
        this.student = student;
        name.setText(student.getFirstName() + " " + student.getLastName());
        ID.setText(student.getStudentId());
        subjectSelector.getSelectionModel().selectFirst();

//       result.add(new Subject("Math", 0,0));
//       result.add(new Subject())
    }

    public void selectSubjectAction(ActionEvent event) {}

    public void onSubmitAction(ActionEvent e) {

        String selectedSubject = subjectSelector.getSelectionModel().getSelectedItem();
        int midNum= Integer.parseInt(midNumber.getText());
        int finalNum = Integer.parseInt(finalNumber.getText());

        int index;
        int updateIndex = 0;

        if(result.size() > 0){
            for (index = 0; index < result.size(); index++) {
                if(Objects.equals(selectedSubject, result.get(index).getName())){
                    updateIndex = index;
                } else {
                    updateIndex = -1;
                }
            }
            if(updateIndex >= 0) {
                result.get(updateIndex).setMidNumber(midNum);
                result.get(updateIndex).setFinalNumber(finalNum);
            } else {
                result.add(new Subject(selectedSubject, midNum, finalNum));
            }
        } else {
            result.add(new Subject(selectedSubject, midNum, finalNum));
        }

        for(Subject s:result){
            System.out.println(s.toString());
        }
        System.out.println("----");

    }

    public void redirectToHomeAction(ActionEvent e){}
}
