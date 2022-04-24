package com.example.schooladministrator;

import com.example.schooladministrator.Modules.Subject;
import com.example.schooladministrator.Student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    @FXML
    private Button insertBtn;

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
        insertBtn.setText("Insert " + subjectSelector.getSelectionModel().getSelectedItem() + " Numbers");
    }

    public void selectSubjectAction(ActionEvent event) {
        String selectedSubject = subjectSelector.getSelectionModel().getSelectedItem();
        int updateIndex = 0;
        if(result.size() > 0) {
            for (int i = 0; i < result.size(); i++) {
                if(Objects.equals(selectedSubject, result.get(i).getName())) {
                    updateIndex = i;
                    }
                else {
                    updateIndex = -1;
                }
                }
            if(updateIndex >= 0){
                System.out.println(result.get(updateIndex));
//                midNumber.setText(String.valueOf(result.get(updateIndex).getMidNumber()));
//                finalNumber.setText(String.valueOf(result.get(updateIndex).getFinalNumber()));
            } else {
//                midNumber.setText("");
//                finalNumber.setText("");
            }
        }


        System.out.println(subjectSelector.getSelectionModel().getSelectedItem());
    }

    public void onInsertAction(ActionEvent event) {
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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(selectedSubject + "'s number updated");
                alert.showAndWait();
                result.get(updateIndex).setMidNumber(midNum);
                result.get(updateIndex).setFinalNumber(finalNum);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(selectedSubject + "'s number added");
                alert.showAndWait();
                result.add(new Subject(selectedSubject, midNum, finalNum));
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(selectedSubject + "'s number added");
            alert.showAndWait();
            result.add(new Subject(selectedSubject, midNum, finalNum));
        }

    }

    public void onSubmitAction(ActionEvent e) {
        for(Subject s:result){
            System.out.println(s.toString());
        }
        System.out.println("----");

    }

    public void redirectToHomeAction(ActionEvent e){}
}
