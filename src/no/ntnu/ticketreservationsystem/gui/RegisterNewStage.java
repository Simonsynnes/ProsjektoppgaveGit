/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
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
import no.ntnu.ticketreservationsystem.enteties.EmailFormatException;

/**
 *
 * @author Olav
 */
public class RegisterNewStage {

    Stage stage;
    Scene startScene, passengerScene, pilotScene, crewScene, flightScene, planeScene;
    GUI gui;

    public RegisterNewStage(GUI gui) {
        this.gui = gui;
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
        bt5.setOnAction((ActionEvent) -> {
            createRegisterPlaneScene();
            stage.setScene(planeScene);
        });

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
        
         Label topLabel = new Label();
        GridPane.setConstraints(topLabel, 0, 0);
        GridPane.setColumnSpan(topLabel, 2);
        topLabel.setText("Passenger information:");

        TextField name = new TextField();
        name.setPromptText("Enter your first name");
        name.setPrefColumnCount(15);
        GridPane.setConstraints(name, 0, 1);

        TextField lastName = new TextField();
        lastName.setPromptText("Enter your last name");
        lastName.setPrefColumnCount(15);
        GridPane.setConstraints(lastName, 0, 2);

        TextField email = new TextField();
        email.setPrefColumnCount(15);
        email.setPromptText("Enter email address");
        GridPane.setConstraints(email, 0, 3);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 1);

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 2);

        Label label = new Label();
        GridPane.setConstraints(label, 0, 4);
        GridPane.setColumnSpan(label, 2);

        //Setting an action for the Submit button
        submit.setOnAction((ActionEvent) -> {
            if ((email.getText() != null && !email.getText().isEmpty())) {
                label.setText(name.getText() + " " + lastName.getText() + ", "
                        + "thank you for registering, you have been added to the system!");
                gui.getCore().doRegisterPassenger(name.getText(), lastName.getText(), email.getText());

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
        grid.getChildren().addAll(name, lastName, email, submit, clear, label, topLabel);
        passengerScene = new Scene(grid, 1000, 500);
    }

    private void createRegisterCrewScene() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");
        
        Label topLabel = new Label();
        GridPane.setConstraints(topLabel, 0, 0);
        GridPane.setColumnSpan(topLabel, 2);
        topLabel.setText("Crew information:");

        TextField name = new TextField();
        name.setPromptText("Enter your first name");
        name.setPrefColumnCount(15);
        GridPane.setConstraints(name, 0, 1);

        TextField lastName = new TextField();
        lastName.setPromptText("Enter your last name");
        lastName.setPrefColumnCount(15);
        GridPane.setConstraints(lastName, 0, 2);

        TextField email = new TextField();
        email.setPrefColumnCount(15);
        email.setPromptText("Enter email address");
        GridPane.setConstraints(email, 0, 3);

        TextField employeeNumber = new TextField();
        employeeNumber.setPrefColumnCount(15);
        employeeNumber.setPromptText("Enter employee ID");
        GridPane.setConstraints(employeeNumber, 0, 4);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 1);

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 2);

        Label label = new Label();
        GridPane.setConstraints(label, 0, 6);
        GridPane.setColumnSpan(label, 2);

        //Setting an action for the Submit button
        submit.setOnAction((ActionEvent) -> {
            if ((email.getText() != null && !email.getText().isEmpty())) {
                label.setText(name.getText() + " " + lastName.getText() + ", "
                        + "Welcome to the team, you have been added to the system as crew!");
                try {
                    gui.getCore().doRegisterCrew(name.getText(), lastName.getText(),
                            email.getText(), employeeNumber.getText());
                } catch (EmailFormatException ex) {
                    //text
                }

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
        grid.getChildren().addAll(name, lastName, email, employeeNumber, submit, clear, label, topLabel);
        crewScene = new Scene(grid, 1000, 500);
    }

    private void createRegisterPilotScene() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");
        
        Label topLabel = new Label();
        GridPane.setConstraints(topLabel, 0, 0);
        GridPane.setColumnSpan(topLabel, 2);
        topLabel.setText("Pilot information:");

        TextField name = new TextField();
        name.setPromptText("Enter your first name");
        name.setPrefColumnCount(10);
        GridPane.setConstraints(name, 0, 1);

        TextField lastName = new TextField();
        lastName.setPromptText("Enter your last name");
        lastName.setPrefColumnCount(10);
        GridPane.setConstraints(lastName, 0, 2);

        TextField email = new TextField();
        email.setPrefColumnCount(15);
        email.setPromptText("Enter email address");
        GridPane.setConstraints(email, 0, 3);

        TextField employeeNumber = new TextField();
        employeeNumber.setPrefColumnCount(15);
        employeeNumber.setPromptText("Enter employee ID");
        GridPane.setConstraints(employeeNumber, 0, 4);

        TextField sertificate = new TextField();
        sertificate.setPrefColumnCount(15);
        sertificate.setPromptText("Enter certificate ID");
        GridPane.setConstraints(sertificate, 0, 5);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 1);

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 2);

        Label label = new Label();
        GridPane.setConstraints(label, 0, 7);
        GridPane.setColumnSpan(label, 2);

        //Setting an action for the Submit button
        submit.setOnAction((ActionEvent) -> {
            if ((email.getText() != null && !email.getText().isEmpty())) {
                label.setText(name.getText() + " " + lastName.getText() + ", "
                        + "Welcome to the team, you have been added to the system as a pilot!");
                try {
                    gui.getCore().doRegisterPilot(name.getText(), lastName.getText(),
                            email.getText(), employeeNumber.getText(),
                            sertificate.getText());
                } catch (EmailFormatException ex) {
                    //text
                }

            } else {
                label.setText("You have not registered yet!");
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
        grid.getChildren().addAll(name, lastName, email, employeeNumber, sertificate, submit, clear, label, topLabel);
        pilotScene = new Scene(grid, 1000, 500);
    }

    private void createRegisterFlightScene() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");
        
         Label topLabel = new Label();
        GridPane.setConstraints(topLabel, 0, 0);
        GridPane.setColumnSpan(topLabel, 2);
        topLabel.setText("Flight information");
        

        TextField flightID = new TextField();
        flightID.setPromptText("Enter flight ID");
        flightID.setPrefColumnCount(10);
        GridPane.setConstraints(flightID, 0, 1);
        
        Label departureLabel = new Label();
        GridPane.setConstraints(departureLabel, 0, 2);
        GridPane.setColumnSpan(departureLabel, 2);
        departureLabel.setText("Time of departure");


        TextField departureHour = new TextField();
        departureHour.setPrefColumnCount(10);
        departureHour.setPromptText("Hour");
        GridPane.setConstraints(departureHour, 0, 3);

        TextField departureMin = new TextField();
        departureMin.setPrefColumnCount(15);
        departureMin.setPromptText("Min");
        GridPane.setConstraints(departureMin, 1, 3);
        
        Label arrivalLabel = new Label();
        GridPane.setConstraints(arrivalLabel, 0, 4);
        GridPane.setColumnSpan(arrivalLabel, 2);
        arrivalLabel.setText("Time of arrival");

        TextField arrivalHour = new TextField();
        arrivalHour.setPrefColumnCount(5);
        arrivalHour.setPromptText("Hour");
        GridPane.setConstraints(arrivalHour, 0, 5);

        TextField arrivalMin = new TextField();
        arrivalMin.setPrefColumnCount(5);
        arrivalMin.setPromptText("Min");
        GridPane.setConstraints(arrivalMin, 1, 5);
        
        TextField planeType = new TextField();
        planeType.setPrefColumnCount(6);
        planeType.setPromptText("Enter type of plane");
        GridPane.setConstraints(planeType, 0, 7);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 3, 1);

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 3, 2);

        Label label = new Label();
        GridPane.setConstraints(label, 0, 8);
        GridPane.setColumnSpan(label, 2);

        //Setting an action for the Submit button
        submit.setOnAction((ActionEvent) -> {
            label.setText("Flight has been registered to the system!");
            gui.getCore().doCreateFlight(flightID.getText(), 
                    Integer.parseInt(departureHour.getText()), 
                    Integer.parseInt(departureMin.getText()), 
                    Integer.parseInt(arrivalHour.getText()), 
                    Integer.parseInt(arrivalMin.getText()),
                    Integer.parseInt(planeType.getText()));
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
        grid.getChildren().addAll(flightID, departureHour, departureMin, arrivalHour, arrivalMin, planeType, submit, 
                clear, label, arrivalLabel, departureLabel, topLabel);
        flightScene = new Scene(grid, 1200, 500);
    }
    private void createRegisterPlaneScene() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-font-size: 30;");
        
        Label topLabel = new Label();
        GridPane.setConstraints(topLabel, 0, 0);
        GridPane.setColumnSpan(topLabel, 2);
        topLabel.setText("Plane information:");

        TextField planeName = new TextField();
        planeName.setPromptText("plane name");
        planeName.setPrefColumnCount(15);
        GridPane.setConstraints(planeName, 0, 1);

        TextField description = new TextField();
        description.setPrefColumnCount(15);
        description.setPromptText("short description");
        GridPane.setConstraints(description, 0, 2);

        TextField seatsInRow = new TextField();
        seatsInRow.setPrefColumnCount(15);
        seatsInRow.setPromptText("seats in row");
        GridPane.setConstraints(seatsInRow, 0, 3);

        TextField seatRowAmount = new TextField();
        seatRowAmount.setPrefColumnCount(15);
        seatRowAmount.setPromptText("seat rows");
        GridPane.setConstraints(seatRowAmount, 1, 3);

        TextField maxPilots = new TextField();
        maxPilots.setPrefColumnCount(15);
        maxPilots.setPromptText("max pilots");
        GridPane.setConstraints(maxPilots, 0, 6);
        
        TextField maxCrew = new TextField();
        maxCrew.setPrefColumnCount(10);
        maxCrew.setPromptText("max crew");
        GridPane.setConstraints(maxCrew, 0, 7);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 1);

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 2);

        Label label = new Label();
        GridPane.setConstraints(label, 0, 8);
        GridPane.setColumnSpan(label, 2);

        //Setting an action for the Submit button
        submit.setOnAction((ActionEvent) -> {
            label.setText("Plane has been registered to the system!");
            gui.getCore().doCreateNewPlane(planeName.getText(), 
                    description.getText(),
                    Integer.parseInt(seatsInRow.getText()), 
                    Integer.parseInt(seatRowAmount.getText()), 
                    Integer.parseInt(maxPilots.getText()),
                    Integer.parseInt(maxCrew.getText()));
        });

        //Setting an action for the Clear button
        clear.setOnAction((ActionEvent) -> {
            planeName.clear();
            description.clear();
            seatsInRow.clear();
            seatRowAmount.clear();
            maxPilots.clear();
            maxCrew.clear();
            label.setText(null);
        });
        grid.getChildren().addAll(planeName, description, seatsInRow, seatRowAmount, maxPilots, maxCrew, submit,
                clear, label, topLabel);
        planeScene = new Scene(grid, 1000, 500);
    }
}
