/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import no.ntnu.ticketreservationsystem.enteties.Passenger;

/**
 *
 * @author olavt
 */
public class PassengerScreen extends ChildBorder {
    
    private TableView<Passenger> table;
    
    public PassengerScreen(GUI gui) {
        super(gui);
        table = new TableView<>();
        
        TableColumn firstName = new TableColumn("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn lastName = new TableColumn("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        TableColumn eMail = new TableColumn("E-mail Address");
        eMail.setCellValueFactory(new PropertyValueFactory("emailAddress"));
 
        table.getColumns().setAll(firstName, lastName, eMail);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        table.setItems(FXCollections.observableList(gui.getCore().getListOfPassengers()));
        bp.setCenter(table);
    }
    
    public BorderPane getBorderPane() {
        return bp;
    }
    
    public void checkValue() {
        Passenger passenger = table.getSelectionModel().getSelectedItem();
        System.out.println(passenger.getFullName());
    }
}
