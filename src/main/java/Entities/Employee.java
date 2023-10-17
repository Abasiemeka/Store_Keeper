package Entities;

import Enums.*;
import Handlers.RecordsHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee extends Person {
    private BigDecimal salary;
    private Designation designation;
    private List<Responsibilities> authorizations;
    private final Notifications notifications;

    private class Notifications {
        private final Integer notificationId = new AtomicInteger().getAndIncrement(); //todo implement notification Id's in recieved notifications
        private ArrayList<String> allMessages = new ArrayList<String>();
        private ArrayList<String> unreadMessages = new ArrayList<String>();
        private ArrayList<String> readMessages = new ArrayList<String>();
        private int unreadMessageCount;

        private Notifications() {
            this.allMessages.add(String.valueOf(notificationId) + ": Welcome to the store, "+getName()+"!"+"\n");
            this.unreadMessages = this.allMessages;
            this.unreadMessageCount = 1;
        }
    }

    public Employee(String name, Date dateOfBirth, String gender, String address, String phoneNumber, String email, BigDecimal salary) {

        super(name, dateOfBirth, gender, address, phoneNumber, email);
        this.salary = salary;
        this.notifications = new Notifications();
        RecordsHandler.addToEmployeeList(this);
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

    public void viewAllMessages() {
        System.out.println(notifications.allMessages);

    }
    public void viewUnreadNotifications() {
        System.out.println(notifications.unreadMessages);
        markAllAsRead();
    }
    public void markAllAsRead() {
        notifications.readMessages.addAll(notifications.unreadMessages);
        notifications.unreadMessages.clear();
        notifications.unreadMessageCount = 0;
    }

    public void sendNotification(Employee employee, String message) {
        employee.notifications.unreadMessages.add(message+"\n");
        employee.notifications.unreadMessageCount++;
        employee.notifications.allMessages.add(message+"\n");
        employee.receiveNotification(this, message);
    }

    public void sendNotification(int employeeID, String message) {
        for (Employee employee: RecordsHandler.getEmployeeList()) {
            if (employee.getPersonID() == employeeID) {
                sendNotification(employee, message);
            }
            else System.out.println("Person does not exist.");
        }
    }

    public void sendNotification(List<? extends Person> recipientList, String message) {
        for (Person person : recipientList)  sendNotification((Employee) person, message);
    }

    public void receiveNotification(Employee sender, String message){
        //check sender and message and do specific actions per situation
    }
}
