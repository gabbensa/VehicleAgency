package Classes;
import Vehicle.SeaVehicle;
import Interfaces.Motorized;

import javax.swing.*;

public class Frigate extends SeaVehicle implements Motorized
{

    private double fuelConsumption;
    private double engineLifetime;
    private String mypath;


    /**
     * constructor of Frigate class
     * @param modelName , name of vehicle
     * @param maxPassengers , num of passengers
     * @param maxSpeed , max speed
     * @param windSailing , indicates if the vehicle is sailing with the wind or not
     */
    public Frigate(String modelName, int maxPassengers, int maxSpeed,boolean windSailing)
    {
        super(modelName,maxPassengers,maxSpeed,windSailing,"Israel");
        this.fuelConsumption=500;
        this.engineLifetime=4;
    }



    @Override
    public void setFuelConsumption(double fuelConsumption)
    {
        this.fuelConsumption=fuelConsumption;
    }

    @Override
    public double getFuelConsumption()
    {
        return this.fuelConsumption;
    }

    @Override
    public double getEngineLifetime()
    {
        return this.engineLifetime;
    }

    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString()
    {
        return "Frigate: "+
                 super.toString()+
                ",\n Fuel average(l/km): "+ + getFuelConsumption()+
                ", \nEngine lifetime(year): "+getEngineLifetime();
    }

    public boolean equals(Object other) {
        boolean t=other instanceof Frigate;
        Frigate f=null;
        if(t){f = (Frigate)other;}
        return super.equals(other)&&t&&(this.engineLifetime==f.engineLifetime)&&(this.fuelConsumption==f.fuelConsumption);
    }
}
