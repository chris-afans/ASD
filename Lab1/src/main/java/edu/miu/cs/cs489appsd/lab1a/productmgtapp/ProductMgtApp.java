package edu.miu.cs.cs489appsd.lab1a.productmgtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductMgtApp {

    public static void printProducts(Product[] products){
        List<Product> productList = Arrays.asList(products);
        Collections.sort(productList, new Comparator<Product>(){

            public int compare(Product o1, Product o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Printed in JSON Format");
        System.out.println("[");
        for(Product p : products){
            System.out.println("   {"+ "\"productId\": " + p.getProductID()+"," + " \"name\": " + p.getName()+ ","+ " \"dateSupplied\": " + p.getDate()+ "," + " \"quantityInStock\": " + p.getQty()+","+ " \"unitPrice\": " + p.getPrice() + "}");
        }
        System.out.println("]");
        System.out.println("---------------------------------");
        System.out.println("Printed in XML Format");
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<products>");
        for(Product p : products){
            System.out.println("   <product productId=" + "\"" + p.getProductID()+"\"" + " name=" + "\"" +p.getName()+"\""+ " dateSupplied=" + "\"" + p.getDate()+"\"" + " quantityInStock=" + "\""+ p.getQty()+"\""+ " unitPrice=" + "\""+ p.getPrice()+"\"" + ">");
        }
        System.out.println("</products>");
        System.out.println("---------------------------------");
        System.out.println("Printed in Comma-Separated Value(CSV) Format");
        for(Product p : products){
            System.out.println(p.getProductID()+"," + p.getName() + "," + p.getDate()+ "," + p.getQty()+ "," + p.getPrice());
        }
        System.out.println("---------------------------------");


    }

    public static void main(String[] args) {
        Product p1 = new Product(3128874119L, "Banana", LocalDate.of(2023,01,24), 124, 0.55);
        Product p2 = new Product(2927458265L, "Apple", LocalDate.of(2022,12,9), 18, 1.09);
        Product p3 = new Product(9189927460L, "Carrot", LocalDate.of(2023,03,31), 89, 2.99);
        Product[] products = {p1, p2, p3};
        printProducts(products);
    }
}