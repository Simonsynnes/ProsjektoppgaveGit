/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Olav
 */
public class RegisterNewStage {

    Stage stage;
    Scene startScene, passengerScene, pilotScene, crewScene, flightScene, planeScene;

    public RegisterNewStage(GUI gui) {
        stage = new Stage();
        createStartScene();
        stage.setScene(startScene);
        stage.setTitle("My New Stage Title");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    private void createStartScene() {

        FlowPane fp = new FlowPane();
        fp.setPadding(new Insets(10, 10, 10, 10));
        fp.setStyle("-fx-background-color: black" + "-fx-font-size: 80;");
        fp.setAlignment(Pos.CENTER);

        Button bt1 = new Button("Register New Passenger");
        bt1.setPrefSize(400, 150);
        bt1.setOnAction((ActionEvent) -> {
            createRegisterPassengerScene();
            stage.setScene(passengerScene);

        });

        Button bt2 = new Button("Register New Crew");
        bt2.setPrefSize(400, 150);
        bt2.setOnAction((ActionEvent) -> {
        createRegisterCrewScene();
        stage.setScene(crewScene);
        });

        Button bt3 = new Button("Register New Pilot");
        bt3.setPrefSize(400, 150);
        bt3.setOnAction((ActionEvent) -> {
        createRegisterPilotScene();
        stage.setScene(pilotScene);
        });

        Button bt4 = new Button("Register New Flight");
        bt4.setPrefSize(400, 150);
        bt4.setOnAction((ActionEvent) -> {
        createRegisterFlightScene();
        stage.setScene(flightScene);
        });

        Button bt5 = new Button("Register New Plane");
        bt5.setPrefSize(400, 150);

        fp.getChildren().addAll(bt1, bt2, bt3, bt4, bt5);

        startScene = new Scene(fp, 850, 500);
    }

    private void createRegisterPassengerScene() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");
        
        TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(10);
        GridPane.setConstraints(name, 0, 0);
        
        TextField lastName = new TextField();
        lastName.setPromptText("Enter your last name.");
        GridPane.setConstraints(lastName, 0, 1);
        
        TextField email = new TextField();
        email.setPrefColumnCount(15);
        email.setPromptText("Enter your email address here.");
        GridPane.setConstraints(email, 0, 2);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 0);
        
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);
        
        Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);

        //Setting an action for the Submit button

        submit.setOnAction((ActionEvent) -> {
            if ((email.getText() != null && !email.getText().isEmpty())) {
                label.setText(name.getText() + " " + lastName.getText() + ", "
                        + "thank you for registering, you have been added to the system!");

            } else {
                label.setText("You have not registered yet!.");
            }
        });

        //Setting an action for the Clear button
        
        clear.setOnAction((ActionEvent) -> {
            name.clear();
            lastName.clear();
            email.clear();
            label.setText(null);
        });
        grid.getChildren().addAll(name, lastName, email, submit, clear, label);
        passengerScene = new Scene(grid, 850, 500);
    }
      private void createRegisterCrewScene() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");
        
        TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(10);
        GridPane.setConstraints(name, 0, 0);
        
        TextField lastName = new TextField();
        lastName.setPromptText("Enter your last name.");
        GridPane.setConstraints(lastName, 0, 1);
        
        TextField email = new TextField();
        email.setPrefColumnCount(15);
        email.setPromptText("Enter your email address here.");
        GridPane.setConstraints(email, 0, 2);
        
        TextField employeeNumber = new TextField();
        employeeNumber.setPrefColumnCount(20);
        employeeNumber.setPromptText("Enter employee ID here.");
        GridPane.setConstraints(employeeNumber, 0, 3);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 0);
        
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);
        
        Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);

        //Setting an action for the Submit button

        submit.setOnAction((ActionEvent) -> {
            if ((email.getText() != null && !email.getText().isEmpty())) {
                label.setText(name.getText() + " " + lastName.getText() + ", "
                        + "Welcome to the team, you have been added to the system as a pilot!");

            } else {
                label.setText("You have not registered yet!.");
            }
        });

        //Setting an action for the Clear button
        
        clear.setOnAction((ActionEvent) -> {
            name.clear();
            lastName.clear();
            email.clear();
            employeeNumber.clear();
            label.setText(null);
        });
        grid.getChildren().addAll(name, lastName, email, employeeNumber,  submit, clear, label);
        crewScene = new Scene(grid, 850, 500);
    }
      private void createRegisterPilotScene() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");
        
        TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(10);
        GridPane.setConstraints(name, 0, 0);
        
        TextField lastName = new TextField();
        lastName.setPromptText("Enter your last name.");
        GridPane.setConstraints(lastName, 0, 1);
        
        TextField email = new TextField();
        email.setPrefColumnCount(15);
        email.setPromptText("Enter your email address here.");
        GridPane.setConstraints(email, 0, 2);
        
        TextField employeeNumber = new TextField();
        employeeNumber.setPrefColumnCount(15);
        employeeNumber.setPromptText("Enter employee ID here.");
        GridPane.setConstraints(employeeNumber, 0, 3);
        
        TextField sertificate = new TextField();
        sertificate.setPrefColumnCount(15);
        sertificate.setPromptText("Enter certificate ID here.");
        GridPane.setConstraints(sertificate, 0, 4);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 0);
        
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);
        
        Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);

        //Setting an action for the Submit button

        submit.setOnAction((ActionEvent) -> {
            if ((email.getText() != null && !email.getText().isEmpty())) {
                label.setText(name.getText() + " " + lastName.getText() + ", "
                        + "Welcome to the team, you have been added to the system as a pilot!");

            } else {
                label.setText("You have not registered yet!.");
            }
        });

        //Setting an action for the Clear button
        
        clear.setOnAction((ActionEvent) -> {
            name.clear();
            lastName.clear();
            email.clear();
            employeeNumber.clear();
            sertificate.clear();
            label.setText(null);
        });
        grid.getChildren().addAll(name, lastName, email, employeeNumber, sertificate,  submit, clear, label);
        pilotScene = new Scene(grid, 850, 500);
    }
          private void createRegisterFlightScene() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");
        
        TextField flightID = new TextField();
        flightID.setPromptText("Enter flight ID.");
        flightID.setPrefColumnCount(10);
        GridPane.setConstraints(flightID, 0, 0);
        
        TextField arrivalHour = new TextField();
        arrivalHour.setPrefColumnCount(5);
        arrivalHour.setPromptText("Enter hour of arrival");
        GridPane.setConstraints(arrivalHour, 0, 1);
        
        TextField arrivalMin = new TextField();
        arrivalMin.setPrefColumnCount(5);
        arrivalMin.setPromptText("Enter minute of arrival");
        GridPane.setConstraints(arrivalMin, 1, 1);
        
        TextField departureHour = new TextField();
        departureHour.setPrefColumnCount(5);
        departureHour.setPromptText("Enter hour of departure");
        GridPane.setConstraints(departureHour, 0, 3);
        
        TextField departureMin = new TextField();
        departureMin.setPrefColumnCount(5);
        departureMin.setPromptText("Enter minute of departure");
        GridPane.setConstraints(departureMin, 1, 3);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 3, 0);
        
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 3, 1);
        
        Label label = new Label();
        GridPane.setConstraints(label, 0, 6);
        GridPane.setColumnSpan(label, 2);

        //Setting an action for the Submit button

        submit.setOnAction((ActionEvent) -> {
           label.setText("Flight has been registered to the system!");
        });

        //Setting an action for the Clear button
        
        clear.setOnAction((ActionEvent) -> {
            flightID.clear();
            departureHour.clear();
            departureMin.clear();
            arrivalHour.clear();
            arrivalMin.clear();
            label.setText(null);
        });
        grid.getChildren().addAll(flightID, departureHour, departureMin, arrivalHour, arrivalMin, submit, clear, label);
        flightScene = new Scene(grid, 850, 500);
    }
}
