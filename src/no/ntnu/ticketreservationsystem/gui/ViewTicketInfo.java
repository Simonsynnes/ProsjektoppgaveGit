/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import no.ntnu.ticketreservationsystem.enteties.Ticket;

/**
 *
 * @author olavt
 */
public class ViewTicketInfo extends ViewInfoStage {

    private Ticket ticket;

    public ViewTicketInfo(GUI gui, Ticket ticket) {
        super(gui);
        this.ticket = ticket;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");

        Text passengerName = new Text();
        passengerName.setText("Name:" + ticket.getPassenger().getFullName());
        GridPane.setConstraints(passengerName, 0, 0);

        Text getFlightInfo = new Text();
        getFlightInfo.setText("Flight: " + ticket.getFlight().getDepartureTime());
        GridPane.setConstraints(getFlightInfo, 0, 1);

        Text seatID = new Text();
        seatID.setText("Seat:" + ticket.getSeat().getSeatId());
        GridPane.setConstraints(seatID, 0, 2);

        grid.getChildren().addAll(passengerName, getFlightInfo, seatID);

        scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
    }

}
