package Handlers;

import Entities.*;

import java.util.ArrayList;
import java.util.List;

public class RecordsHandler {

    private static List<Person> personList = new ArrayList<>();
    private static List<Employee> employeeList = new ArrayList<>();
    private static List<Manager> managerList = new ArrayList<>();
    private static List<Cashier> cashierList = new ArrayList<>();
    private static List<Customer> customerList = new ArrayList<>();
    public static void addToPersonList(Person person) {
        RecordsHandler.personList.add(person);
    }

    public static void removeFromPersonList(Person person) {
        personList.remove(person);
    }

    public static List<Person> getPersonList() {
        return personList;
    }

    public static void addToEmployeeList(Employee employee) {
        employeeList.add(employee);
    }

    public static void removeFromEmployeeList(Employee employee) {
        employeeList.remove(employee);
    }

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }
    public static void addToCashierList(Cashier cashier) {
        cashierList.add(cashier);
    }

    public static void removeFromCashierList(Cashier cashier) {
        cashierList.remove(cashier);
    }

    public static List<Cashier> getCashierList() {
        return cashierList;
    }
    public static void addToManagerList(Manager manager) {
        managerList.add(manager);
    }

    public static void removeFromManagerList(Manager manager) {
        managerList.remove(manager);
    }

    public static List<Manager> getManagerList() {
        return managerList;
    }

    public static void addToCustomerList(Customer customer) {
        customerList.add(customer);
    }

    public static void removeFromCustomerList(Customer customer) {
        customerList.remove(customer);
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }
}
