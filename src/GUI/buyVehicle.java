package GUI;

import Vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class buyVehicle implements Runnable {
    private ArrayList<Vehicle> vehicles;
    private Vehicle selectedVehicle;
    private JFrame mainFrame;
    private final Random random = new Random();

    public buyVehicle(ArrayList<Vehicle> vehicles, Vehicle selectedVehicle, JFrame mainFrame) {
        this.vehicles = vehicles;
        this.selectedVehicle = selectedVehicle;
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        Class<?> vehicleClass = vehicles.getClass();
        ReentrantLock lock = Lock.getLock(vehicleClass);

        if (lock.tryLock()) {
            try {
                // Create progress dialog for initial wait
                JDialog waitDialog = new JDialog(mainFrame, "Processing Purchase", false);
                waitDialog.setLayout(new FlowLayout());
                waitDialog.add(new JLabel("Processing purchase request... Please wait"));
                waitDialog.setSize(300, 100);
                waitDialog.setLocationRelativeTo(mainFrame);

                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        // Random delay between 5-10 seconds
                        int delay = random.nextInt(5000, 10000);
                        Thread.sleep(delay);
                        return null;
                    }

                    @Override
                    protected void done() {
                        waitDialog.dispose();
                        // Show confirmation dialog
                        int choice = JOptionPane.showConfirmDialog(null, 
                            "Are you sure you want to buy this vehicle?");
                        
                        if (choice == JOptionPane.YES_OPTION) {
                            // Show database update dialog
                            JDialog updateDialog = new JDialog(mainFrame, "Updating Database", false);
                            updateDialog.setLayout(new FlowLayout());
                            updateDialog.add(new JLabel("Updating database... Please wait"));
                            updateDialog.setSize(300, 100);
                            updateDialog.setLocationRelativeTo(mainFrame);
                            
                            SwingWorker<Void, Void> updateWorker = new SwingWorker<>() {
                                @Override
                                protected Void doInBackground() throws Exception {
                                    // Random delay between 3-8 seconds
                                    int updateDelay = random.nextInt(3000, 8000);
                                    Thread.sleep(updateDelay);
                                    return null;
                                }

                                @Override
                                protected void done() {
                                    updateDialog.dispose();
                                    buy();
                                }
                            };
                            
                            updateWorker.execute();
                            updateDialog.setVisible(true);
                        }
                    }
                };

                worker.execute();
                waitDialog.setVisible(true);

            } finally {
                lock.unlock();
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                "This vehicle is not available at the moment.", 
                "Test Drive", 
                JOptionPane.INFORMATION_MESSAGE);
        }

        SwingUtilities.invokeLater(() -> mainFrame.setVisible(true));
    }

    private void buy() {
        int select = -1;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).equals(selectedVehicle)) {
                select = i;
                break;
            }
        }
        if (select != -1) {
            vehicles.remove(select);
             new updateWindow("Buy");
        }
    }
}