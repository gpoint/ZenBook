/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author harry
 */
public class User {

    private SimpleStringProperty username, surname, firstname, othernames, email, phone, address;

    public User(String username, String firstname, String surname, String othernames, String email, String phone, String address) {
        this.username = new SimpleStringProperty(username);
        this.surname = new SimpleStringProperty(surname);
        this.firstname = new SimpleStringProperty(firstname);
        this.othernames = new SimpleStringProperty(othernames);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
    }

    public String getName() {
        return surname.get() + " " + firstname.get();
    }
    
    public String getUsername() {
        return surname.get() + " " + firstname.get();
    }
    
    public String getSurname() {
        return surname.get() + " " + firstname.get();
    }
    
    public String getFirstname() {
        return surname.get() + " " + firstname.get();
    }
    
    public String getOthernames() {
        return surname.get() + " " + firstname.get();
    }
    
    public String getEmail() {
        return surname.get() + " " + firstname.get();
    }
    
    public String getPhone() {
        return surname.get() + " " + firstname.get();
    }
    
    public String getAddress() {
        return surname.get() + " " + firstname.get();
    }
    
    public void setUsername(String username) {
        this.username.set(username);
    }
    
    public void setSurname(String surname) {
        this.surname.set(surname);
    }
    
    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }
    
    public void setOthernames(String othernames) {
        this.othernames.set(othernames);
    }
    
    public void setEmail(String email) {
        this.email.set(email);
    }
    
    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    
    public void setAddress(String address) {
        this.address.set(address);
    }
    

}
