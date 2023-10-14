package Entities;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Customer {
    /*
    private BigDecimal wallet; //Customers wallet amount
    private ArrayList<Product> cart; //Customers cart

    public Customer(BigDecimal wallet){
        this.wallet = wallet;
    }

    public void setWallet(BigDecimal wallet){
        this.wallet = wallet;
    }
    public BigDecimal getWallet(){
        return this.wallet;
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
        cashier.sell(product, quantity, this.wallet);
        this.pay(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    public void pay(BigDecimal amount){
        wallet = wallet.subtract(amount);
    }

    public void checkOut(Cashier cashier){
        for (Product product : cart){
            this.buy(product, 1, cashier);
        }
        cart.clear();
    }

     */
}
