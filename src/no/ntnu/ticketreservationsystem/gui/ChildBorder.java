/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author olavt
 */
public abstract class ChildBorder {
    
    protected BorderPane bp;
    protected VBox selectionBox;
    private ScrollPane scrollPane;
    private VBox scrollContent;
    private GUI gui;
    
    public ChildBorder(GUI gui) {
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
        this.gui = gui;
        selectionBox = new VBox();
        scrollContent = new VBox();
        selectionBox.setPadding(new Insets(25, 15, 30, 15));
        selectionBox.setMaxHeight(Double.MAX_VALUE);
        selectionBox.setId("selectionBox");
        selectionBox.setPrefWidth(350);
        
        Button button = new Button("New");
        button.setPrefSize(400, 120);
        button.setOnAction((ActionEvent) -> {
            Stage newStage = new Stage();
            newStage.setTitle("My New Stage Title");
                  // made a gridpane
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(5);
            grid.setHgap(5);
//Defining the Name text field
            final TextField name = new TextField();
            name.setPromptText("Enter your first name.");
            name.setPrefColumnCount(10);
            name.getText();
            GridPane.setConstraints(name, 0, 0);
            grid.getChildren().add(name);
//Defining the Last Name text field
            final TextField lastName = new TextField();
            lastName.setPromptText("Enter your last name.");
            GridPane.setConstraints(lastName, 0, 1);
            grid.getChildren().add(lastName);
//Defining the Email address text field
            final TextField email = new TextField();
            email.setPrefColumnCount(15);
            email.setPromptText("Enter your email address here.");
            GridPane.setConstraints(email, 0, 2);
            grid.getChildren().add(email);

//Defining the Submit button
            Button submit = new Button("Submit");
            GridPane.setConstraints(submit, 1, 0);
            grid.getChildren().add(submit);
//Defining the Clear button
            Button clear = new Button("Clear");
            GridPane.setConstraints(clear, 1, 1);
            grid.getChildren().add(clear);
//Adding a Label
            final Label label = new Label();
            GridPane.setConstraints(label, 0, 3);
            GridPane.setColumnSpan(label, 2);
            grid.getChildren().add(label);

//Setting an action for the Submit button
            submit.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    if ((email.getText() != null && !email.getText().isEmpty())) {
                        label.setText(name.getText() + " " + lastName.getText() + ", "
                                + "thank you for registering, you have been added to the system!");

                    } else {
                        label.setText("You have not registered yet!.");
                    }
                }
            });

//Setting an action for the Clear button
            clear.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    name.clear();
                    lastName.clear();
                    email.clear();
                    label.setText(null);
                }
            });
            
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.setScene(new Scene(grid, 1200, 600));
            newStage.show();
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
