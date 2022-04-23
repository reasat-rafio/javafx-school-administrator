package com.example.schooladministrator;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class UpdateStudentController implements Initializable {
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> idCol;
    @FXML
    private TableColumn<Student, String> nameCol;
    @FXML
    private TableColumn<Student, String> birthCol;
    @FXML
    private TableColumn<Student, String> ageCol;
    @FXML
    private TableColumn<Student, String> classCol;
    @FXML
    private TableColumn<Student, String> cgpaCol;

    @FXML
    private TableColumn<Student, Button> editCol;

    @FXML
    private TableColumn<Student, Button> removeCol;

    ArrayList<Student> students;

    ObservableList<Student> list = FXCollections.observableArrayList();

    public UpdateStudentController() throws IOException, ClassNotFoundException {
        this.students = FileIO.getAllTheStudents();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadData();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private  void loadData() throws IOException, ClassNotFoundException {
        idCol.setCellValueFactory(new PropertyValueFactory<Student, String>("studentId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        birthCol.setCellValueFactory(new PropertyValueFactory<Student, String>("birthdate"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Student, String>("studentAge"));
        classCol.setCellValueFactory(new PropertyValueFactory<Student, String>("studentClass"));
        cgpaCol.setCellValueFactory(new PropertyValueFactory<Student, String>("cgpa"));
//        actionCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        editCol.setCellFactory(ActionButtonTableCell.<Student>forTableColumn("Edit", true, (Student p) -> {
            return p;
        }));

        removeCol.setCellFactory(ActionButtonTableCell.<Student>forTableColumn("Remove", false, (Student p) -> {
            int selectedStudentsIndex = 0;

            for(int i = 0; i<=students.size(); i++){
                if(Objects.equals(students.get(i).getStudentId(), p.getStudentId())){
                    selectedStudentsIndex = i;
                    break;
                }
            }

            students.remove(selectedStudentsIndex);

            try {
                FileIO.saveStudents(students);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            studentTable.getItems().remove(p);
            return p;
        }));

        ArrayList<Student> allStudents = FileIO.getAllTheStudents();
        System.out.println(allStudents);
        list.addAll(allStudents);
        studentTable.setItems(list);
    }

    public void addStudentAction (ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-student.fxml")));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
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

}
