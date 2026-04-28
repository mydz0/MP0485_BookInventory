/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.util.HashMap;
import javax.swing.JOptionPane;
import model.Book;
import persistence.FileBookInventory;

/**
 *
 * @author steph
 */
public class BookController {

    private static HashMap<String, Book> bookInventory = new HashMap<>();

    public static void save() {
        FileBookInventory.save(bookInventory);
    }

    public static void load() {
        bookInventory = FileBookInventory.load();
    }

//    Agregar libro: Solicita al usuario ingresar el título, precio y cantidad en inventario del libro. Verifica
//si el libro ya existe en la lista utilizando los métodos equals() y hashCode(). Si el libro ya existe,
//muestra un mensaje "El libro ya existe". De lo contrario, crea un objeto Libro con los datos
//ingresados y agrégalo a inventarioLibros.--- add object through view
    public static void addBook(Book newBook) {
        //recieves book object, and hash map to see if exist inside the inventory

        //check's if book b exists
        if (bookInventory.containsValue(newBook)) {
            JOptionPane.showMessageDialog(null, "Book already exists");
        }

        //if not it'll add to the inventory
        bookInventory.put(newBook.getISBN(), newBook);
    }

//    Actualizar libro
//    : Solicita al usuario ingresar el título del libro a actualizar
//    . Verifica si el libro existe en la lista
//    . Si existe, solicita al usuario ingresar el nuevo precio y la cantidad en inventario del libro ,
//            y actualiza los valores correspondientes
//    . Si no existe , muestra un mensaje "El libro no existe".
    public static void updateBook(String ISBN, double newPrice, int quantity) {
        //check if hte book exists
        if (!bookInventory.containsKey(ISBN)) {
            JOptionPane.showMessageDialog(null, "Book not found");
        }

        Book bookUpdate = bookInventory.get(ISBN);
        bookUpdate.setPrice(newPrice);
        bookUpdate.setQuantityInInventory(quantity);
    }

//    Eliminar libro: Solicita al usuario ingresar el título del libro a eliminar. Verifica si el libro existe en
//la lista. Si existe, elimina el libro de inventarioLibros. Si no existe, muestra un mensaje "El libro no
//existe".
    public static void deleteBook(String titulo) {
        if (!bookInventory.containsKey(titulo)) {
            JOptionPane.showMessageDialog(null, "Book not found");
        }

        bookInventory.remove(titulo);
    }

    
    
}
