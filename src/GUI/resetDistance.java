package GUI;

import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class resetDistance implements ActionListener
{
    private ArrayList<Vehicle> vehicles;

    public resetDistance(ArrayList<Vehicle> vehicles)
    {
        this.vehicles=vehicles;
    }

    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the distance of all vehicles ?", "Reset Distance", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            for(int i = 0; i < vehicles.size(); i++) {
                vehicles.get(i).Travel(0);
            }
            new updateWindow("Reset");
        }
    }
}
