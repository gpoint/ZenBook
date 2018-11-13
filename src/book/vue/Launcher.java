/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.vue;

import static book.Manager.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author harry
 */
public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        
        initVue();
//       
        stage = primaryStage;
//        
        stage.setScene(loginVue);
////        
//        stage.setResizable(false);
//        
        stage.setTitle("ZenBook");
        
        stage.getIcons().add(new Image(getClass().getResourceAsStream("assets/zenbook.png")));
                
////        
//        Thread[] th = new Thread[100];
//        Thread.enumerate(th);

//        currentThread().setName("ZenBook");
//        Thread.currentThread().
//        
        stage.show();

//        for (Thread thread : th) {
//            if(thread != null)
//                System.out.println(thread.getName());
//        }
//        
//        System.out.println(
//                stage.impl_getPeer().setTitle(STYLESHEET_MODENA);
//        System.getProperties().list(new PrintStream(System.out));
    }

    public static void begin(String... args) {
        launch(args);
    }

}
