package com.example.schooladministrator;


import com.example.schooladministrator.Student.Student;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class FileIO {

    static String filename = "student.ser";

    public static void checkStudentIdAlreadyExist() {
        System.out.println("");
    }

    public static  void saveStudents (Student std) throws IOException, ClassNotFoundException {

        boolean studentExist = false;
        std.setCgpa("null");
        try{
            ArrayList<Student> students =  getAllTheStudents();

        for(Student student: students){
            if (student.getStudentId().equals(std.getStudentId())) {
                studentExist = true;
                break;
            }
        }

        if(studentExist){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Same student Id already exist");
            alert.showAndWait();
        } else {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            students.add(std);

            // Method for serialization of object
            out.writeObject(students);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
        }
    }   catch(IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static  void saveStudents (ArrayList<Student> students) throws IOException {
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);

        // Method for serialization of object
        out.writeObject(students);

        out.close();
        file.close();

        System.out.println("Object has been serialized");

    }

    public static ArrayList<Student> getAllTheStudents() throws IOException, ClassNotFoundException {

        ArrayList<Student> students = null;
        // Reading the object from a file
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);

        // Method for deserialization of object
        students = (ArrayList<Student>) in.readObject();

        in.close();
        file.close();

        return students;
    }
}
