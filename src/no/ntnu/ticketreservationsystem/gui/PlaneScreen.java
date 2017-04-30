/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import no.ntnu.ticketreservationsystem.enteties.Plane;

/**
 *
 * @author olavt
 */
public class PlaneScreen extends ChildBorder {

    private TableView table;

    public PlaneScreen(GUI gui) {
        super(gui);
        table = new TableView<>();
        
        TableColumn name = new TableColumn("PlaneName");
        name.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn description = new TableColumn("Description");
        description.setCellValueFactory(new PropertyValueFactory("description"));
 
        table.getColumns().setAll(name, description);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        table.setItems(FXCollections.observableList(gui.getCore().getArrayListOfPlane()));
        bp.setCenter(table);
        
        Button viewPlaneInfoBtn = new Button("View Plane Info");
        viewPlaneInfoBtn.setPrefSize(500, 150);
        viewPlaneInfoBtn.setOnAction((ActionEvent) -> {
            Plane plane = (Plane)table.getSelectionModel().getSelectedItem();
            ViewPlaneInfo planeInfo = new ViewPlaneInfo(gui, plane);
        });
        selectionBox.getChildren().add(viewPlaneInfoBtn);
    }

    public BorderPane getBorderPane() {
        return bp;
    }
}
