package Entities;

import Enums.Responsibilities;
import Handlers.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Inventory extends FileHandler {
    private static String inventoryFilePath = "C:\\Users\\Abasiemeka\\IdeaProjects\\Store_Keeper\\src\\main\\resources\\Inventory.xlsx";
    private static XSSFWorkbook inventoryWorkbook;
    private static List<Product> inventoryCache;

    static {
        inventoryCache = new ArrayList<>();

        try {
            inventoryWorkbook = createWorkbook(inventoryFilePath);
        }
        catch (IOException e) {
            System.out.println("Inventory file not found: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

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

    public static boolean isAvailable(Product product) {
        return inventoryCache.contains(product);
    }

    public static void addProductToInventoryWorkbook(Product product) throws IOException {
        //check if product already exists in workbook. If true, then return message to modify product instead.
        //If not, then add product to new row in relevant workbook sheet.
        inventoryWorkbook.getSheet("Stocked").createRow(inventoryWorkbook.getSheet("Stocked").getLastRowNum() + 1).createCell(0).setCellValue(product.getName());
        inventoryWorkbook.getSheet("Stocked").createRow(inventoryWorkbook.getSheet("Stocked").getLastRowNum()).createCell(1).setCellValue(product.getQuantity());
        inventoryWorkbook.getSheet("Stocked").createRow(inventoryWorkbook.getSheet("Stocked").getLastRowNum()).createCell(2).setCellValue(String.valueOf(product.getPrice()));
        inventoryWorkbook.getSheet("Stocked").createRow(inventoryWorkbook.getSheet("Stocked").getLastRowNum()).createCell(3).setCellValue(product.getQuantity());
    }
}