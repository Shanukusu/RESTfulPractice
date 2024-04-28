package com.example.springapi.api.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String pasportNumber;
    private String pasportDate;
    private double salary;

    public Worker( String name, String surname, String pasportNumber, String pasportDate, double salary){
        this.name = name;
        this.surname = surname;
        this.pasportNumber = pasportNumber;
        this.pasportDate = pasportDate;
        this.salary = salary;
    }

    public Long getId(){
        return id;
    }

    /*
    public void setId(int id){
        this.id = id;
    }
    */

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
