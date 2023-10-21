import Entities.Person;
import Handlers.RecordsHandler;

import javax.swing.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Throwable {

        Person Emeka = new Person("Emeka", new Date(), "Male", "123 Street", "1234567890", "john@example.com");
        Person George = new Person("George", new Date(), "Male", "123 Street", "1234567890", "john@example.com");
        Person Gaga = new Person("Gaga", new Date(), "Female", "123 Street", "1234567890", "john@example.com");

        System.out.println(Emeka.getPersonID());
        System.out.println(George.getPersonID());
        System.out.println(Gaga.getPersonID());

        Emeka.sendNotification(George, "This is a test message");
        George.viewUnreadNotifications();
        George.viewAllMessages();
        George.viewUnreadNotifications();

        George.finalize();
        George.viewAllMessages();

        RecordsHandler.getPersonList().forEach(System.out::println);











//----------------------------------------------------------------------------------------------------------------
       /*TODO:
        Implement records handler such that every object sends itself to the relevant records list, upon instantiation
        Implement notifications, such that;
            every object can send and receive notifications
            there is a notifications listener in the notification handler class
        On receipt of relevant notification, Inventory;
            adds product to inventoryContents and inventory file
            removes product from inventoryContents and inventory file
            updates inventory file with sell data
            updates inventory file with stock data
            so, inventory can receive sellNotification(relevant info), stockNotification(relevant info) etc.
            Store.sell also sends sellNotification(relevant info) to relevant objects e.g
                 notify(sender, recipient, notif type, notif message){
                    notif type: sell "stock", "return" etc
                    message = {relevant info...}
                 }
                 notif type: "sell", "stock", "return"

         etc.
         *TODO
         */

    }
}
