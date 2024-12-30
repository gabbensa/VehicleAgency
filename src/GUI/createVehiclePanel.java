package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class createVehiclePanel extends JFrame
{
    public JPanel createVehiclePanel(String imagePath, String vehicleName, ActionListener listener)
    {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton imageButton1 = new JButton(scaledIcon);
        imageButton1.setPreferredSize(new Dimension(140, 140));
        imageButton1.addActionListener(listener);
        imageButton1.add(Box.createHorizontalStrut(80));

        JLabel label = new JLabel(vehicleName);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.add(imageButton1, BorderLayout.CENTER);
        Font font = new Font("Elephant", Font.BOLD, 20);
        label.setFont(font);
        label.setForeground(new Color(255,140,0));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.SOUTH);


        return panel;
    }
}
