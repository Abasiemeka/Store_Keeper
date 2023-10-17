package Entities;

import Enums.Designation;
import Handlers.RecordsHandler;

import java.math.BigDecimal;
import java.util.Date;

public class Manager extends Employee {
    public Manager(String name, Date dateOfBirth, String gender, String address, String phoneNumber, String email, BigDecimal salary) {
        super(name, dateOfBirth, gender, address, phoneNumber, email, salary);
        this.setDesignation(Designation.Manager);
        RecordsHandler.addToManagerList(this);
    }
    @Override
    public String toString() {
        return super.toString();
    }

    public void creditAccount(BigDecimal amount) { Store.setAccountBalance(Store.getAccountBalance().add(amount)); }
    public void debitAccount(BigDecimal amount) { Store.setAccountBalance(Store.getAccountBalance().subtract(amount)); }

    public void stockNewProduct(String name, BigDecimal price, int quantity) {
        if (Store.getInventory().contains(name)) {
            System.out.println("Product already exists.");
            return;
        }
        else {
            Product product = new Product(name, price, quantity); //initialize product
            Store.transaction("stock", product, quantity, price);
        }
    }
    public void deleteProduct(Product product) {
        if (product != null) {
            Store.removeFromInventory(product.getName());
            System.out.println(product.getName() + " is no longer available in stock");
            product = null;
            System.gc();
        }
        else System.out.println("Product does not exist.");
    }
    public void hireCashier() {
    }
    public void fireCashier(Cashier cashier) {
        System.out.println("Cashier " + cashier.getName() + " has been fired.");
        cashier = null;
        System.gc();
    }
    public void changeCashierDesignation() {
    }
}
