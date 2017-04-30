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
import javafx.scene.layout.GridPane;
import no.ntnu.ticketreservationsystem.enteties.Flight;

/**
 *
 * @author olavt
 */
public class FlightScreen extends ChildBorder {

    protected GridPane grid;
    private TableView table;

    public FlightScreen(GUI gui) {
        super(gui);
        table = new TableView<>();
        
        TableColumn flightId = new TableColumn("Flight ID");
        flightId.setCellValueFactory(new PropertyValueFactory("flightID"));
        TableColumn departure = new TableColumn("Departure");
        departure.setCellValueFactory(new PropertyValueFactory("departure"));
        TableColumn arrival = new TableColumn("Arrival");
        arrival.setCellValueFactory(new PropertyValueFactory("arrival"));
 
        table.getColumns().setAll(flightId, departure, arrival);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        table.setItems(FXCollections.observableList(gui.getCore().getListOfFlights()));
        bp.setCenter(table);
        
        Button sellTicketBtn = new Button("Sell Ticket");
        sellTicketBtn.setPrefSize(500, 150);
        selectionBox.getChildren().add(sellTicketBtn);
        
        Button viewFlightInfoBtn = new Button("View Flight Info");
        viewFlightInfoBtn.setPrefSize(500, 150);
        viewFlightInfoBtn.setOnAction((ActionEvent) -> {
            Flight flight = (Flight) table.getSelectionModel().getSelectedItem();
            ViewFlightInfo flightInfo = new ViewFlightInfo(gui, flight);
        });
        selectionBox.getChildren().add(viewFlightInfoBtn);
    }

    @Override
    public BorderPane getBorderPane() {
        return bp;
    }
}
