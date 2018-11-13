/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.auth;

import book.Manager;
import book.model.DB;
import book.model.User;
import java.sql.ResultSet;

/**
 *
 * @author harry
 */
public class Security {

    public static boolean login(String username, String password) {
        try {
            ResultSet result = DB.query("SELECT * from `users` WHERE `username`='" + username + "' AND `password`='" + password + "';");
//

//            
            if (result.next()) {
                Manager.currentUser = new User(result.getString("username"),
                        result.getString("firstname"), result.getString("surname"),
                        result.getString("othernames"), result.getString("email"),
                        result.getString("email"), result.getString("phone"));

                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }
}
