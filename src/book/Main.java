/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import book.model.DB;
import book.vue.Launcher;
import java.io.PrintStream;

/**
 *
 * @author harry
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
//        
        
//        System.getProperties().list(new PrintStream(System.out));
//        
        DB.init();
//        
        Manager.init();
//        
        Launcher.begin(args);
        
        
    }
    
}
