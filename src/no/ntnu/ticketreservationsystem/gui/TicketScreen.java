/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import no.ntnu.ticketreservationsystem.enteties.Passenger;
import no.ntnu.ticketreservationsystem.enteties.Ticket;

/**
 *
 * @author olavt
 */
public class TicketScreen extends ChildBorder {
    
    private TableView<Ticket> table;
    
    public TicketScreen(GUI gui) {
        super(gui);
        table = new TableView<>();
        
        TableColumn firstName = new TableColumn("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn flight = new TableColumn("Flight");
        flight.setCellValueFactory(new PropertyValueFactory("departure"));
        TableColumn seat = new TableColumn("Seat");
        seat.setCellValueFactory(new PropertyValueFactory("seatID"));
 
        table.getColumns().setAll(firstName, flight, seat);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        table.setItems(FXCollections.observableList(gui.getCore().getListOfTickets()));
        bp.setCenter(table);
        
        Button sellTicketBtn = new Button("Destroy Ticket");
        sellTicketBtn.setPrefSize(500, 150);
        sellTicketBtn.setOnAction((ActionEvent) -> {
            Ticket ticket = table.getSelectionModel().getSelectedItem();
            gui.getCore().getListOfTickets().remove(ticket);
        });
        selectionBox.getChildren().add(sellTicketBtn);
        
        Button viewPassengerInfoBtn = new Button("View Ticket Info");
        viewPassengerInfoBtn.setPrefSize(500, 150);
        viewPassengerInfoBtn.setOnAction((ActionEvent) -> {
            Ticket ticket = table.getSelectionModel().getSelectedItem();
            ViewTicketInfo ticketInfo = new ViewTicketInfo(gui, ticket);
        });
        selectionBox.getChildren().add(viewPassengerInfoBtn);
    }
    
    public BorderPane getBorderPane() {
        return bp;
    }
}
