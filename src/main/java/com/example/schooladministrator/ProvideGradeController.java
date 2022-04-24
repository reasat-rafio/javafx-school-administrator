package com.example.schooladministrator;

import com.example.schooladministrator.Modules.Subject;
import com.example.schooladministrator.Student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

    boolean isExist = false;
    Student student;
    ArrayList<Subject> result = new ArrayList<Subject>();

    ArrayList<Student> allStudents;

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
        allStudents = FileIO.getAllTheStudents();

        if(student.getCgpa() != null){
            isExist = true;
        }

        if(isExist){
            midNumber.setText(String.valueOf(student.getResult().get(0).getMidNumber()));
            finalNumber.setText(String.valueOf(student.getResult().get(0).getFinalNumber()));
        }

    }

    public void selectSubjectAction(ActionEvent event) {
        String selectedSubject = subjectSelector.getSelectionModel().getSelectedItem();
        insertBtn.setText("Insert " + selectedSubject + " Numbers");
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

            if(isExist){
                midNumber.setText(String.valueOf(student.getResult().get(updateIndex).getMidNumber()));
                finalNumber.setText(String.valueOf(student.getResult().get(updateIndex).getMidNumber()));
            }

//            if(updateIndex >= 0){
//                System.out.println(result.get(updateIndex));
//                midNumber.setText(String.valueOf(result.get(updateIndex).getMidNumber()));
//                finalNumber.setText(String.valueOf(result.get(updateIndex).getFinalNumber()));
//            } else {
//                midNumber.setText("");
//                finalNumber.setText("");
//            }
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

    public void onSubmitAction(ActionEvent e) throws IOException {
        int selectedStudentIndex = 0;
        int totalMarks = 0;

        for(int i = 0; i < allStudents.size(); i++) {
            if(Objects.equals(allStudents.get(i).getStudentId(), student.getStudentId())){
                selectedStudentIndex = i;
            }
        }

        allStudents.get(selectedStudentIndex).setResult(result);

        for(int i = 0; i < allStudents.get(selectedStudentIndex).getResult().size(); i++){
            totalMarks += allStudents.get(selectedStudentIndex).getResult().get(i).getMidNumber()
                    +  allStudents.get(selectedStudentIndex).getResult().get(i).getFinalNumber();
        }


        int avgMarks = totalMarks / 3;

        if(avgMarks >= 80 ){
            allStudents.get(selectedStudentIndex).setCgpa("A");
        } else if(avgMarks > 60){
            allStudents.get(selectedStudentIndex).setCgpa("B");
        } else if(avgMarks > 50){
            allStudents.get(selectedStudentIndex).setCgpa("C");
        } else if(avgMarks > 40){
            allStudents.get(selectedStudentIndex).setCgpa("D");
        } else {
            allStudents.get(selectedStudentIndex).setCgpa("F");
        }
        System.out.println(totalMarks / 3);

        FileIO.saveStudents(allStudents);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Grade Updated");
        alert.showAndWait();

    }

    public void redirectToHomeAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student-list.fxml")));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
