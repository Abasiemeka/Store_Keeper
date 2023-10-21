package Entities;

import Enums.*;
import Handlers.RecordsHandler;

import java.math.BigDecimal;
import java.util.Date;

public class Cashier extends Employee{
    public Cashier(String name, Date dateOfBirth, String gender, String address, String phoneNumber, String email, BigDecimal salary) {
        super(name, dateOfBirth, gender, address, phoneNumber, email, salary);
        this.setDesignation(Designation.Cashier);
        RecordsHandler.addtoRecords(this);
    }

    public void sellProduct(Product product, int quantity, BigDecimal amount) {
        if (!Inventory.isAvailable(product)) {
            product.setQuantity(product.getQuantity() - quantity);
            Store.transaction("sell", product, quantity, amount);
        }
        else System.out.println("Product is out of stock.");
    }
}