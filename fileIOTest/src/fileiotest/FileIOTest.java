/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileiotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class FileIOTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        //Finds the file with this name. Since there is no file path, it looks in the projct folder
        File file = new File("SaveFile.txt");
        
        
        //Overwrites the file (True would append to the file).
        FileWriter fw = new FileWriter(file, false);
        //PrintWriter allows writing to a file one line at a time
        PrintWriter writer = new PrintWriter(fw);
        /*Now we can write all the variables we want to store to the file.
        Using one variable per line will make it easier to separate them upon read-in.
        This could be done when the program is exited, possibly?
        */
        writer.println("Hello World");
        
        //Closes the file.
        writer.close();
        fw.close();
        
        
        //And now for reading things back in on startup

        Scanner scanner = new Scanner(file);
        /*
          Reads in the next line.  If you know the type isn't a string,
          you can either parseInt or use scanner.nextInt (or Double, etc.).
          But changing types isn't so hard :)
        */
        String readIn = scanner.nextLine();
        
        //The scanner/file must be closed here as well.
        scanner.close();
        
        //And a test to see that it worked :)
        System.out.println(readIn);
        
    }
    
}
