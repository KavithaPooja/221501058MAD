package com.example.exe04_test04;

public class Student {
    public String rollNo;
    public String name;
    public String address;
    public String fatherMobileNumber;
    public String motherMobileNumber;
    public String personalMobileNumber;
    public double sem1GPA;
    public double sem2GPA;
    public double sem3GPA;
    public double sem4GPA;
    public double cgpa;
    public String govtOrManagement;
    public String dayScholarOrHosteler;
    public String community;

    // Constructor
    public Student(String rollNo, String name, String address, String fatherMobileNumber,
                   String motherMobileNumber, String personalMobileNumber, double sem1GPA,
                   double sem2GPA, double sem3GPA, double sem4GPA, double cgpa,
                   String govtOrManagement, String dayScholarOrHosteler, String community) {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
        this.fatherMobileNumber = fatherMobileNumber;
        this.motherMobileNumber = motherMobileNumber;
        this.personalMobileNumber = personalMobileNumber;
        this.sem1GPA = sem1GPA;
        this.sem2GPA = sem2GPA;
        this.sem3GPA = sem3GPA;
        this.sem4GPA = sem4GPA;
        this.cgpa = cgpa;
        this.govtOrManagement = govtOrManagement;
        this.dayScholarOrHosteler = dayScholarOrHosteler;
        this.community = community;
    }
}