package com.example.schooladministrator;


import com.example.schooladministrator.Student.Student;

import java.io.*;

public class FileIO {
    public static void saveToAFile(Student student) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("student.txt", true));
        writer.write(student.toString());
        writer.close();
    }

    public static void readToAFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }
}
