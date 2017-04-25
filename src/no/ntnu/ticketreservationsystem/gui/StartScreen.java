/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author olavt
 */

//TODO: get the text centered
public class StartScreen extends ChildBorder {
    
    private GridPane grid;
    
    public StartScreen(GUI gui) {
        super(gui);
        HBox hbox = new HBox();
        Label welcome = new Label("Welcome!!");
        welcome.setStyle("-fx-font-size: 100;");
        hbox.setAlignment(Pos.CENTER);
        
        hbox.setStyle("-fx-background-color: white;");
        hbox.getChildren().add(welcome);
        
        bp.setCenter(hbox);
    }
    
    public BorderPane getBorderPane() {
        return bp;
    }
}
