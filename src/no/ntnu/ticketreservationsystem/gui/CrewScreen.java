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
import no.ntnu.ticketreservationsystem.enteties.Crew;
import no.ntnu.ticketreservationsystem.enteties.Passenger;

/**
 *
 * @author olavt
 */
public class CrewScreen extends ChildBorder {
   
    private TableView<Passenger> table;
    
    public CrewScreen(GUI gui) {
        super(gui);
        table = new TableView<>();
        
        TableColumn firstName = new TableColumn("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn lastName = new TableColumn("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        TableColumn eMail = new TableColumn("E-mail Address");
        eMail.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        TableColumn employeeNumber = new TableColumn("EmployeeNumber");
        employeeNumber.setCellValueFactory(new PropertyValueFactory("emplyeeNumber"));
        
 
        table.getColumns().setAll(firstName, lastName, eMail, employeeNumber);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        table.setItems(FXCollections.observableList(gui.getCore().getListOfCrew()));
        bp.setCenter(table);
        
        Button viewCrewInfoBtn = new Button("View Crew Info");
        viewCrewInfoBtn.setPrefSize(500, 150);
        viewCrewInfoBtn.setOnAction((ActionEvent) -> {
            Crew crew = (Crew)table.getSelectionModel().getSelectedItem();
            ViewCrewInfo crewInfo = new ViewCrewInfo(gui, crew);
        });
        selectionBox.getChildren().add(viewCrewInfoBtn);
    }
    
    public BorderPane getBorderPane() {
        return bp;
    }
    
    public void checkValue() {
        Passenger passenger = table.getSelectionModel().getSelectedItem();
        System.out.println(passenger.getFullName());
    }
}
