package GUI;

import Classes.*;
import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import GUI.*;

public class addVehicle extends JFrame
{

    private String selectedPath;
    private boolean chosen;

    public void addVehicle(String name,  ArrayList<Vehicle> vehicles) {


        if(name.equals("Jeep")) {


            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
            inputPanel.setPreferredSize(new Dimension(400,200));

            JTextField modelField = new JTextField();
            JTextField maxSpeedfield = new JTextField();
            JTextField fuelconsumptionField = new JTextField();
            JTextField lifetimeField = new JTextField();
            chosen = false;

            inputPanel.add(new JLabel("Model Name :"));
            inputPanel.add(modelField);
            inputPanel.add(new JLabel ("Max speed (Km/h):"));
            inputPanel.add(maxSpeedfield);
            inputPanel.add(new JLabel("Fuel consumption (Liter):"));
            inputPanel.add(fuelconsumptionField);
            inputPanel.add(new JLabel("Engine Lifetime (Year):"));
            inputPanel.add(lifetimeField);

            JButton chooseIcon = new JButton("Choose your Jeep");
            inputPanel.add(new JLabel(""));
            inputPanel.add(chooseIcon);



            chooseIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    JPanel choicePanel = new JPanel(new GridLayout(0, 3, 10, 10));


                    ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/Vehicles/JeepGreen.png").getImage().getScaledInstance(120, 150, Image.SCALE_DEFAULT));
                    ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/Vehicles/JeepOrange.png").getImage().getScaledInstance(120, 110, Image.SCALE_DEFAULT));
                    ImageIcon icon3 = new ImageIcon(new ImageIcon("src/Images/Vehicles/JeepGrey.png").getImage().getScaledInstance(130, 100, Image.SCALE_DEFAULT));
                    ImageIcon [] icons = {icon1, icon2,icon3};


                    JButton button1 = new JButton(icon1);
                    JButton button2 = new JButton(icon2);
                    JButton button3 = new JButton(icon3);

                    int result = JOptionPane.showOptionDialog(inputPanel, null, "Icon Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icons, null);

                    if(result == 0) {
                        selectedPath = "src/Images/Vehicles/JeepGreen.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                        chosen = true;
                    }
                    if(result == 1) {
                        selectedPath = "src/Images/Vehicles/JeepOrange.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                        chosen = true;
                    }
                    if(result == 2) {
                        selectedPath = "src/Images/Vehicles/JeepGrey.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                        chosen = true;
                    }

                }
            });
            JOptionPane.getRootFrame().dispose();


