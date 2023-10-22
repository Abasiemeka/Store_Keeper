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

    public static void addtoRecords(Object object) {
        switch (object.getClass().getSimpleName()) {
            case "Person":
                personList.add((Person) object);
                break;
            case "Employee":
                employeeList.add((Employee) object);
                break;
            case "Manager":
                managerList.add((Manager) object);
                break;
            case "Cashier":
                cashierList.add((Cashier) object);
                break;
            case "Customer":
                customerList.add((Customer) object);
                break;
        }
    }

    public static void removeFromRecords(Object object) {
        if (object instanceof Person) {personList.remove((Person) object); System.out.println("Removed from Person list");}
        else if (object instanceof Employee) {employeeList.remove((Employee) object); System.out.println("Removed from Employee list");}
        else if (object instanceof Manager) {managerList.remove((Manager) object); System.out.println("Removed from Manager list");}
        else if (object instanceof Cashier) {cashierList.remove((Cashier) object); System.out.println("Removed from Cashier list");}
        else if (object instanceof Customer) {customerList.remove((Customer) object); System.out.println("Removed from Customer list");}
        }

    public static List<Person> getPersonList() {
        return personList;
    }

    public static List<Employee> getEmployeeList() { return employeeList;
    }

    public static List<Cashier> getCashierList() {
        return cashierList;
    }

    public static List<Manager> getManagerList() {
        return managerList;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }
}
