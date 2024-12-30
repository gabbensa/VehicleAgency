package GUI;
import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.ReentrantLock;

public class testVehicle implements Runnable {
    private Vehicle vehicle;
    private JFrame frame;
    private ReentrantLock lock;
    private ReentrantLock parentLock;

    public testVehicle(Vehicle vehicle, JFrame frame) {
        this.vehicle = vehicle;
        this.frame = frame;
        Class<?> vehicleClass = vehicle.getClass();
        this.lock = Lock.getLock(vehicleClass);
        this.parentLock = Lock.getParentLocked(vehicleClass);
    }

    @Override
    public void run()
    {
        if (parentLock.tryLock()) {
            try {
                if (lock.tryLock()) {
                    try {
                        JPanel inputPanel = new JPanel(new GridLayout(1, 0, 5, 5));
                        JTextField distanceField = new JTextField();
                        inputPanel.add(new JLabel("Enter the traveled distance: "));
                        inputPanel.add(distanceField);
                        int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Test Drive", JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION) {
                            makeTest(distanceField);
                        } else {
                            lock.unlock();
                            parentLock.unlock();
                        }
                    } catch (Exception e) {
                        lock.unlock();
                        parentLock.unlock();
                        throw e;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This vehicle is currently being tested or purchased.");
                }
            } finally {
                if (!lock.isHeldByCurrentThread()) {
                    parentLock.unlock();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "The mechanic is busy with another vehicle.");
        }
    }

    public void makeTest(JTextField distanceField)
    {
        try {
            String distanceString = distanceField.getText();
            distanceString = addVehicle.checksnum(distanceString, "Distance traveled");
            int distance = Integer.parseInt(distanceString);
            long sleepTime = distance * 100;

            JDialog progressDialog = new JDialog(frame, "Test Drive in Progress", false);
            progressDialog.setLayout(new FlowLayout());
            progressDialog.add(new JLabel("Test drive in progress... Please wait"));
            progressDialog.setSize(300, 100);
            progressDialog.setLocationRelativeTo(frame);

            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    Thread.sleep(sleepTime);
                    vehicle.Travel(distance);
                    return null;
                }

                @Override
                protected void done() {
                    progressDialog.dispose();
                    JOptionPane.showMessageDialog(frame, 
                        "This car has been tested successfully", 
                        "Test", 
                        JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.getRootFrame().dispose();
                    lock.unlock();
                    parentLock.unlock();
                }
            };

            worker.execute();
            progressDialog.setVisible(true);
        } catch (Exception e) {
            lock.unlock();
            parentLock.unlock();
            throw e;
        }
    }
}
