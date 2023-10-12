package Entities;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicInteger;

public class Person {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private Notifications Notifications;


    public Person(String name, Date dateOfBirth, String gender, String address, String phoneNumber, String email) {
        this.id = new AtomicInteger(1000).getAndIncrement();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.Notifications = new Notifications();
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
        private int notificationId;
        private List<String> contents;
        private List<String> unread;
        private List<String> read;
        public Notifications() {
            this.notificationId = new AtomicInteger().getAndIncrement();
            this.contents = List.of(this.notificationId + " Welcome to the store!"+getName()+"!");
            this.unread = this.contents;
            this.read = List.of();
        }
        public void viewAllContents() {
            System.out.println(this.contents);
        }
        public void viewUnreadNotifications() {
            System.out.println(this.unread);
            markAllAsRead();
        }
        public void markAllAsRead() {
            this.read.addAll(this.unread);
            this.contents.addAll(this.read);
            this.unread.clear();
        }
        public void sendNotification(Person person, String content) {

        }

        public void sendNotification() {
            sendNotification(null);
        }

        public void sendNotification(String content) {

        }
    }
}