            int result = JOptionPane.showConfirmDialog(null, inputPanel, "Create Jeep", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION) {
                String model = modelField.getText();
                String fuelconsumptionString = fuelconsumptionField.getText();
                String lifetimeString = lifetimeField.getText();
                String maxSpeedString =  maxSpeedfield.getText();

                while(model.isEmpty()) {
                    JOptionPane.showMessageDialog(inputPanel, "Please fill in the model", "Error", JOptionPane.ERROR_MESSAGE);
                    model = JOptionPane.showInputDialog("Enter model :");
                }

                fuelconsumptionString = checksnum(fuelconsumptionString, "Fuel Consumption");
                lifetimeString = checksnum(lifetimeString, "Engine Lifetime");
                maxSpeedString=checksnum(maxSpeedString,"Max Speed");

                int fuelconsumption = Integer.parseInt(fuelconsumptionString);
                int lifetime = Integer.parseInt(lifetimeString);
                int maxSpeed= Integer.parseInt(maxSpeedString);

                if(model.isEmpty() || fuelconsumptionString.isEmpty() || lifetimeString.isEmpty() || maxSpeedString.isEmpty()) {

                    JOptionPane.showMessageDialog(inputPanel, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    try {
                        Jeep jeep = new Jeep(model, fuelconsumption, maxSpeed, lifetime);
                        jeep.setImagePath(selectedPath);
                        vehicles.add(jeep);
                        JOptionPane.showMessageDialog(inputPanel, "Jeep added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);


                    }catch(NumberFormatException ex) {
                        JOptionPane.showMessageDialog(inputPanel, "Please enter a valid number for max place/fuel consumption/lifetime", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        if(name.equals("Frigate")) {

            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
            inputPanel.setPreferredSize(new Dimension(400,200));

            JTextField modelField = new JTextField();
            JSpinner maxPassengerSpinner = new JSpinner(new SpinnerNumberModel(50, 1, 1000, 10));
            JTextField maxSpeedField = new JTextField();

            String[] windOptions = {"Yes", "No"};
            JComboBox<String> windComboBox = new JComboBox<>(windOptions);

            inputPanel.add(new JLabel("Model Name :"));
            inputPanel.add(modelField);
            inputPanel.add(new JLabel ("Max Passengers (People):"));
            inputPanel.add(maxPassengerSpinner);
            inputPanel.add(new JLabel("Max Speed (Km/h):"));
            inputPanel.add(maxSpeedField);
            inputPanel.add(new JLabel("Use wind direction ?"));
            inputPanel.add(windComboBox);

            JButton chooseIcon = new JButton("Choose your Frigate");
            inputPanel.add(new JLabel(""));
            inputPanel.add(chooseIcon);

            chooseIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    JPanel choicePanel = new JPanel(new GridLayout(0, 2, 15, 15));


                    ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Frigate1.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Frigate2.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon [] icons = {icon1, icon2};

                    JButton button1 = new JButton(icon1);
                    JButton button2 = new JButton(icon2);
                    int result = JOptionPane.showOptionDialog(inputPanel, "Choose Icon", "Icon Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icons, null);
                    if(result == 0) {
                        selectedPath = "src/Images/Vehicles/Frigate1.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 1) {
                        selectedPath = "src/Images/Vehicles/Frigate2.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            int result = JOptionPane.showConfirmDialog(null, inputPanel, "Create Frigate", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION) {
                String model = modelField.getText();
                String maxSpeedString = maxSpeedField.getText();
                boolean wind = windComboBox.getSelectedItem().equals("Yes");

                int maxPassenger = (int) maxPassengerSpinner.getValue();

                while(model.isEmpty()) {
                    JOptionPane.showMessageDialog(inputPanel, "Please fill in the model", "Error", JOptionPane.ERROR_MESSAGE);
                    model = JOptionPane.showInputDialog("Enter model :");
                }
                maxSpeedString = checksnum(maxSpeedString, "Max speed");

                int maxSpeed = Integer.parseInt(maxSpeedString);

                try {
                    Frigate frigate = new Frigate(model, 0, maxSpeed, wind);
                    frigate.setImagePath(selectedPath);
                    vehicles.add(frigate);
                    JOptionPane.showMessageDialog(inputPanel, "Frigate added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(inputPanel, "Please enter a valid number for max speed/fuel consumption/lifetime", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(name.equals("SpyGlider")) {

            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));


            JTextField powersourceField = new JTextField();

            inputPanel.add(new JLabel("Power source :"));
            inputPanel.add(powersourceField);

            JButton chooseIcon = new JButton("Choose your Spy Glider");
            inputPanel.add(new JLabel(""));
            inputPanel.add(chooseIcon);

            chooseIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    JPanel choicePanel = new JPanel(new GridLayout(0, 2, 10, 10));


                    ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/Vehicles/SpyGlider1.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/Vehicles/SpyGlider2.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon icon3 = new ImageIcon(new ImageIcon("src/Images/Vehicles/SpyGlider3.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon [] icons = {icon1, icon2,icon3};

                    JButton button1 = new JButton(icon1);
                    JButton button2 = new JButton(icon2);
                    JButton button3 = new JButton(icon3);
                    int result = JOptionPane.showOptionDialog(inputPanel, "Choose Icon", "Icon Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icons, null);
                    if(result == 0) {
                        selectedPath = "src/Images/Vehicles/SpyGlider1.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 1) {
                        selectedPath = "src/Images/Vehicles/SpyGlider2.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 2) {
                        selectedPath = "src/Images/Vehicles/SpyGlider3.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            int result = JOptionPane.showConfirmDialog(inputPanel, inputPanel, "Create Spy Glider", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION) {
                String powersource = powersourceField.getText();

                while(powersource.isEmpty()) {
                    JOptionPane.showMessageDialog(inputPanel, "Please fill in the Power Source", "Error", JOptionPane.ERROR_MESSAGE);
                    powersource = JOptionPane.showInputDialog("Enter Power Source :");
                }

                try {
                    SpyGlider spyGlider = new SpyGlider(powersource);
                    spyGlider.setImagePath(selectedPath);
                    vehicles.add(spyGlider);
                    JOptionPane.showMessageDialog(inputPanel, "Spy Glider added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(inputPanel, "Please enter a valid number for max place/fuel consumption/lifetime", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(name.equals("GameGlider")) {

            JPanel choicePanel = new JPanel(new GridLayout(0, 2, 10, 10));
            choicePanel.setPreferredSize(new Dimension(400,200));

            ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/Vehicles/GameGlider1.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
            ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/Vehicles/GameGlider2.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
            ImageIcon icon3 = new ImageIcon(new ImageIcon("src/Images/Vehicles/GameGlider3.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
            ImageIcon [] icons = {icon1, icon2,icon3};

            JButton button1 = new JButton(icon1);
            JButton button2 = new JButton(icon2);
            JButton button3 = new JButton(icon3);
            int result = JOptionPane.showOptionDialog(null, "Choose Icon", "Icon Options",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icons, null);
            if(result == 0) {
                selectedPath = "src/Images/Vehicles/GameGlider1.png";
                JOptionPane.showMessageDialog(null, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            if(result == 1) {
                selectedPath = "src/Images/Vehicles/GameGlider2.png";
                JOptionPane.showMessageDialog(null, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            if(result == 2) {
                selectedPath = "src/Images/Vehicles/GameGlider3.png";
                JOptionPane.showMessageDialog(null, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

            GameGlider gameGlider = new GameGlider();
            gameGlider.setImagePath(selectedPath);
            vehicles.add(gameGlider);
            JOptionPane.showMessageDialog(null, "Game Glider added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        if(name.equals("Amphibious")) {
            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));


            JTextField modelField = new JTextField();
            JSpinner maxpassengerSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 10));
            JTextField fuelconsumptionField = new JTextField();
            JTextField lifetimeField = new JTextField();
            JTextField maxspeedField = new JTextField();
            JSpinner wheelsSpinner = new JSpinner(new SpinnerNumberModel(4, 4, 30, 2));

            String[] countryOption = {"Israel", "USA", "Germany", "Morocco", "Italy", "France", "Pirate"};
            JComboBox<String> countryComboBox = new JComboBox<>(countryOption);

            String[] windOptions = {"Yes", "No"};
            JComboBox<String> windComboBox = new JComboBox<>(windOptions);

            inputPanel.add(new JLabel("Model Name :"));
            inputPanel.add(modelField);
            inputPanel.add(new JLabel ("Max Passengers (People):"));
            inputPanel.add(maxpassengerSpinner);
            inputPanel.add(new JLabel("Max Speed (Km/h):"));
            inputPanel.add(maxspeedField);
            inputPanel.add(new JLabel ("Wheels Number :"));
            inputPanel.add(wheelsSpinner);
            inputPanel.add(new JLabel("Fuel Consumption (Liter):"));
            inputPanel.add(fuelconsumptionField);
            inputPanel.add(new JLabel("Engine Lifetime (Year):"));
            inputPanel.add(lifetimeField);
            inputPanel.add(new JLabel("Use Wind Direction ?"));
            inputPanel.add(windComboBox);
            inputPanel.add(new JLabel("Country Flag : "));
            inputPanel.add(countryComboBox);

            JButton chooseIcon = new JButton("Choose your Amphibious");
            inputPanel.add(new JLabel(""));
            inputPanel.add(chooseIcon);

            chooseIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {


                    ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Amphibi1.jpeg").getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
                    ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Amphibi2.jpeg").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));
                    ImageIcon icon3 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Amphibi3.jpeg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon [] icons = {icon1, icon2,icon3};

                    JButton button1 = new JButton(icon1);
                    JButton button2 = new JButton(icon2);
                    JButton button3 = new JButton(icon3);
                    int result = JOptionPane.showOptionDialog(inputPanel, "Choose Icon", "Icon Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icons, null);
                    if(result == 0) {
                        selectedPath = "src/Images/Vehicles/Amphibi1.jpeg";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 1) {
                        selectedPath = "src/Images/Vehicles/Amphibi2.jpeg";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 2) {
                        selectedPath = "src/Images/Vehicles/Amphibi3.jpeg";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            int result = JOptionPane.showConfirmDialog(inputPanel, inputPanel, "Create Amphibious", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION) {
                String model = modelField.getText();
                String fuelconsumptionString = fuelconsumptionField.getText();
                String lifetimeString = lifetimeField.getText();
                String maxspeedString = maxspeedField.getText();
                int wheels = (int) wheelsSpinner.getValue();
                int maxplace = (int) maxpassengerSpinner.getValue();
                boolean wind = windComboBox.getSelectedItem().equals("Yes");
                String country = (String)countryComboBox.getSelectedItem();

                while(model.isEmpty()) {
                    JOptionPane.showMessageDialog(inputPanel, "Please fill in the model", "Error", JOptionPane.ERROR_MESSAGE);
                    model = JOptionPane.showInputDialog("Enter model :");
                }
                fuelconsumptionString = checksnum(fuelconsumptionString, "Fuel Consumption");
                lifetimeString = checksnum(lifetimeString, "Life time");
                maxspeedString = checksnum(maxspeedString, "Max speed");

                int maxspeed = Integer.parseInt(maxspeedString);
                int fuelconsumption = Integer.parseInt(fuelconsumptionString);
                int lifetime = Integer.parseInt(lifetimeString);

                if(model.isEmpty() || fuelconsumptionString.isEmpty() || lifetimeString.isEmpty()) {

                    JOptionPane.showMessageDialog(inputPanel, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    try {
                        Amphibious amphi = new Amphibious(model, 0, maxspeed, wind, fuelconsumption, lifetime);
                        amphi.setImagePath(selectedPath);
                        vehicles.add(amphi);
                        JOptionPane.showMessageDialog(inputPanel, "Amphibious added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                    }catch(NumberFormatException ex) {
                        JOptionPane.showMessageDialog(inputPanel, "Please enter a valid number for max place/fuel consumption/lifetime", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        if(name.equals("Bicycle")) {

            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
            inputPanel.setPreferredSize(new Dimension(400,200));

            JTextField modelField = new JTextField();
            JSpinner maxPassengerSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
            JTextField maxspeedField = new JTextField();
            //JTextField roadTypeField = new JTextField();

            String[] roadTypeOption = {"Dirt", "Paved"};
            JComboBox<String> roadComboBox = new JComboBox<>(roadTypeOption);


            inputPanel.add(new JLabel("Model Name :"));
            inputPanel.add(modelField);
            inputPanel.add(new JLabel ("Max Passenger (People) :"));
            inputPanel.add(maxPassengerSpinner);
            inputPanel.add(new JLabel("Max Speed (Km/h):"));
            inputPanel.add(maxspeedField);
            inputPanel.add(new JLabel("Road Type :"));
            inputPanel.add(roadComboBox);

            JButton chooseIcon = new JButton("Choose your Bike");
            inputPanel.add(new JLabel(""));
            inputPanel.add(chooseIcon);

            chooseIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Bicycle1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
                    ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Bicycle2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
                    ImageIcon icon3 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Bicycle3.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon [] icons = {icon1, icon2,icon3};

                    JButton button1 = new JButton(icon1);
                    JButton button2 = new JButton(icon2);
                    JButton button3 = new JButton(icon3);
                    int result = JOptionPane.showOptionDialog(inputPanel, "Choose Icon", "Icon Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icons, null);
                    if(result == 0) {
                        selectedPath = "src/Images/Vehicles/Bicycle1.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 1) {
                        selectedPath = "src/Images/Vehicles/Bicycle2.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 2) {
                        selectedPath = "src/Images/Vehicles/Bicycle3.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            int result = JOptionPane.showConfirmDialog(inputPanel, inputPanel, "Create Bicycle", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION) {
                String model = modelField.getText();
                String maxSpeedString = maxspeedField.getText();
                int maxPassenger = (int) maxPassengerSpinner.getValue();
                String roadType = (String)roadComboBox.getSelectedItem();

                while(model.isEmpty()) {
                    JOptionPane.showMessageDialog(inputPanel, "Please fill in the model", "Error", JOptionPane.ERROR_MESSAGE);
                    model = JOptionPane.showInputDialog("Enter model :");
                }

                maxSpeedString = checksnum(maxSpeedString, "Max speed");

                int maxSpeed = Integer.parseInt(maxSpeedString);

                try {
                    Bicycle bicycle = new Bicycle(model, maxSpeed, roadType);
                    bicycle.setImagePath(selectedPath);
                    vehicles.add(bicycle);
                    JOptionPane.showMessageDialog(inputPanel, "Bicycle added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(inputPanel, "Please enter a valid number for max passengers/fuel consumption/lifetime", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(name.equals("Cruise")) {

            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
            inputPanel.setPreferredSize(new Dimension(400,200));

            JTextField modelField = new JTextField();
            JSpinner maxPassengerSpinner = new JSpinner(new SpinnerNumberModel(500, 1, 2000, 25));
            JTextField fuelConsumptionField = new JTextField();
            JTextField lifetimeField = new JTextField();
            JTextField maxSpeedField = new JTextField();

            String[] countryOption = {"Israel", "USA", "Germany", "Greece", "Italy", "Somalia", "Pirate"};
            JComboBox<String> countryComboBox = new JComboBox<>(countryOption);

            inputPanel.add(new JLabel("Model Name :"));
            inputPanel.add(modelField);
            inputPanel.add(new JLabel ("Max Passengers (People):"));
            inputPanel.add(maxPassengerSpinner);
            inputPanel.add(new JLabel("Max Speed (Km/h):"));
            inputPanel.add(maxSpeedField);
            inputPanel.add(new JLabel("Fuel Consumption (Liter):"));
            inputPanel.add(fuelConsumptionField);
            inputPanel.add(new JLabel("Engine Lifetime (years):"));
            inputPanel.add(lifetimeField);
            inputPanel.add(new JLabel("Country Flag : "));
            inputPanel.add(countryComboBox);

            JButton chooseIcon = new JButton("Choose your Cruise");
            inputPanel.add(new JLabel(""));
            inputPanel.add(chooseIcon);

            chooseIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Cruise1.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Cruise2.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon icon3 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Cruise3.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    ImageIcon [] icons = {icon1, icon2,icon3};

                    JButton button1 = new JButton(icon1);
                    JButton button2 = new JButton(icon2);
                    JButton button3 = new JButton(icon3);
                    int result = JOptionPane.showOptionDialog(inputPanel, "Choose Icon", "Icon Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icons, null);
                    if(result == 0) {
                        selectedPath = "src/Images/Vehicles/Cruise1.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 1) {
                        selectedPath = "src/Images/Vehicles/Cruise2.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 2) {
                        selectedPath = "src/Images/Vehicles/Cruise2.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            int result = JOptionPane.showConfirmDialog(inputPanel, inputPanel, "Create Cruise", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION) {
                String model = modelField.getText();
                String fuelConsumptionString = fuelConsumptionField.getText();
                String lifetimeString = lifetimeField.getText();
                String maxSpeedString = maxSpeedField.getText();
                int maxPassengers = (int) maxPassengerSpinner.getValue();
                String country = (String)countryComboBox.getSelectedItem();

                while(model.isEmpty()) {
                    JOptionPane.showMessageDialog(inputPanel, "Please fill in the model", "Error", JOptionPane.ERROR_MESSAGE);
                    model = JOptionPane.showInputDialog("Enter model :");
                }
                fuelConsumptionString = checksnum(fuelConsumptionString, "Fuel Consumption");
                lifetimeString = checksnum(lifetimeString, "Lifetime");
                maxSpeedString = checksnum(maxSpeedString, "Max speed");

                int maxSpeed = Integer.parseInt(maxSpeedString);
                int fuelConsumption = Integer.parseInt(fuelConsumptionString);
                int lifetime = Integer.parseInt(lifetimeString);

                if(model.isEmpty() || fuelConsumptionString.isEmpty() || lifetimeString.isEmpty()) {

                    JOptionPane.showMessageDialog(inputPanel, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    try {
                        Cruise cruise = new Cruise(model, maxPassengers, maxSpeed, fuelConsumption, lifetime);
                        cruise.setImagePath(selectedPath);
                        vehicles.add(cruise);
                        JOptionPane.showMessageDialog(inputPanel, "Cruise added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                    }catch(NumberFormatException ex) {
                        JOptionPane.showMessageDialog(inputPanel, "Please enter a valid number for max place/fuel consumption/lifetime", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        if(name.equals("ElectricBicycle")) {

            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
            inputPanel.setPreferredSize(new Dimension(400,200));

            JTextField modelField = new JTextField();
            JSpinner maxPassengerSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
            JTextField maxspeedField = new JTextField();
            JTextField lifetimeField = new JTextField();

            String[] roadTypeOption = {"Dirt", "Paved"};
            JComboBox<String> roadComboBox = new JComboBox<>(roadTypeOption);


            inputPanel.add(new JLabel("Model Name :"));
            inputPanel.add(modelField);
            inputPanel.add(new JLabel ("Max Passenger (People) :"));
            inputPanel.add(maxPassengerSpinner);
            inputPanel.add(new JLabel("Max Speed (Km/h):"));
            inputPanel.add(maxspeedField);
            inputPanel.add(new JLabel("Engine Lifetime (years):"));
            inputPanel.add(lifetimeField);
            inputPanel.add(new JLabel("Road Type :"));
            inputPanel.add(roadComboBox);

            JButton chooseIcon = new JButton("Choose your Electric Bike");
            inputPanel.add(new JLabel(""));
            inputPanel.add(chooseIcon);

            chooseIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/Vehicles/ElectricBike1.png").getImage().getScaledInstance(140, 110, Image.SCALE_DEFAULT));
                    ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/Vehicles/ElectricBike2.png").getImage().getScaledInstance(140, 100, Image.SCALE_DEFAULT));
                    ImageIcon icon3 = new ImageIcon(new ImageIcon("src/Images/Vehicles/ElectricBike3.png").getImage().getScaledInstance(140, 130, Image.SCALE_DEFAULT));
                    ImageIcon [] icons = {icon1, icon2,icon3};

                    JButton button1 = new JButton(icon1);
                    JButton button2 = new JButton(icon2);
                    JButton button3 = new JButton(icon3);
                    int result = JOptionPane.showOptionDialog(inputPanel, "Choose Icon", "Icon Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icons, null);
                    if(result == 0) {
                        selectedPath = "src/Images/Vehicles/ElectricBike1.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 1) {
                        selectedPath = "src/Images/Vehicles/ElectricBike2.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 2) {
                        selectedPath = "src/Images/Vehicles/ElectricBike3.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            int result = JOptionPane.showConfirmDialog(inputPanel, inputPanel, "Create Electric Bicycle", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION) {
                String model = modelField.getText();
                String maxSpeedString = maxspeedField.getText();
                int maxPassenger = (int) maxPassengerSpinner.getValue();
                String lifetimeString = lifetimeField.getText();
                String roadType = (String)roadComboBox.getSelectedItem();

                while(model.isEmpty()) {
                    JOptionPane.showMessageDialog(inputPanel, "Please fill in the model", "Error", JOptionPane.ERROR_MESSAGE);
                    model = JOptionPane.showInputDialog("Enter model :");
                }

                maxSpeedString = checksnum(maxSpeedString, "Max speed");
                lifetimeString= checksnum(lifetimeString,"Lifetime");

                int maxSpeed = Integer.parseInt(maxSpeedString);
                int lifeTime= Integer.parseInt((lifetimeString));

                try {
                    ElectricBicycle Ebicycle = new ElectricBicycle(model,maxPassenger, maxSpeed, roadType,lifeTime);
                    Ebicycle.setImagePath(selectedPath);
                    vehicles.add(Ebicycle);
                    JOptionPane.showMessageDialog(inputPanel, "Bicycle added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(inputPanel, "Please enter a valid number for max passengers/fuel consumption/lifetime", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(name.equals("HybridPlane")) {
            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));


            JTextField modelField = new JTextField();
            JSpinner maxpassengerSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
            JTextField fuelconsumptionField = new JTextField();
            JTextField lifetimeField = new JTextField();
            JTextField maxspeedField = new JTextField();
            JSpinner wheelsSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 30, 2));

            String[] countryOption = {"Israel", "USA", "Germany", "Morocco", "Italy", "France", "Pirate"};
            JComboBox<String> countryComboBox = new JComboBox<>(countryOption);

            String[] windOptions = {"Yes", "No"};
            JComboBox<String> windComboBox = new JComboBox<>(windOptions);

            inputPanel.add(new JLabel("Model Name :"));
            inputPanel.add(modelField);
            inputPanel.add(new JLabel ("Max Passengers (People):"));
            inputPanel.add(maxpassengerSpinner);
            inputPanel.add(new JLabel("Max Speed (Km/h):"));
            inputPanel.add(maxspeedField);
            inputPanel.add(new JLabel ("Wheels Number :"));
            inputPanel.add(wheelsSpinner);
            inputPanel.add(new JLabel("Fuel Consumption (Liter):"));
            inputPanel.add(fuelconsumptionField);
            inputPanel.add(new JLabel("Engine Lifetime (Year):"));
            inputPanel.add(lifetimeField);
            inputPanel.add(new JLabel("Use Wind Direction ?"));
            inputPanel.add(windComboBox);
            inputPanel.add(new JLabel("Country Flag : "));
            inputPanel.add(countryComboBox);

            JButton chooseIcon = new JButton("Choose your Hybrid Plane");
            inputPanel.add(new JLabel(""));
            inputPanel.add(chooseIcon);

            chooseIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {


                    ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Hybrid1.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));
                    ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Hybrid2.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));
                    ImageIcon icon3 = new ImageIcon(new ImageIcon("src/Images/Vehicles/Hybrid3.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));
                    ImageIcon [] icons = {icon1, icon2,icon3};

                    JButton button1 = new JButton(icon1);
                    JButton button2 = new JButton(icon2);
                    JButton button3 = new JButton(icon3);
                    int result = JOptionPane.showOptionDialog(inputPanel, "Choose Icon", "Icon Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icons, null);
                    if(result == 0) {
                        selectedPath = "src/Images/Vehicles/Hybrid1.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 1) {
                        selectedPath = "src/Images/Vehicles/Hybrid2.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(result == 2) {
                        selectedPath = "src/Images/Vehicles/Hybrid3.png";
                        JOptionPane.showMessageDialog(inputPanel, "Image chosen", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            int result = JOptionPane.showConfirmDialog(inputPanel, inputPanel, "Create Hybrid Plane", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION) {
                String model = modelField.getText();
                String fuelconsumptionString = fuelconsumptionField.getText();
                String lifetimeString = lifetimeField.getText();
                String maxspeedString = maxspeedField.getText();
                int wheels = (int) wheelsSpinner.getValue();
                int maxplace = (int) maxpassengerSpinner.getValue();
                boolean wind = windComboBox.getSelectedItem().equals("Yes");
                String country = (String)countryComboBox.getSelectedItem();

                while(model.isEmpty()) {
                    JOptionPane.showMessageDialog(inputPanel, "Please fill in the model", "Error", JOptionPane.ERROR_MESSAGE);
                    model = JOptionPane.showInputDialog("Enter model :");
                }
                fuelconsumptionString = checksnum(fuelconsumptionString, "Fuel Consumption");
                lifetimeString = checksnum(lifetimeString, "Life time");
                maxspeedString = checksnum(maxspeedString, "Max speed");

                int maxspeed = Integer.parseInt(maxspeedString);
                int fuelconsumption = Integer.parseInt(fuelconsumptionString);
                int lifetime = Integer.parseInt(lifetimeString);

                if(model.isEmpty() || fuelconsumptionString.isEmpty() || lifetimeString.isEmpty()) {

                    JOptionPane.showMessageDialog(inputPanel, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    try {
                        HybridPlane hybrid = new HybridPlane(model, maxplace, maxspeed,wheels, wind, country,fuelconsumption, lifetime);
                        hybrid.setImagePath(selectedPath);
                        vehicles.add(hybrid);
                        JOptionPane.showMessageDialog(inputPanel, "Hybrid Plane added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                    }catch(NumberFormatException ex) {
                        JOptionPane.showMessageDialog(inputPanel, "Please enter a valid number for max place/fuel consumption/lifetime", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

    }

    public static String checksnum(String s, String name) {
        while(s.isEmpty() || !s.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Please fill in the " + name + " only with numbers", "Error", JOptionPane.ERROR_MESSAGE);
            s = JOptionPane.showInputDialog("Enter " + name + " :");
        }
        return s;
    }
}
