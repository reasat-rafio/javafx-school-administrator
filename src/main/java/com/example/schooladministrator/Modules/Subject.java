package com.example.schooladministrator.Modules;

import java.io.Serializable;

public class Subject implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    String name;
    int midNumber;
    int finalNumber;

    public Subject(String name, int midNumber, int finalNumber) {
        this.name = name;
        this.midNumber = midNumber;
        this.finalNumber = finalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMidNumber() {
        return midNumber;
    }

    public void setMidNumber(int midNumber) {
        this.midNumber = midNumber;
    }

    public int getFinalNumber() {
        return finalNumber;
    }

    public void setFinalNumber(int finalNumber) {
        this.finalNumber = finalNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", midNumber=" + midNumber +
                ", finalNumber=" + finalNumber +
                '}';
    }
}
