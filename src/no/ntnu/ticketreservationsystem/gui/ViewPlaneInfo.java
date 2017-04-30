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
import no.ntnu.ticketreservationsystem.enteties.Plane;

/**
 *
 * @author olavt
 */
public class ViewPlaneInfo extends ViewInfoStage {

    private Plane plane;

    public ViewPlaneInfo(GUI gui, Plane plane) {
        super(gui);
        this.plane = plane;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");

        Text planeName = new Text();
        planeName.setText("Name:" + plane.getName());
        GridPane.setConstraints(planeName, 0, 0);

        Text description = new Text();
        description.setText("Description: " + plane.getDescription());
        GridPane.setConstraints(description, 0, 1);

        Text numberOfSeatRows = new Text();
        numberOfSeatRows.setText("NumberOfSeatRows:" + plane.getNumberOfSeatRows());
        GridPane.setConstraints(numberOfSeatRows, 0, 2);
        
        Text seatsWithinRow = new Text();
        seatsWithinRow.setText("SeatsWithinRow:" + plane.getSeatsWithinRow());
        GridPane.setConstraints(seatsWithinRow, 0, 3);

        grid.getChildren().addAll(planeName, description, numberOfSeatRows, seatsWithinRow);

        scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
    }

}
