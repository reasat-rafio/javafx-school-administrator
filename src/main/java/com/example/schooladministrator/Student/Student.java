package com.example.schooladministrator.Student;

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String studentAge;
    private String studentClass;
    private String birthdate;

    public Student(String firstName, String lastName, String studentId, String studentAge, String studentClass, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.studentAge = studentAge;
        this.studentClass = studentClass;
        this.birthdate = birthdate;
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

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", studentAge='" + studentAge + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
