/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.vue.control;

import book.model.DB;
import book.model.Entry;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author harry
 */
public class add {

    public static Entry entry;
    
    @FXML
    TextField nameTxtFx, contactTxtFx, witnessTxtFx, amountTxtFx;

    @FXML
    DatePicker dateTxtFx;

    @FXML
    TextArea addressTxtFx;

    @FXML
    private Label feedBackFx;

    public void feedBack(String msg) {

        Transition trans;
    }

    @FXML
    public void cancel() {

        nameTxtFx.setText("");
        contactTxtFx.setText("");
        witnessTxtFx.setText("");
        amountTxtFx.setText("");
        dateTxtFx.getEditor().setText("");
        addressTxtFx.setText("");

        System.out.println("\n\nAdd DialogPane Reset");

    }

    @FXML
    public void save() {

        entry = new Entry(0,
                nameTxtFx.getText(),
                dateTxtFx.getEditor().getText(),
                contactTxtFx.getText(),
                witnessTxtFx.getText(),
                addressTxtFx.getText(),
                Float.parseFloat(amountTxtFx.getText()));

        try {
            DB.addEntry(entry);
        } catch (Exception ex) {
            feedBack(ex.getMessage());
        }
        
        feedBack("The Entry has been saved successfully.");
        
        
        index.table.getItems().add(entry);

        nameTxtFx.setText("");
        contactTxtFx.setText("");
        witnessTxtFx.setText("");
        amountTxtFx.setText("");
        dateTxtFx.getEditor().setText("");
        addressTxtFx.setText("");
        
        
    }

    public void initialize() {
        
        amountTxtFx.setOnKeyReleased((evt) -> {
            try {
                Float.parseFloat("" + amountTxtFx.getText() + "0");
            } catch (Exception ex) {
                evt.consume();
                amountTxtFx.deletePreviousChar();
//                ex.printStackTrace();
            }
        });

//        amountTxtFx.setOnAction(value);
    }

}
