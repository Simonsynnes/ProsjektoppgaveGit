/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.ntnu.ticketreservationsystem.enteties.Flight;
import no.ntnu.ticketreservationsystem.enteties.Passenger;
import no.ntnu.ticketreservationsystem.enteties.Seat;

/**
 *
 * @author olavt
 */
public class SellTicketStage {

    private GUI gui;
    private Stage stage;

    private static Flight selectedFlight;
    private static Seat selectedSeat;
    private static Passenger selectedPassenger;
    private HBox selectedItems;
    private Label selectedPassengerText;
    private Label selectedFlightText;
    private Label selectedSeatText;

    public SellTicketStage(GUI gui, Passenger passenger) {
        this.gui = gui;
        selectedPassenger = passenger;
        stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.initModality(Modality.APPLICATION_MODAL);

        BorderPane bp = new BorderPane();
        VBox vbox = new VBox();

        FlowPane fp = new FlowPane();
        fp.setPadding(new Insets(10, 10, 10, 10));
        fp.setVgap(4);
        fp.setHgap(4);

        for (Flight flight : gui.getCore().getListOfFlights()) {
            Hyperlink hl = new Hyperlink(flight.getFlightID() + "/n" + flight.getDepartureTime() + flight.getArrivalTime());
            hl.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    selectedFlight = flight;
                    fp.getChildren().clear();

                    for (Seat seat : selectedFlight.getSeatRegister().getArrayListOfSeats()) {
                        Button btn = new Button(seat.getSeatId());
                        btn.setPrefSize(50, 50);
                        btn.setOnAction((ActionEvent) -> {
                            selectedSeat = seat;
                            updateSelectedItems();
                        });
                        fp.getChildren().add(btn);
                    }
                    updateSelectedItems();
                }
            });
            vbox.getChildren().add(hl);
        }

        VBox bottomBox = new VBox();

        selectedItems = new HBox();
        selectedPassengerText = new Label();
        selectedFlightText = new Label();
        selectedSeatText = new Label();
        selectedItems.getChildren().addAll(
                selectedPassengerText,
                selectedFlightText,
                selectedSeatText);
        updateSelectedItems();

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Submit");
        submitButton.setPrefSize(300, 50);
        submitButton.setOnAction((ActionEvent) -> {
            sellTicket();
            stage.close();
        });

        buttonBox.getChildren().add(submitButton);

        bottomBox.getChildren().addAll(selectedItems, buttonBox);

        bp.setBottom(bottomBox);
        bp.setLeft(vbox);
        bp.setRight(fp);

        Scene scene = new Scene(bp, 500, 500);
        stage.setScene(scene);

        stage.show();
    }

    public SellTicketStage(GUI gui, Flight flight, Seat seat) {
        this.gui = gui;
        selectedFlight = flight;
        selectedSeat = seat;

        stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.initModality(Modality.APPLICATION_MODAL);

        BorderPane bp = new BorderPane();

        TableView<Passenger> table = new TableView<>();

        TableColumn firstName = new TableColumn("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn lastName = new TableColumn("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        TableColumn email = new TableColumn("E-mail Address");
        email.setCellValueFactory(new PropertyValueFactory("emailAddress"));

        table.getColumns().setAll(firstName, lastName, email);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.setItems(FXCollections.observableList(gui.getCore().getListOfPassengers()));

        table.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                selectedPassenger = table.getSelectionModel().getSelectedItem();
                updateSelectedItems();
            }
        });

        VBox bottomBox = new VBox();

        selectedItems = new HBox();
        selectedPassengerText = new Label();
        selectedFlightText = new Label();
        selectedSeatText = new Label();
        selectedItems.getChildren().addAll(
                selectedPassengerText,
                selectedFlightText,
                selectedSeatText);
        updateSelectedItems();

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Submit");
        submitButton.setPrefSize(300, 50);
        submitButton.setOnAction((ActionEvent) -> {
            sellTicket();
            stage.close();
        });

        buttonBox.getChildren().add(submitButton);

        bottomBox.getChildren().addAll(selectedItems, buttonBox);

        bp.setCenter(table);
        bp.setBottom(bottomBox);

        Scene scene = new Scene(bp, 500, 500);
        stage.setScene(scene);

        stage.show();
    }

    public SellTicketStage(GUI gui, Flight flight) {
        this.gui = gui;
        selectedFlight = flight;

        stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.initModality(Modality.APPLICATION_MODAL);

        BorderPane bp = new BorderPane();

        TableView<Passenger> table = new TableView<>();

        TableColumn firstName = new TableColumn("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn lastName = new TableColumn("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        TableColumn email = new TableColumn("E-mail Address");
        email.setCellValueFactory(new PropertyValueFactory("emailAddress"));

        table.getColumns().setAll(firstName, lastName, email);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.setItems(FXCollections.observableList(gui.getCore().getListOfPassengers()));

        table.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                selectedPassenger = table.getSelectionModel().getSelectedItem();
                updateSelectedItems();
            }
        });
        
        FlowPane fp = new FlowPane();
        fp.setPadding(new Insets(10, 10, 10, 10));
        fp.setVgap(4);
        fp.setHgap(4);
        
// TODO: nullpointer exception
//        for (Seat seat : selectedFlight.getSeatRegister().getArrayListOfSeats()) {
//            Button btn = new Button(seat.getSeatId());
//            btn.setPrefSize(50, 50);
//            btn.setOnAction((ActionEvent) -> {
//                selectedSeat = seat;
//                updateSelectedItems();
//            });
//            fp.getChildren().add(btn);
//        }

        VBox bottomBox = new VBox();

        selectedItems = new HBox();
        selectedPassengerText = new Label();
        selectedFlightText = new Label();
        selectedSeatText = new Label();
        selectedItems.getChildren().addAll(
                selectedPassengerText,
                selectedFlightText,
                selectedSeatText);
        updateSelectedItems();

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Submit");
        submitButton.setPrefSize(300, 50);
        submitButton.setOnAction((ActionEvent) -> {
            sellTicket();
            stage.close();
        });

        buttonBox.getChildren().add(submitButton);

        bottomBox.getChildren().addAll(selectedItems, buttonBox);

        bp.setLeft(table);
        bp.setRight(fp);
        bp.setBottom(bottomBox);

        Scene scene = new Scene(bp, 500, 500);
        stage.setScene(scene);

        stage.show();
    }

    private void sellTicket() {
        if (selectedPassenger != null && selectedFlight != null && selectedSeat != null) {
            gui.getCore().doSellTicket(
                    selectedPassenger.getFullName(),
                    selectedFlight.getDepartureTime(),
                    selectedSeat.getSeatId());
        }
    }

    private void updateSelectedItems() {

        if (selectedPassenger != null) {
            selectedPassengerText.setText(selectedPassenger.getFullName());
        }
        if (selectedFlight != null) {
            selectedFlightText.setText(selectedFlight.getDeparture());
        }
        if (selectedSeat != null) {
            selectedSeatText.setText(selectedSeat.getSeatId());
        }
    }
}
