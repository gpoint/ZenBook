/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.vue.control;

import book.Manager;
import book.model.DB;
import book.model.Entry;
import com.sun.javafx.scene.input.PickResultChooser;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

/**
 *
 * @author harry
 */
public class delete {
    
    public static Entry entry;
    
    @FXML
    TextArea addressTxt;

    @FXML
    TextField nameTxt, contactTxt, witnessTxt, amountTxt, dateTxt;
    
    @FXML
    public void cancel() {

        System.out.println("\n\n DialogPane Delete");

    }

    @FXML
    public void _delete(Event event){
        try {
            
            DB.removeEntry(entry);
            
            int s = index.table.getSelectionModel().getSelectedIndex();
            
            index.table.getItems().remove(s);
                    
            Manager.deletePane.lookupButton(ButtonType.CANCEL).fireEvent(event);
            
            
        } catch (Exception ex) {
            
        }
    }
    
    public void initialize(){
        
//        Manager.deletePane.lookupButton(ButtonType.FINISH).getParent().prefHeight(0);
                
        
        nameTxt.setText(entry.getName());
        contactTxt.setText(entry.getContact());
        witnessTxt.setText(entry.getWitness());
        amountTxt.setText(entry.getAmount()+"");
        dateTxt.setText(entry.getDate());
        addressTxt.setText(entry.getAddress());
        
        
//        System.out.println(entry);
    }
    

}
