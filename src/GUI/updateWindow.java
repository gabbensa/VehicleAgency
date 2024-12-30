package GUI;

import com.sun.jdi.event.ThreadStartEvent;

import javax.swing.*;
import java.awt.FlowLayout;
import java.util.Random;

class updateWindow extends JFrame {
    static final Object lock = new Object();

    private JFrame frame;
    private JProgressBar progressBar;
    private Operation operation;
    private String operationName;

    public updateWindow(String operationName)
    {
        this.operationName = operationName;
        frame=new JFrame();
        frame.setSize(600,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        progressBar= new JProgressBar(0,100);
        progressBar.setStringPainted(true);

        JLabel label= new JLabel("Updating database... Please wait!", SwingConstants.CENTER);

        operation = new Operation();
        operation.start();

        label.setBounds(50, 50, 500, 30);
        progressBar.setBounds(50, 100, 500, 30);

        frame.add(label);
        frame.add(progressBar);
        frame.setVisible(true);

    }

    private class Operation extends Thread
    {
        public void run()
        {
            try
            {
                Random random=new Random();
                int sleepTime=(random.nextInt(6)+ 3)*1000;
                int num=100/(sleepTime/100);

                for(int i=0;i<=100;i+=num)
                {
                    progressBar.setValue(i);
                    Thread.sleep(sleepTime/100);
                }
                progressBar.setValue(100);

                if (operationName== "Reset")
                    JOptionPane.showMessageDialog(null,"All distances have been reset.","Success",JOptionPane.INFORMATION_MESSAGE);
                if (operationName== "Buy")
                    JOptionPane.showMessageDialog(null,"The vehicle has been successfully purchased." ,"Success",JOptionPane.INFORMATION_MESSAGE);
                if (operationName== "Add")
                    JOptionPane.showMessageDialog(null,"The vehicle has been successfully added to the agency." ,"Success",JOptionPane.INFORMATION_MESSAGE);
                if (operationName== "Flag")
                    JOptionPane.showMessageDialog(null,"All the flags have been changed." ,"Success",JOptionPane.INFORMATION_MESSAGE);

                frame.dispose();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}