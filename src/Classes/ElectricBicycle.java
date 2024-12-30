package Classes;

import Vehicle.LandVehicle;
import Interfaces.Motorized;

import javax.swing.*;
public class ElectricBicycle extends LandVehicle implements Motorized
{
    private double fuelConsumption;
    private double engineLifetime;
    private String roadType;
    private String mypath;

    public ElectricBicycle(String modelName, int maxPassengers, int maxSpeed,String roadType, double engineLifetime)
    {
        super(modelName,maxPassengers,maxSpeed,2,roadType);
        this.fuelConsumption=20;
        this.engineLifetime=engineLifetime;
    }

    public String getRoadType(){return this.roadType;}
    @Override
    public void setFuelConsumption(double fuelConsumption) { this.fuelConsumption=fuelConsumption;}

    @Override
    public double getFuelConsumption() {return this.fuelConsumption;}

    @Override
    public double getEngineLifetime() {
        return this.engineLifetime;
    }

    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString()
    {
        return "Electric Bike: "+
                super.toString()+
                ", Fuel average:"+getFuelConsumption()+
                ",Engine lifetime: "+getEngineLifetime();
    }

    public boolean equals(Object other)
    {
        boolean t=other instanceof ElectricBicycle;
        ElectricBicycle e=null;
        if(t){e = (ElectricBicycle) other;}
        return super.equals(other)&&t&&(this.engineLifetime==e.engineLifetime)&&(this.fuelConsumption==e.fuelConsumption);
    }
}
