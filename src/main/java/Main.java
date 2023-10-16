import Entities.Person;

public class Main {
    public static void main(String[] args) {
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
    }
}
