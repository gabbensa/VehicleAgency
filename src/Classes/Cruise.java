package Classes;

import Vehicle.SeaVehicle;
import Interfaces.Motorized;
import Interfaces.Commercial;

import javax.swing.*;

public class Cruise extends SeaVehicle implements Motorized,Commercial
{
    private String license;
    private double fuelConsumption;
    private double engineLifetime;
    private String mypath;


    public Cruise(String modelName,int maxPassengers,int maxSpeed, double fuelConsumption, double engineLifetime)
    {
        super(modelName,maxPassengers,maxSpeed,true,"Israel");
        this.fuelConsumption=fuelConsumption;
        this.engineLifetime=engineLifetime;
        this.license="Unlimited";
    }



    @Override
    public String getLicense() {
        return this.license;
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
        return "Cruise: "+
                 super.toString()+
                 ", Fuel average(l/km): "+getFuelConsumption()+
                 ", Engine lifetime(year): "+getEngineLifetime()+
                 " , License: "+getLicense();
    }

    public boolean equals(Object other) {
        boolean t=other instanceof Cruise;
        Cruise c=null;
        if(t){c = (Cruise) other;}
        return super.equals(other)&&t&&(this.engineLifetime==c.engineLifetime)&&(this.fuelConsumption==c.fuelConsumption)&&(this.license.equals(c.license));
    }
}
