/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.vue.control;

import book.model.DB;
import book.model.Entry;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author harry
 */
public class edit {
    
    public static Entry entry;
    
    @FXML
    TextField nameTxtFx, contactTxtFx, witnessTxtFx, amountTxtFx;

    @FXML
    DatePicker dateTxtFx;

    @FXML
    TextArea addressTxtFx;
    
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
        
        
        entry = new Entry(entry.getId(),
                nameTxtFx.getText(),
                dateTxtFx.getEditor().getText(),
                contactTxtFx.getText(),
                witnessTxtFx.getText(),
                addressTxtFx.getText(),
                Float.parseFloat(amountTxtFx.getText()));

        try{
            
            DB.updateEntry(entry);
            
            int s = index.table.getSelectionModel().getSelectedIndex();
            
            index.table.getItems().add(s, entry);
            index.table.getItems().remove(s+1);
            
        }catch(Exception ex){
            
        }
        
        
    }
    
    public void initialize(){
        
        
        nameTxtFx.setText(entry.getName());
        contactTxtFx.setText(entry.getContact());
        witnessTxtFx.setText(entry.getWitness());
        amountTxtFx.setText(entry.getAmount()+"");
        dateTxtFx.getEditor().setText(entry.getDate());
        addressTxtFx.setText(entry.getAddress());
        
        
        System.out.println(entry);
    }
}
