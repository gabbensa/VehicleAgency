package GUI;

import Classes.Amphibious;
import Classes.Cruise;
import Classes.Frigate;
import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public  class MenuGui extends JFrame
{
    private JPanel buttonPanelstart;
    JLabel displayfield;
    createVehiclePanel vehiclePanel=new createVehiclePanel();
    addVehicle addVehicle=new addVehicle();
    private int flag=0;

    public void MenuGui() {


        setTitle("Vehicle Agency");
        setSize(1600, 800);
        setLocationRelativeTo(null);



        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout()){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = Toolkit.getDefaultToolkit().getImage("src/Images/Back2.png");
                g.drawImage(backgroundImage, 0, 0, 1600, 800, this);
            }
        };

        panel.setPreferredSize(new Dimension(1600, 800));
        add(panel);


        JLabel label = new JLabel("Welcome to the Vehicle Agency ");
        Font font = new Font(Font.DIALOG_INPUT, Font.PLAIN, 55);
        label.setFont(font);
        label.setForeground(new Color(255,140,0));





        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 130, 0); // add some vertical space

        panel.add(label, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false);
        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(exitButton);

        startButton.setPreferredSize(new Dimension(140,80));
        exitButton.setPreferredSize(new Dimension(140,80));
        startButton.setFont(new Font(Font.DIALOG_INPUT, Font.TRUETYPE_FONT, 30));
        exitButton.setFont(new Font(Font.DIALOG_INPUT, Font.TRUETYPE_FONT, 30));

        gbc.gridy = 1;
        panel.add(buttonPanel, gbc);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });





        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArrayList<Vehicle> vehicles = new ArrayList<>();

                JLabel startlabel = new JLabel("Choose a vehicle to add to the agency");
                panel.removeAll();
                startlabel.setFont(font);
                startlabel.setForeground(new Color(255,140,0));
                gbc.insets = new Insets(0, 0, 300, 0);
                panel.add(startlabel, gbc);

                buttonPanelstart = new JPanel(new FlowLayout());
                buttonPanelstart.setOpaque(false);

                buttonPanelstart.add(vehiclePanel.createVehiclePanel("src/Images/Vehicles/Jeep.png", "Jeep", new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        addVehicle.addVehicle("Jeep", vehicles);
                    }
                }));

                buttonPanelstart.add(vehiclePanel.createVehiclePanel("src/Images/Vehicles/Frigatee.png", "Frigate", new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        addVehicle.addVehicle("Frigate", vehicles);
                    }
                }));

                buttonPanelstart.add(vehiclePanel.createVehiclePanel("src/Images/Vehicles/SpyGlider.png", "Spy Glider", new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        addVehicle.addVehicle("SpyGlider", vehicles);
                    }
                }));

                buttonPanelstart.add(vehiclePanel.createVehiclePanel("src/Images/Vehicles/GameGlider.png", "Game Glider", new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        addVehicle.addVehicle("GameGlider", vehicles);
                        if(flag==1)
                            new updateWindow("Add");

                    }
                }));

                buttonPanelstart.add(vehiclePanel.createVehiclePanel("src/Images/Vehicles/Amphibious.png", "Amphibious", new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        addVehicle.addVehicle("Amphibious", vehicles);
                    }
                }));

                buttonPanelstart.add(vehiclePanel.createVehiclePanel("src/Images/Vehicles/Bicycle.png", "Bicycle", new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        addVehicle.addVehicle("Bicycle", vehicles);
                    }
                }));

                buttonPanelstart.add(vehiclePanel.createVehiclePanel("src/Images/Vehicles/Cruise.png", "Cruise", new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        addVehicle.addVehicle("Cruise", vehicles);

                    }
                }));

                buttonPanelstart.add(vehiclePanel.createVehiclePanel("src/Images/Vehicles/ElectricBicycle.png", "Electric Bike", new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        addVehicle.addVehicle("ElectricBicycle", vehicles);
                    }
                }));

                buttonPanelstart.add(vehiclePanel.createVehiclePanel("src/Images/Vehicles/HybridPlane.png", "Hybrid Plane", new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        addVehicle.addVehicle("HybridPlane", vehicles);
                    }
                }));



                JButton continueButton = new JButton("Continue to the Menu");
                continueButton.setPreferredSize(new Dimension(300,50));
                continueButton.setFont(new Font(Font.DIALOG_INPUT, Font.TRUETYPE_FONT, 20));
                GridBagConstraints c = new GridBagConstraints();
                c.gridx = 0;
                c.gridy = 2;
                gbc.insets = new Insets(20, 0, 0, 0);
                panel.add(continueButton, c);

                GridBagConstraints gbc2 = new GridBagConstraints();
                gbc2.gridx = 0;
                gbc2.gridy = 1;
                gbc2.insets = new Insets(20, 0, 0, 0);

                panel.add(buttonPanelstart, gbc2);



                panel.revalidate();
                panel.repaint();

                flag=1;

                continueButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(!vehicles.isEmpty()) {
                            panel.removeAll();

                            JLabel menulabel = new JLabel("MENU");
                            menulabel.setFont(new Font(Font.MONOSPACED,Font.BOLD,70));
                            menulabel.setForeground(new Color(255,140,0));
                            gbc.insets = new Insets(0, 0, 300, 0);
                            panel.add(menulabel, gbc);

                            JPanel menuPanel = new JPanel(new FlowLayout());
                            menuPanel.setOpaque(false);



                            ImageIcon vehiclesIcon=new ImageIcon("src/Images/Icons/GarageIcon.png");
                            Image view=vehiclesIcon.getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH);
                            ImageIcon scaledView= new ImageIcon(view);
                            JButton viewVehicles = new JButton("View all vehicles",scaledView);
                            viewVehicles.setPreferredSize(new Dimension(180,180));
                            viewVehicles.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
                            viewVehicles.setHorizontalTextPosition(JButton.CENTER);
                            viewVehicles.setVerticalTextPosition(JButton.BOTTOM);
                            viewVehicles.setIconTextGap(-32);

                            ImageIcon resetIcon=new ImageIcon("src/Images/Icons/Reset.png");
                            Image reset=resetIcon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
                            ImageIcon scaledReset= new ImageIcon(reset);
                            JButton resetDistance = new JButton("Reset distance",scaledReset);
                            resetDistance.setPreferredSize(new Dimension(180,180));
                            resetDistance.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
                            resetDistance.setHorizontalTextPosition(JButton.CENTER);
                            resetDistance.setVerticalTextPosition(JButton.BOTTOM);
                            resetDistance.setIconTextGap(-15);

                            ImageIcon flagIcon=new ImageIcon("src/Images/Icons/FlagIcon.png");
                            Image flag= flagIcon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
                            ImageIcon scaledFlag= new ImageIcon(flag);
                            JButton changeFlag = new JButton("Change flag",scaledFlag);
                            changeFlag.setPreferredSize(new Dimension(180,180));
                            changeFlag.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
                            changeFlag.setHorizontalTextPosition(JButton.CENTER);
                            changeFlag.setVerticalTextPosition(JButton.BOTTOM);
                            changeFlag.setIconTextGap(-15);

                            ImageIcon moreIcon=new ImageIcon("src/Images/Icons/MoreIcon.png");
                            Image more= moreIcon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
                            ImageIcon scaledAdd= new ImageIcon(more);
                            JButton moreVehicles = new JButton("Add more vehicle",scaledAdd);
                            moreVehicles.setPreferredSize(new Dimension(180,180));
                            moreVehicles.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
                            moreVehicles.setHorizontalTextPosition(JButton.HORIZONTAL);
                            moreVehicles.setVerticalTextPosition(JButton.BOTTOM);
                            moreVehicles.setIconTextGap(-15);

                            ImageIcon exitIcon=new ImageIcon("src/Images/Icons/ExitIcon.png");
                            Image exit1= exitIcon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
                            ImageIcon scaledExit= new ImageIcon(exit1);
                            JButton exit = new JButton("Exit",scaledExit);
                            exit.setPreferredSize(new Dimension(180,180));
                            exit.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 17));
                            exit.setHorizontalTextPosition(JButton.CENTER);
                            exit.setVerticalTextPosition(JButton.BOTTOM);
                            exit.setIconTextGap(-15);

                            menuPanel.add(viewVehicles);
                            menuPanel.add(resetDistance);
                            menuPanel.add(changeFlag);
                            menuPanel.add(moreVehicles);
                            menuPanel.add(exit);


                            gbc.insets = new Insets(0, 0, 0, 0);
                            panel.add(menuPanel, gbc);

                            panel.revalidate();
                            panel.repaint();

                            moreVehicles.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    panel.removeAll();
                                    gbc.insets = new Insets(0, 0, 400, 0);
                                    panel.add(startlabel, gbc);

                                    panel.add(buttonPanelstart, gbc2);

                                    panel.add(continueButton, c);

                                    panel.revalidate();
                                    panel.repaint();

                                }
                            });

                            viewVehicles.addActionListener(new viewVehicles(vehicles));
                            resetDistance.addActionListener(new resetDistance(vehicles));

                            changeFlag.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    //"Israel", "USA", "Germany", "Morocco", "Italy", "France", "Pirate"
                                    JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
                                    ImageIcon[] flagIcon = {new ImageIcon(new ImageIcon("src/Images/Flags/Israel.png").getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT)),
                                            new ImageIcon(new ImageIcon("src//Images/Flags/usa.png").getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT)),
                                            new ImageIcon(new ImageIcon("src//Images/Flags/germany.png").getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT)),
                                            new ImageIcon(new ImageIcon("src//Images/Flags/Greece.png").getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT)),
                                            new ImageIcon(new ImageIcon("src//Images/Flags/italy.png").getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT)),
                                            new ImageIcon(new ImageIcon("src//Images/Flags/Somalia.png").getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT)),
                                            new ImageIcon(new ImageIcon("src//Images/Flags/pirate.png").getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT))};
                                    String[] countryOption = {"Israel", "USA", "Germany", "Greece", "Italy", "Somalia", "Pirate"};
                                    JComboBox<ImageIcon> countryComboBox = new JComboBox<>(flagIcon);
                                    inputPanel.add(new JLabel("Choose new country flag: "));
                                    inputPanel.add(countryComboBox);
                                    int result = JOptionPane.showConfirmDialog(null, inputPanel, "Choose country", JOptionPane.OK_CANCEL_OPTION);
                                    if(result == JOptionPane.OK_OPTION) {

                                        int selectedIndex = countryComboBox.getSelectedIndex();
                                        String newcountry = countryOption[selectedIndex];
                                        for(int i = 0; i < vehicles.size(); i++) {
                                            if(vehicles.get(i) instanceof Frigate) {
                                                ((Frigate)vehicles.get(i)).setCountryFlag(newcountry);
                                            }
                                            if(vehicles.get(i) instanceof Amphibious) {
                                                ((Amphibious)vehicles.get(i)).setCountryFlag(newcountry);
                                            }
                                            if(vehicles.get(i) instanceof Cruise) {
                                                ((Cruise)vehicles.get(i)).setCountryFlag(newcountry);
                                            }
                                        }
                                        //JOptionPane.showMessageDialog(null, "All the flags have been change to " + newcountry+".", "Flags changed successfully", JOptionPane.INFORMATION_MESSAGE);
                                        new updateWindow("Flag");
                                    }
                                }
                            });
                            exit.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                                    if (choice == JOptionPane.YES_OPTION) {
                                        dispose();
                                    }
                                    System.exit(0);
                                }
                            });
                        } else {
                            JOptionPane.showMessageDialog(null, "Sorry, you should add at least  1 vehicle before continue", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                });

            }
        });
    }

    @Override
    public String toString() {
        return "MainGui{" +
                "displayfield=" + displayfield +
                '}';
    }

    // Add this method to check for active operations
    private boolean hasActiveOperations() {
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        while (rootGroup.getParent() != null) {
            rootGroup = rootGroup.getParent();
        }

        Thread[] threads = new Thread[rootGroup.activeCount()];
        rootGroup.enumerate(threads);

        for (Thread thread : threads) {
            if (thread != null && thread.isAlive()) {
                // Check if the thread is a test drive or purchase operation
                String threadName = thread.getClass().getName();
                if (threadName.contains("testVehicle") ||
                    threadName.contains("buyVehicle")) {
                    return true;
                }
            }
        }
        return false;
    }

}
