/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.model;

import java.sql.Date;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author harry
 */
public class Entry {
       
    private SimpleStringProperty name, date, witness, contact, address;
    private SimpleFloatProperty amount;
    
    private int id;
    
    public Entry(int id, String name, String date, String witness, String contact, String address, Float amount){
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
        this.contact = new SimpleStringProperty(contact);
        this.address = new SimpleStringProperty(address);
        this.witness = new SimpleStringProperty(witness);
        this.amount = new SimpleFloatProperty(amount);
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name.get();
    }   
    
    public String getDate(){
        return date.get();
    }   
    
    public String getContact(){
        return contact.get();
    }   
    
    public String getAddress(){
        return address.get();
    }
    
    public String getWitness(){
        return witness.get();
    }   
    
    public Float getAmount(){
        return amount.get();
    }   
    
    public void setName(String name){
        this.name.set(name);
    }
    
    public void setDate(Date date){
        this.date.set(date.toString());
    }
    
    public void setContact(String contact){
        this.contact.set(contact);
    }   
    public void setWitness(String witness){
        this.witness.set(witness);
    }
    
    public void setAddress(String address){
        this.address.set(address);
    }   
    
    public void setAmount(Float amount){
        this.amount.set(amount);
    }
    
    @Override
    public String toString(){
        return id + " : " + name.get() + " : " + amount.get();
    }

    void setId(int id) {
        this.id = id;
    }
    
}