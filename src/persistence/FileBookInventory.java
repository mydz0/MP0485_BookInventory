/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.File;

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
    
    public static void guardar ()
    
    
    
}
