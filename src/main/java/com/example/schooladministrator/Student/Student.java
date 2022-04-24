package com.example.schooladministrator.Student;

import com.example.schooladministrator.Modules.Subject;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Student implements Serializable {
    private static final long serialVersionUID = 652968098267757690L;

    private String firstName;
    private String lastName;
    private String studentId;
    private String studentAge;
    private String studentClass;
    private String birthdate;
    private String cgpa;
    private ArrayList<Subject> result;


    public Student(String firstName, String lastName, String studentId, String studentAge, String studentClass, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.studentAge = studentAge;
        this.studentClass = studentClass;
        this.birthdate = birthdate;
    }

    public ArrayList<Subject> getResult() {
        return result;
    }

    public void setResult(ArrayList<Subject> result) {
        this.result = result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }


    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", studentAge='" + studentAge + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", cgpa='" + cgpa + '\'' +
                ", result=" + result +
                '}';
    }
}
