package com.example.schooladministrator;


import com.example.schooladministrator.Student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static void checkStudentIdAlreadyExist() {
        System.out.println("");
    }

    public static void saveObjToAFile(Student student) throws IOException {
        // Serialization
        try {
            ArrayList<Student> savedStudents = new ArrayList<Student>();
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            savedStudents.add(student);

            // Method for serialization of object
            out.writeObject(savedStudents);

            out.close();
            file.close();
            System.out.println("Object has been serialized");
        }

        catch(IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static void readObjToAFile() throws IOException, ClassNotFoundException, NotSerializableException {
        ArrayList<Student> students = null;
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            students = (ArrayList<Student>)in.readObject();

            in.close();
            file.close();

            for(Student std: students){
                System.out.println(std);
            }

            System.out.println("Object has been deserialized ");

        }

        catch(IOException ex) {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

}
