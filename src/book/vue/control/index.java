/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.vue.control;

import static book.Manager.*;
import book.model.DB;
import book.model.Entry;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

/**
 *
 * @author harry
 */
public class index {

    static ObservableList<Entry> tableData;
    
    static ArrayList<Entry> entries;
    
    @FXML
    private TextField searchTxtFx;

    @FXML
    ChoiceBox<String> searchOptionsFx;

    @FXML
    private TableColumn<Entry, String> nameFxCol, contactFxCol, addressFxCol, amountFxCol, dateFxCol, witnessFxCol;

    @FXML
    public TableView<Entry> tableFx;
    public static TableView<Entry> table;

    @FXML
    private void add() {

        try {

            addPane.setContent((Node) FXMLLoader.load(getClass().getResource("../fxml/add.fxml")));

            addFxDialog.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void edit() {

        try {
            edit.entry = tableFx.getSelectionModel().getSelectedItem();

            editPane.setContent((Node) FXMLLoader.load(getClass().getResource("../fxml/edit.fxml")));

            editFxDialog.showAndWait();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void delete() {

        try {
            delete.entry = tableFx.getSelectionModel().getSelectedItem();

            deletePane.setContent((Node) FXMLLoader.load(getClass().getResource("../fxml/delete.fxml")));

            deleteFxDialog.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logout() {

        stage.setScene(loginVue);

        stage.setWidth(500);
        stage.setHeight(500);

        stage.setResizable(false);
        stage.setMaximized(false);

        stage.centerOnScreen();

        System.err.println(currentUser.getName() + " logged out");

    }

    private ArrayList<Entry> getEntries() {

        entries = new ArrayList<>();

        try {
            ResultSet results = DB.query("SELECT * FROM `entries` WHERE `_delete`=0;");

            while (results.next()) {
                entries.add(new Entry(results.getInt("id"),
                        results.getString("name"), results.getString("_date"),
                        results.getString("witness"), results.getString("contact"),
                        results.getString("address"), results.getFloat("amount")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return entries;
    }

    private void initTable(ArrayList<Entry> entries) {

        tableData = FXCollections.observableArrayList(entries);

//        -------
        nameFxCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        contactFxCol.setCellValueFactory(new PropertyValueFactory<>("contact"));

        addressFxCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        amountFxCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        dateFxCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        witnessFxCol.setCellValueFactory(new PropertyValueFactory<>("witness"));

//        -------
        tableFx.setItems(tableData);

        table = tableFx;

    }

    void search() {
        
        String query = "SELECT * FROM `entries` WHERE `" + searchOptionsFx.getValue().toLowerCase()
                + "` LIKE '%" + searchTxtFx.getText() + "%' AND `_delete`=0;";
        
        entries = new ArrayList<>();      
        
        try {
            ResultSet results = DB.query(query);

            while (results.next()) {
                entries.add(new Entry(results.getInt("id"),
                        results.getString("name"), results.getString("_date"),
                        results.getString("witness"), results.getString("contact"),
                        results.getString("address"), results.getFloat("amount")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        tableData = FXCollections.observableArrayList(entries);
        tableFx.setItems(tableData);
        System.out.println(query);

    }

    private void initSearchOptions() {

        searchOptionsFx.getItems().add("Name");

        searchOptionsFx.getItems().add("Contact");

        searchOptionsFx.getItems().add("Address");

        searchOptionsFx.getItems().add("Amount");

        searchOptionsFx.getItems().add("Date");

        searchOptionsFx.getItems().add("Witness");

        searchOptionsFx.getSelectionModel().clearAndSelect(0);
    }

    @FXML
    public void initialize() {

        initTable(getEntries());

        initSearchOptions();

        searchTxtFx.setOnKeyReleased((e) -> {
            search();

        });

        searchOptionsFx.getSelectionModel().selectedItemProperty().addListener((v, o, n) -> {
            search();
        });

    }

}
