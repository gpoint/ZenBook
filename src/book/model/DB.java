/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author harry
 */
public class DB {

    private static Connection conn;
    private static Statement stmt;

    public static void init() throws Exception {

        Class.forName("org.sqlite.JDBC");
//
        conn = DriverManager.getConnection("jdbc:sqlite:zenbase");
        stmt = conn.createStatement();

    }

    public static ResultSet query(String clause) {

        try {
            return stmt.executeQuery(clause);
//        
        } catch (Exception ex) {
            ex.printStackTrace();
//        
            return null;
        }
    }

    public static Entry addEntry(Entry entry) throws Exception {

        if (entry == null || entry.getId() != 0) {
            return null;
        }

        stmt.execute("INSERT INTO `entries` (`id`,`name`,`contact`,`_date`,`amount`,`witness`,`address`, `_delete`)"
                + " VALUES (NULL,'" + entry.getName() + "','" + entry.getContact() + "','" + entry.getDate() + "'," + entry.getAmount() + ",'" + entry.getWitness() + "','" + entry.getAddress() + "', 0);");

        ResultSet result = stmt.executeQuery("SELECT `seq` FROM `sqlite_sequence` WHERE `name`='entries';");

        result.next();

        entry.setId(result.getInt(1));

        return entry;
    }

    public static boolean addUser(User user) {
        return true;
    }

    public static void removeEntry(Entry entry) throws Exception {

        stmt.execute("UPDATE `entries` SET `_delete`=1 WHERE `_rowid_`='" + entry.getId() + "';");

        return;
    }

    public static boolean removeUser(User user) {
        return true;
    }

    public static boolean updateEntry(Entry entry) throws Exception {

        stmt.executeUpdate("UPDATE `entries` SET `name`='" + entry.getName() + "',`contact`='" + entry.getContact()
                + "',`_date`='" + entry.getDate() + "',`amount`=" + entry.getAmount() + ",`witness`='" + entry.getWitness()
                + "',`address`='" + entry.getAddress() + "' WHERE `_rowid_`='" + entry.getId() + "';");

        return true;
    }

    public static boolean updateUser(User user) {
        return true;
    }

//    public static (String clause){
//        return null;
//    }
}
