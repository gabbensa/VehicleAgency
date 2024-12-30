package GUI;

import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class viewVehicles implements ActionListener
{
    private ArrayList<Vehicle> vehicles;

    public viewVehicles (ArrayList<Vehicle> vehicles)
    {
        this.vehicles=vehicles;
    }

    public void actionPerformed(ActionEvent e) {


        JPanel panel = new JPanel(new GridLayout(0, 4, 10, 10));
        panel.setPreferredSize(new Dimension(1000,400));
        for(Vehicle vehicle : vehicles) {
            ImageIcon icon = new ImageIcon(new ImageIcon(vehicle.getImagePath()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
            JLabel viewLabel = new JLabel(icon);
            ToolTipManager.sharedInstance().setInitialDelay(0);
            ToolTipManager.sharedInstance().setDismissDelay(10000);
            viewLabel.setToolTipText(vehicle.toString());
            JPanel iconPanel = new JPanel(new GridLayout(1, 1, 0, 0));
            GridBagConstraints gbc2 = new GridBagConstraints();
            gbc2.gridx = 0;
            gbc2.gridy = 1;
            gbc2.insets = new Insets(20, 0, 0, 0);
            iconPanel.add(viewLabel, gbc2);
            viewLabel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JFrame frame = new JFrame("Vehicle Options");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    int result = JOptionPane.showOptionDialog(frame, "      What would you like to do ?", "Vehicle Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Buy it", "Test it"}, null);

                    if (result == 0) {
                        buyVehicle buyVehicle = new buyVehicle(vehicles, vehicle,frame);
                        Thread buyThread = new Thread(buyVehicle);
                        buyThread.start();
                    } else if (result == 1) {
                        testVehicle testVehicle = new testVehicle(vehicle, frame);
                        Thread testThread = new Thread(testVehicle);
                        testThread.start();
                    }

                    JOptionPane.getRootFrame().dispose();
                }
            });
            panel.add(iconPanel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        JOptionPane.showMessageDialog(null, scrollPane, "All vehicles", JOptionPane.PLAIN_MESSAGE);


    }
}
