package Entities;

import Entities.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public final class Store {
    private static BigDecimal accountBalance; //Store account balance in Naira.
    private static int receiptCount = 0; //Counter to keep track of receipts in lieu of ledger.

    static  {
        accountBalance = BigDecimal.valueOf(100000.00);
        receiptCount = 0;
    }

    public void setReceiptCount(int newReceiptCount) { receiptCount = newReceiptCount; }
    public int getReceiptCount() { return receiptCount; }
    public static void incrementReceiptCount() { receiptCount++; }

    public static void setAccountBalance(BigDecimal amount) { accountBalance = amount; }
    public static BigDecimal getAccountBalance() { return accountBalance; }


    public static void transaction(String transactionType, Product product, int quantity, BigDecimal price) {
        if (quantity > product.getQuantity()) {
            System.out.println("Only " + product.getQuantity() + " units available in stock.");
            return;
        }

        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(quantity));
        BigDecimal discount = product.getPrice().subtract(price);

        switch (transactionType) {
            case "sell" -> {
                accountBalance = accountBalance.add(totalPrice);
                incrementReceiptCount();

                if (product.getQuantity() - quantity == 0 && Inventory.isAvailable(product)) {
                    System.out.println(product.getQuantity() + " units of " + product.getName() + " successfully sold at N" + discount + " discount");
                    System.out.println("Total sale: N" + totalPrice + ". " + product.getName() + " now out of stock: ");
                    System.out.println("Store records updated.");
                    product = null;
                    System.gc();
                } else {
                    product.setQuantity(product.getQuantity() - quantity);
                    System.out.println(product.getQuantity() + " units of " + product.getName() + " successfully sold.");
                    System.out.println("Total sale: N" + totalPrice + ". Total " + product.getName() + " in stock: " + product.getQuantity());
                    System.out.println("Store records updated.");
                }
            }
            case "return" -> {//accountBalance = accountBalance.subtract(totalPrice);
//                if (product != null){
//                    product.setQuantity(product.getQuantity() + quantity);
//                    addToInventory(product.getName());
//                    incrementReceiptCount();
//                }
//                else {
//                    String a = (String)product;
//                    addToInventory();
//                }
            }
            case "stock" -> {
                accountBalance = accountBalance.subtract(totalPrice); //Adjust account balance
                incrementReceiptCount(); //Issue receipt
                Inventory.addToInventoryCache(product);
                System.out.println(product.getQuantity() + " units of " + product.getName() + " successfully sold at N" + discount + " discount");
                System.out.println("Store records updated.");
            }
            default -> {
                System.out.println("Invalid transaction type.");
            }
        }
    }
}