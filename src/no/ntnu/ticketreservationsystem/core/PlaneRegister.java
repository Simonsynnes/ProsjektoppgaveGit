/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.core;

import no.ntnu.ticketreservationsystem.enteties.Plane;
import java.util.ArrayList;

/**
 *
 * @author Olav
 */
public class PlaneRegister {
    private ArrayList<Plane> planes;
    
    public PlaneRegister() {
        planes = new ArrayList<>();
        fillWithPlanes();
    }
    
    public void addPlane(String name, String description, int seatsWithinRow, int numberOfSeatRows, int maxPilots, int maxCrew) {
        planes.add(new Plane(name, description, seatsWithinRow, numberOfSeatRows, maxPilots, maxCrew));
    }
    
    public ArrayList<Plane> getListWithAllPlanes() {
        return planes;
    }
    
    private void fillWithPlanes() {
        planes.add(new Plane("SmallPlane", "This Plane is the smallest plane", 6, 3, 1, 2));
        planes.add(new Plane("MediumPlane", "This Plane is the plainest plane", 6, 6, 2, 4));
        planes.add(new Plane("BigPlane", "This Plane is the biggest plane", 6, 9, 3, 6));
    }
}
