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
import no.ntnu.ticketreservationsystem.enteties.Crew;

/**
 *
 * @author olavt
 */
public class ViewCrewInfo extends ViewInfoStage {
    
    private Crew crew;
    
    public ViewCrewInfo(GUI gui, Crew crew) {
        super(gui);
        this.crew = crew;
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");

        Text firstName = new Text();
        firstName.setText("firstName:" + crew.getFirstName());
        GridPane.setConstraints(firstName, 0, 0);
        
        Text lastName = new Text();
        lastName.setText("lastName:" + crew.getLastName());
        GridPane.setConstraints(lastName, 0, 1);
        
        Text email = new Text();
        email.setText("Email:" + crew.getEmailAddress());
        GridPane.setConstraints(email, 0, 2);
        
        Text employeeNumber = new Text();
        employeeNumber.setText("EmployeeNumber:" + crew.getEmplyeeNumber());
        GridPane.setConstraints(employeeNumber, 0, 3);
        
        grid.getChildren().addAll(firstName, lastName, email, employeeNumber);
        
        scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
    }
}
