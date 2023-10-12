package Entities;

import Enums.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Employee extends Person {
    private BigDecimal salary;
    private Designation designation;
    private List<Responsibilities> authorizations;

    public Employee(String name, Date dateOfBirth, String gender, String address, String phoneNumber, String email, Designation designation, BigDecimal salary) {
        super(name, dateOfBirth, gender, address, phoneNumber, email);
        this.designation = designation;
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public List<Responsibilities> getAuthorizations() {
        return authorizations;
    }
    public void addAuthorizations(List<Responsibilities> authorizations) {
        this.authorizations.addAll(authorizations);
    }
    public void revokeAuthorizations(List<Responsibilities> authorizations) {
        this.authorizations.removeAll(authorizations);
    }
    @Override
    public String toString() {
        return super.toString().replace("}", ", salary=" + salary.toString() + ", designation=" + designation.toString() + ", authorizations=" + authorizations.toString() + '}');
    }
}
