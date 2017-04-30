/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import no.ntnu.ticketreservationsystem.enteties.Flight;
import no.ntnu.ticketreservationsystem.enteties.Seat;

/**
 *
 * @author olavt
 */
public class ViewFlightInfo extends ViewInfoStage {

    Flight flight;

    public ViewFlightInfo(GUI gui, Flight flight) {
        super(gui);
        this.flight = flight;

        BorderPane bp = new BorderPane();
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");

        Text flightID = new Text();
        flightID.setText("ID: " + flight.getFlightID());
        GridPane.setConstraints(flightID, 0, 0);
        
        Text departure = new Text();
        departure.setText("departure:" + flight.getDepartureTime());
        GridPane.setConstraints(departure, 0, 1);
        
        Text arrival = new Text();
        arrival.setText("Arrival:" + flight.getArrivalTime());
        GridPane.setConstraints(arrival, 0, 2);
        
        Text planeType = new Text();
        planeType.setText("planeType:" + flight.getPlane().getName());
        GridPane.setConstraints(planeType, 0, 3);
        
        grid.getChildren().addAll(flightID, departure, arrival, planeType);
        
        bp.setCenter(grid);
        
        FlowPane fp = new FlowPane();
        fp.setPadding(new Insets(10, 10, 10, 10));
        fp.setVgap(4);
        fp.setHgap(4);

        for (Seat seat : flight.getSeatRegister().getArrayListOfSeats()) {
            Button btn = new Button(seat.getSeatId());
            btn.setPrefSize(50, 50);
            fp.getChildren().add(btn);
        }
        
        bp.setRight(fp);
        scene = new Scene(bp, 500, 500);
        stage.setScene(scene);
    }

}
