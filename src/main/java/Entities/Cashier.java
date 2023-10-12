package Entities;

import Enums.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Cashier extends Employee{
    public Cashier(String name, Date dateOfBirth, String gender, String address, String phoneNumber, String email, Designation designation, BigDecimal salary) {
        super(name, dateOfBirth, gender, address, phoneNumber, email, designation, salary);
        //this.addAuthorizations({Responsibilities.Audit, Responsibilities.createRecord});
    }

    @Override
    public String toString() {
        return super.toString();
    }
}