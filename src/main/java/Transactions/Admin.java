package Transactions;

import Entities.Employee;
import Enums.Designation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Admin {
    // TODO: implement methods to hire, promote, terminate, query, suspend, warn, reward, etc.
    public int generateEmployeeId() {
        return new AtomicInteger(1000).getAndIncrement();
    }
    public void assignEmployeeDesignation(Employee employee, Designation designation) {
        employee.setDesignation(designation);
    }
    public void terminateEmployee(Employee employee) {
        System.out.println(employee.getName() + " has been terminated.");
        employee = null;
        System.gc();
    }
    public Employee hireEmployee(String name, Date dateOfBirth, String gender, String address, String phoneNumber, String email, BigDecimal salary) {
        return new Employee(name, dateOfBirth, gender, address, phoneNumber, email, salary);
    }
    public void promoteEmployee() {
        System.out.println("Employee promoted.");
        System.gc();
    }
}
