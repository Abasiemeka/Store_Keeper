package Entities;

import Handlers.RecordsHandler;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Person {
    private static int id = 1000;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private final Notifications notifications;


    public Person(String name, Date dateOfBirth, String gender, String address, String phoneNumber, String email) {
        this.id = Person.id;
        Person.id++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.notifications = new Notifications();
        RecordsHandler.addToPersonList(this);
    }

    protected void finalize() throws Throwable {
        RecordsHandler.removeFromPersonList(this);
        super.finalize();
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    public int getAge() {
        Calendar calender = Calendar.getInstance();
        return calender.get(Calendar.YEAR) - this.dateOfBirth.getYear();
        //return LocalDate.now().getYear() - this.dateOfBirth.getYear();
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    class Notifications {
        private final Integer notificationId = new AtomicInteger().getAndIncrement();
        private ArrayList<String> allMessages = new ArrayList<String>();
        private ArrayList<String> unreadMessages = new ArrayList<String>();
        private ArrayList<String> readMessages = new ArrayList<String>();
        private int unreadMessageCount;

        public Notifications() {
            this.allMessages.add(String.valueOf(notificationId) + ": Welcome to the store, "+getName()+"!");
            this.unreadMessages = this.allMessages;
            this.unreadMessageCount = 1;
        }
        public void viewAllMessages() {
            System.out.println(this.allMessages);

        }
        public void viewUnreadNotifications() {
            System.out.println(this.unreadMessages);
            markAllAsRead();
        }
        public void markAllAsRead() {
            this.readMessages.addAll(this.unreadMessages);
            this.unreadMessages.clear();
            this.unreadMessageCount = 0;
        }
        public void sendNotification(Person person, String message) {
            String welcomeMessage = person.notifications.notificationId.toString() + ": " + message + "/";
            person.notifications.unreadMessages.add(welcomeMessage);
            person.notifications.allMessages.add(welcomeMessage);
        }

        public void sendNotification(int personId, String message) {
            for (Person person: RecordsHandler.getpersonList()) {
                if (person.getId() == personId) {
                    sendNotification(person, message);
                }
                else System.out.println("Person does not exist.");
            }
        }

        public void sendNotification(List<? extends Person> recipientList, String message) {
            for (Person person : recipientList)  sendNotification(person, message);
        }
    }

    public static void main(String[] args) {
        Person Emeka = new Person("Emeka", new Date(), "Male", "123 Street", "1234567890", "john@example.com");
        Person George = new Person("George", new Date(), "Male", "123 Street", "1234567890", "john@example.com");
        Person Gaga = new Person("Gaga", new Date(), "Female", "123 Street", "1234567890", "john@example.com");

        System.out.println(Emeka.getId());
        System.out.println(George.getId());
        System.out.println(Gaga.getId());
    }
}


