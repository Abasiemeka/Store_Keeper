package Entities;

import Enums.Responsibilities;
import Handlers.*;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.tree.RowMapper;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Inventory extends FileHandler {
    private static String inventoryFilePath = "C:\\Users\\Abasiemeka\\IdeaProjects\\Store_Keeper\\src\\main\\resources\\Inventory.xlsx";
    private static XSSFWorkbook inventoryWorkbook;
    private static HashSet<Product> inventoryCache;

    static {
        inventoryCache = new HashSet<>();
        try {
            inventoryWorkbook = createWorkbook(inventoryFilePath);
        } catch (IOException e) {
            System.out.println("Inventory file not found: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void alert(String message) throws NullPointerException {
        for (Employee employee : RecordsHandler.getEmployeeList()) {
            if (employee.getAuthorizations().contains(Responsibilities.InventoryManager)) {
                employee.sendNotification(employee, message);
            }
        }
    }

    public static HashSet<Product> getInventoryCache() {
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

    public static HashMap<Product, HashSet> toDataFormat(Product product) {
        HashSet productData = new HashSet(Arrays.asList(product.getProductID(), product.getName(), product.getPrice(), product.getQuantity(), product.getSize(), product.getCategory(), product.getDescription(), product.getManufacturer(), product.getExpiryDate()));

        return (HashMap) new HashMap<>().put(product, productData);
    }

    public static void updateInventoryCache() {
        //TODO: implement method to update inventory file
        System.out.println("Inventory chache has been updated.");
    }

    public static boolean isAvailable(Product product) {
        Iterator<Row> rowIterator = inventoryWorkbook.getSheet("In Stock").rowIterator();
        Iterator<Cell> cellIterator = rowIterator.next().cellIterator();

        while (rowIterator.hasNext()) {
            while (cellIterator.hasNext()) {
                if (cellIterator.next().getStringCellValue().equals(product.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void addProductToInventoryWorkbook(Product product, HashSet productInfo) {
        try {
            if (!isAvailable(product)) {
                XSSFRow newRow = inventoryWorkbook.getSheet("In Stock").createRow(inventoryWorkbook.getSheet("In Stock").getLastRowNum() + 1);
                Iterator<HashSet> productInfoIterator = productInfo.iterator();
                newRow.cellIterator().

            } else System.out.println("Product already exists.");
        } catch (NullPointerException e) {
            System.out.println("Check Inventory file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Add product failed:" + e.getMessage());
        }
    }
}