/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.gui;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
    }

    public BorderPane getBorderPane() {
        return bp;
    }
}
