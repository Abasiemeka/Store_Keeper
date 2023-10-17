package Entities;

import Enums.Responsibilities;
import Handlers.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

public final class Inventory implements FileHandler{
    private static List<Product> inventoryCache = new ArrayList<>();
    private static String inventoryFileName = "C:\\Users\\Abasiemeka\\IdeaProjects\\Store_Keeper\\src\\main\\resources\\Inventory.xlsx";

    public static List<Product> getInventoryCache() {
        return inventoryCache;
    }

    public static void addToInventoryCache(Product product) {
        inventoryCache.add(product);
        System.out.println(product.getName() + " has been added to inventory cache.");
    }



    public static void removeFromInventoryCache(Product product) {
        inventoryCache.remove(product);
        System.out.println(product.getName() + " has been removed from inventory cache.");
    }

    public static void updateInventoryCache() {
        //fixme: implement method to update inventory file
        System.out.println("Inventory chache has been updated.");
    }
    public static void alert(String message) throws NullPointerException {
        for (Employee employee:RecordsHandler.getEmployeeList()) {
            if (employee.getAuthorizations().contains(Responsibilities.InventoryManager)){
                employee.sendNotification(employee, message);

            }
        }
    }

    public static void createFile(){
    }

}
