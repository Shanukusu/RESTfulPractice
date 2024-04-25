package com.example.springapi.api.model;

public class Worker {

    private int id;
    private String name;
    private String surname;
    private String pasportNumber;
    private String pasportDate;
    private double salary;

    public Worker(int id, String name, String surname, String pasportNumber, String pasportDate, double salary){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pasportNumber = pasportNumber;
        this.pasportDate = pasportDate;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getPasportNumber(){
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber){
        this.pasportNumber = pasportNumber;
    }

    public String getPasportDate(){
        return pasportDate;
    }

    public void setPasportDate(String pasportDate){
        this.pasportDate = pasportDate;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
}