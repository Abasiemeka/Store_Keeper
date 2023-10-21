package Entities;

import Handlers.RecordsHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends Person {
    private BigDecimal account;
    private ArrayList<Product> cart;

    public Customer(String name, Date dateOfBirth, String gender, String address, String phoneNumber, String email, BigDecimal account) {
        super(name, dateOfBirth, gender, address, phoneNumber, email);
        this.account = account;
        RecordsHandler.addtoRecords(this);
    }

    public BigDecimal getAccount(){
        return this.account;
    }

    public void setAccount(BigDecimal account){
        this.account = account;
    }

    public ArrayList<Product> getCart(){
        return this.cart;
    }

    public void addToCart(Product product){
        this.cart.add(product);
    }

    public void removeFromCart(Product product){
        this.cart.remove(product);
    }

    public void buy(Product product, int quantity, Cashier cashier){
        cashier.sellProduct(product, quantity, product.getPrice());
        this.pay(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    public void pay(BigDecimal amount){
        account = account.subtract(amount);
    }

    public void checkOut(Cashier cashier){
        for (Product product : cart){
            this.buy(product, 1, cashier);
        }
        cart.clear();
    }
}
