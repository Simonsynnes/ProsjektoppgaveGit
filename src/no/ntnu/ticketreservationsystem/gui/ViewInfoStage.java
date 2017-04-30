/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author olavt
 */
public abstract class ViewInfoStage {

    Stage stage;
    Scene scene;
    GUI gui;

    public ViewInfoStage(GUI gui) {
        this.gui = gui;
        stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
