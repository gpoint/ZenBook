/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.vue.control;

import static book.Manager.*;
import book.auth.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author harry
 */
public class login {
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Button login;
    
    @FXML
    private Label errorMessage;
    
    @FXML
    private void processLogin() {
//        
        boolean loggedin;
        validate();
//        
        if ((loggedin = Security.login(username.getText(), password.getText()))) {
            
//            
            stage.setScene(indexVue);
            
            stage.setResizable(true);
//            
//            stage.setFullScreen(true);
            
            stage.setMaximized(true);
            
            stage.maximizedProperty().addListener((v, o, n) -> {
                stage.setMaximized(true);
            });
            
//            stage.centerOnScreen();
            
        } else {
            errorMessage.setText("Check the login details..!");
        }
        System.out.println(loggedin ? currentUser.getName() + " just logged in " : "Error logging in.");
        
        username.setText("");
        password.setText("");
        
     }
    
    public void initialize() {
        
    }
    
    private boolean validate() {
        
        if (username.getText().isEmpty()) {
//            
            errorMessage.setText(" Username is empty..! ");
//            
            return false;
            
        }else if(password.getText().isEmpty()){
//            
            errorMessage.setText(" Password is empty..! ");
//            
            return false;
            
        }
        
        return true;
    }
    
}
