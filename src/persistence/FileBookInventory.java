/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import model.Book;

/**
 *
 * @author steph
 */
public class FileBookInventory {

    private static String projectDir = System.getProperty("user.dir");
    private static String separatorF = File.separator;
    private static String newFolder = projectDir + separatorF + "data";
    private static File folder = new File(newFolder);
    private static String newFile = newFolder + separatorF + "books.txt";
    private static File file = new File(newFile);

    public FileBookInventory(String newFile) {
        this.newFile = newFile;
    }

    public static void save(ArrayList<Book> books) {
        try {

            if (!folder.exists()) {
                folder.mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Book b : books) {
                bw.write(b.toString());
                bw.newLine();
                bw.flush();
            }

            bw.close();
        } catch (IOException ex) {
            System.getLogger(FileBookInventory.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public static ArrayList<Book> load() {
        ArrayList<Book> loadBooks = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                //make another separator for the array authors, in case a book has more than one author
                ArrayList<String> authors = new ArrayList<>(Arrays.asList(data[2].split(",")));
                Book b = new Book(data[0], data[1], authors, Double.parseDouble(data[3]), Integer.parseInt(data[4]));
                loadBooks.add(b);
            }

            return loadBooks;
        } catch (IOException ex) {
            System.getLogger(FileBookInventory.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return loadBooks;
    }

}
