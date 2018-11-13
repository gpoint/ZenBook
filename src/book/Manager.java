/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import book.model.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author harry
 */
public class Manager {

    public static User currentUser;

    public static Stage stage;

    public static Scene loginVue, indexVue;
    
    public static DialogPane addPane, editPane, deletePane;

    public static Dialog addFxDialog, editFxDialog, deleteFxDialog;

    public static void init() throws Exception {
//        initVue();
    }

    public static void initVue() throws Exception {
//        
//        Scene Initialization
        loginVue = new Scene(FXMLLoader.load(Manager.class.getResource("vue/fxml/login.fxml")));
        indexVue = new Scene(FXMLLoader.load(Manager.class.getResource("vue/fxml/index.fxml")));
//        
//        SubScene Initialization

        addFxDialog = new Dialog();

        addFxDialog.initStyle(StageStyle.TRANSPARENT);
        
        addPane = new DialogPane();

        addFxDialog.setDialogPane(addPane);

        addPane.getButtonTypes().add(ButtonType.FINISH);

//        

        editFxDialog = new Dialog();
        
        editFxDialog.initStyle(StageStyle.TRANSPARENT);
        
        editPane = new DialogPane();

        editFxDialog.setDialogPane(editPane);

        editPane.getButtonTypes().add(ButtonType.FINISH);
        
//        
        
        deleteFxDialog = new Dialog();
        
        deleteFxDialog.initStyle(StageStyle.TRANSPARENT);
        
        deletePane = new DialogPane();

        deleteFxDialog.setDialogPane(deletePane);

        deletePane.getButtonTypes().add(ButtonType.CANCEL);
    }

}
