package com.example.springapi.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String passportNumber;
    private String passportDate;
    private double salary;

    public WorkerEntity(String name, String surname, String passportNumber, String passportDate, double salary) {
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
        this.passportDate = passportDate;
        this.salary = salary;
    }
}
