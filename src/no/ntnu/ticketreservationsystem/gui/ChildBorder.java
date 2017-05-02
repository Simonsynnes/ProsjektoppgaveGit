/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author olavt
 */
public abstract class ChildBorder {
    
    protected BorderPane bp;
    protected VBox selectionBox;
    protected boolean hasClickedTable;
    
    public ChildBorder(GUI gui) {
        hasClickedTable = false;
        createLeftBox(gui);
        bp = new BorderPane();
        bp.setPadding(new Insets(10, 35, 35, 10));
        
        //Create topbox
        HBox hb = new HBox();
        Pane spacer = new Pane();
        spacer.setStyle("-fx-background-color: rgb(0,0,0);");
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Button back = new Button("<<");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!gui.getVisitedChildBorders().empty()) {
                gui.setCurrentChildBorder(gui.getVisitedChildBorders().peek());
                gui.getVisitedChildBorders().pop();
                gui.renderScreen();
                }
            }
        });
        back.setPrefSize(50, 50);
        Button exit = new Button("X");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gui.getVisitedChildBorders().push(gui.getCurrentChildBorder());
                gui.setCurrentChildBorder(new StartScreen(gui));
                gui.renderScreen();
            }
        });
        exit.setPrefSize(50, 50);
        hb.getChildren().addAll(spacer, back, exit);
        bp.setTop(hb);
    }
    
    private void createLeftBox(GUI gui) {
        selectionBox = new VBox();
        selectionBox.setPadding(new Insets(25, 15, 30, 15));
        selectionBox.setMaxHeight(Double.MAX_VALUE);
        selectionBox.setId("selectionBox");
        selectionBox.setPrefWidth(350);
        
        Button button = new Button("New");
        button.setPrefSize(400, 120);
        button.setOnAction((ActionEvent) -> {
            RegisterNewStage nStage = new RegisterNewStage(gui);
        });

        Pane leftSpacer = new Pane();
        leftSpacer.setStyle("-fx-background-color: rgb(0,0,0);");
        VBox.setVgrow(leftSpacer, Priority.ALWAYS);
        
        selectionBox.getChildren().addAll(button, leftSpacer);
        
    }

    public VBox getLeftBox() {
        return selectionBox;
    }

    public abstract BorderPane getBorderPane();
    
}
