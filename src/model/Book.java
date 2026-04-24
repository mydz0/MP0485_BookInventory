/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author steph
 */
public class Book {

    private String title;
    private ArrayList<String> authors = new ArrayList<>();
    private double price;
    private int quantityInInventory;

    public Book(String title, double price, int quantityInInventory) {
        this.title = title;
        this.price = price;
        this.quantityInInventory = quantityInInventory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInInventory() {
        return quantityInInventory;
    }

    public void setQuantityInInventory(int quantityInInventory) {
        this.quantityInInventory = quantityInInventory;
    }

    @Override
    public String toString() {
        return title + ";" + authors + ";" + price + ";" + quantityInInventory;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        return Objects.equals(this.title, other.title);
    }

}
