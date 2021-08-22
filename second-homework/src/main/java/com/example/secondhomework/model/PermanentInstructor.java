package com.example.secondhomework.model;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{

    private double fixedSalary;

    public PermanentInstructor(String name, String address, String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}
