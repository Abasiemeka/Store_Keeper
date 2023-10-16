package Entities;

import java.util.HashMap;

public final class Inventory {
    private static HashMap<Integer, Product> inventoryContents = new HashMap<Integer, Product>();
    private static String inventoryFileName = "C:\\Users\\Abasiemeka\\IdeaProjects\\Store_Keeper\\src\\main\\resources\\Inventory.xlsx";

    public static HashMap<Integer, Product> getInventoryContents() {
        return inventoryContents;
    }

    public static void addToInventoryContents(Product product) {
        inventoryContents.put(product.getProductID(), product);
        System.out.println(product.getName() + " has been added to inventory contents list.");
    }

    public static void removeFromInventoryContents(Product product) {
        inventoryContents.remove(product);
        System.out.println(product.getName() + " has been removed from inventory contents list.");
    }

    public static void updateInventory() {
        //fixme: implement method to update inventory file
        System.out.println("Inventory has been updated.");
    }
}
