/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mystore;

/**
 *
 * @author llujan2027
 */
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
public class MyStore {

    public static void main(String[] args) {
        final double MAX_BUDGET = 250.00;
        double amountSpent = 0.00;
        boolean programRun = true;
        
        Scanner scan = new Scanner(System.in);
        
        Item tShirt = new Item("T-Shirt", 29.99);
        Item shoes = new Item("Shoes", 125.99);
        Item jeans = new Item("Jeans", 60.99);
        Item jacket = new Item("Jacket", 250.00);
        Item hat = new Item("Hat", 25.99);
        Item shorts = new Item("Shorts", 75.99);
        Item blouse = new Item("Blouse", 88.99);
        
        System.out.println("Welcome to MyStore!\n\nItems:\n"
                           +"T-Shirt - $29.99\nShoes - $125.99\nJeans - $60.99\n"
                           +"Jacket - $250.00\nHat - $25.99\nShorts - $75.99\n"
                           +"Blouse - $88.99\n\nYou hase $250.00 to spend."
                           +"\nPlease enter what item you would like to purchase."
                           +"\nType 'n' to finish shopping.");
        
        while(programRun==true){
            int itemCount = 0;
            String selectedItem = "";
            selectedItem = scan.next();
            
                if (selectedItem.equalsIgnoreCase("T-Shirt")){
                
                    amountSpent = tShirt.addItem(amountSpent, MAX_BUDGET);
                
                } else if (selectedItem.equalsIgnoreCase("Shoes")){
                
                    amountSpent = shoes.addItem(amountSpent, MAX_BUDGET);
                
                } else if (selectedItem.equalsIgnoreCase("Jeans")){
                
                    amountSpent = jeans.addItem(amountSpent, MAX_BUDGET);
                
                } else if (selectedItem.equalsIgnoreCase("Jacket")){
                
                    amountSpent = jacket.addItem(amountSpent, MAX_BUDGET);
                
                } else if (selectedItem.equalsIgnoreCase("Hat")){
                
                    amountSpent = hat.addItem(amountSpent, MAX_BUDGET);
                
                } else if (selectedItem.equalsIgnoreCase("Shorts")){
                
                    amountSpent = shorts.addItem(amountSpent, MAX_BUDGET);
                
                } else if (selectedItem.equalsIgnoreCase("Blouse")){
                
                    amountSpent = blouse.addItem(amountSpent, MAX_BUDGET);
                
                } else if (selectedItem.equalsIgnoreCase("n")){
                
                    System.out.println("Thank you!\nYou spent a total of: $"+amountSpent
                    + "\nYou purchased a total of "+itemCount+" items.");
                    programRun = false;
                
                } else {
                    System.out.println("Invalid item. please try another!");
                }
            
            itemCount = itemCount + 1;
        }
    }
}

class Item {
    private String strName = "";
    private double dblPrice = 0;
    NumberFormat $fmt = NumberFormat.getCurrencyInstance(Locale.US);
    
    public Item(String name, double price){
        strName = name;
        dblPrice = price;
    }
    
    public String getName(){
        return strName;
    }
    
    public double getPrice(){
        return dblPrice;
    }
    
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }   
    
    public double addItem(double totalSpent, double MAX_BUDGET){
        double myDouble = totalSpent + dblPrice;
        if(myDouble>MAX_BUDGET){
            myDouble = totalSpent;
            ifOverprice();
        } else {
            System.out.println("You bought: "+strName+"!"
                + "\nYou have currently spent $"+myDouble);
            return roundAvoid(myDouble , 2);
        }
        return roundAvoid(myDouble , 2);
    }
    
    public static String ifOverprice(){
        String myString = "Oh no! this is over budget! Buy something cheaper,"
                + "or exit the shop.";
        System.out.println(myString);
        return myString;
    }
    
    @Override
    public String toString(){
        return "Item: "+strName+" Price: "+$fmt.format(dblPrice);
    }
}