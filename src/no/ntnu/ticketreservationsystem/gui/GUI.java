/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import no.ntnu.ticketreservationsystem.core.TicketReservationSystem;
import no.ntnu.ticketreservationsystem.enteties.EmailFormatException;

/**
 *
 * @author Olav
 */
public class GUI extends Application {

    private TicketReservationSystem mainCore;
    private ChildBorder currentChildBorder;
    private Stack<ChildBorder> visitedChildBorders;
    private BorderPane parentBorder;
    private TopBox topBox;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainCore = new TicketReservationSystem();
        for(int i = 0; i <= 15; i++) {
            mainCore.doRegisterPassenger("Olav", "Telseth", "hotmail");
        }
       
        for(int i = 0; i <= 45; i++) {
            mainCore.doCreateFlight("A3", 16, 0, 18, 0, 2); 
        }  
        for(int i = 0; i <= 15; i++) {
            try {
                mainCore.doRegisterPilot("Olav", "Telseth", "hotmail@", "49dc", "rokgr");
            } catch (EmailFormatException ex) {
                System.out.println("lol");
            }
        }
        parentBorder = new BorderPane();
        visitedChildBorders = new Stack<>();
        
        topBox = new TopBox(this);
        
        topBox.getTopBox().setId("registerBox");
        parentBorder.setTop(topBox.getTopBox());
        

        currentChildBorder = new StartScreen(this);
        parentBorder.setLeft(currentChildBorder.getLeftBox());
        renderScreen();

        Scene scene = new Scene(parentBorder, 1600, 800);
        scene.getStylesheets().add(this.getClass().getResource("TicketStyle.css").toExternalForm());

        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/res/icon-pic.png")));
        primaryStage.setTitle("Ticket Reservation System");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
    public void renderScreen() {
        parentBorder.setCenter(currentChildBorder.getBorderPane());
        parentBorder.setLeft(currentChildBorder.getLeftBox());
        currentChildBorder.getBorderPane().setId("childBorder");
    }
    
    public TicketReservationSystem getCore() {
        return mainCore;
    }
    
    public Stack<ChildBorder> getVisitedChildBorders() {
        return visitedChildBorders;
    }
    
    public ChildBorder getCurrentChildBorder() {
        return currentChildBorder;
    }
    
    public void setCurrentChildBorder(ChildBorder border) {
        currentChildBorder = border;
    }
}
