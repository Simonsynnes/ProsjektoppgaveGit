/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreservationsystem;

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
    
    public void addPlane(String name, String description, int seatsWithinRow, int numberOfSeatRows) {
        planes.add(new Plane(name, description, seatsWithinRow, numberOfSeatRows));
    }
    
    public ArrayList<Plane> getListWithAllPlanes() {
        return planes;
    }
    
    public String getStringOfAllPlanes() {
        int index = 1;
        String listString = "";
        for(Plane plane : planes) {
            listString += "" + index + ". " + plane.getName() + "\n";
            index++;
        }
        return listString;
    }
    
    private void fillWithPlanes() {
        planes.add(new Plane("SmallPlane", "This Plane is the smallest plane", 6, 3));
        planes.add(new Plane("MediumPlane", "This Plane is the plainest plane", 6, 6));
        planes.add(new Plane("BigPlane", "This Plane is the biggest plane", 6, 9));
    }
}
