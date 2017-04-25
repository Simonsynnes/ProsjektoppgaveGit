/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author olavt
 */
public class TopBox {
    
    private HBox hbox;
    
    public TopBox(GUI gui) {

        hbox = new HBox();
        hbox.setStyle("-fx-background-color: #336699;");

        Button passenger = new Button("Passenger");
        passenger.setPrefSize(400, 80);
        passenger.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gui.getVisitedChildBorders().push(gui.getCurrentChildBorder());
                gui.setCurrentChildBorder(new PassengerScreen(gui));
                gui.renderScreen();
            }
        });
        
        Button crew = new Button("Crew");
        crew.setPrefSize(400, 80);
        crew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gui.getVisitedChildBorders().push(gui.getCurrentChildBorder());
                gui.setCurrentChildBorder(new CrewScreen(gui));
                gui.renderScreen();
            }
        });

        Button pilot = new Button("Pilot");
        pilot.setPrefSize(400, 80);
        pilot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gui.getVisitedChildBorders().push(gui.getCurrentChildBorder());
                gui.setCurrentChildBorder(new PilotScreen(gui));
                gui.renderScreen();
            }
        });

        Button flight = new Button("Flight");
        flight.setPrefSize(400, 80);
        flight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gui.getVisitedChildBorders().push(gui.getCurrentChildBorder());
                gui.setCurrentChildBorder(new FlightScreen(gui));
                gui.renderScreen();
            }
        });

        Button plane = new Button("Plane");
        plane.setPrefSize(400, 80);
        plane.setOnAction((ActionEvent event) -> {
            gui.getVisitedChildBorders().push(gui.getCurrentChildBorder());
            gui.setCurrentChildBorder(new PlaneScreen(gui));
            gui.renderScreen();
        });

        hbox.getChildren().addAll(passenger, crew, pilot, flight, plane);
    }
    
    public HBox getTopBox() {
        return hbox;
    }
}
