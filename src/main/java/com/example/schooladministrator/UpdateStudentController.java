package com.example.schooladministrator;

import com.example.schooladministrator.Student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    ObservableList<Student> list = FXCollections.observableArrayList();

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

        editCol.setCellFactory(ActionButtonTableCell.<Student>forTableColumn("Edit", (Student p) -> {
            studentTable.getItems().remove(p);
            return p;
        }));

        removeCol.setCellFactory(ActionButtonTableCell.<Student>forTableColumn("Remove", (Student p) -> {
            studentTable.getItems().remove(p);
            return p;
        }));

        ArrayList<Student> allStudents = FileIO.getAllTheStudents();
        System.out.println(allStudents);
        list.addAll(allStudents);
        studentTable.setItems(list);
    }
}
