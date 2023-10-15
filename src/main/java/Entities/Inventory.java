package Entities;

import java.util.ArrayList;

public final class Inventory {
    private static ArrayList<String> inventoryContents = new ArrayList<String>();
    private static String inventoryFileName = "C:\\Users\\Abasiemeka\\IdeaProjects\\Store_Keeper\\src\\main\\resources\\Inventory.xlsx";

    public static ArrayList<String> getInventoryContents() {
        return inventoryContents;
    }

    public static void addToInventory(String productName) {
        inventoryContents.add(productName);
        System.out.println(productName + " has been added to store inventory.");
    }

    public static void removeFromInventory(String productName) {
        inventoryContents.remove(productName);
        System.out.println(productName + " has been removed from store inventory.");
    }

    public static void updateInventory() {
        //fixme: implement method to update inventory file
        System.out.println("Inventory has been updated.");
    }
}
