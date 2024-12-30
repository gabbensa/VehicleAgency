package Classes;

import Vehicle.LandVehicle;
import Interfaces.Motorized;
import Interfaces.Commercial;

import javax.swing.*;


public class Jeep extends LandVehicle implements Motorized,Commercial
{
    private String license="MINI";
    private double fuelConsumption;
    private double engineLifetime;
    private String mypath;

    /**
     *
     * @param modelName , model of the vehicle
     * @param fuelConsumption , indicates about fuel consumption
     * @param maxSpeed , max speed
     * @param engineLifetime , lifetime of the engine
     */
    public Jeep(String modelName, double fuelConsumption, int maxSpeed, double engineLifetime)
    {
        super(modelName,5,maxSpeed,4,"Dirt");
        this.fuelConsumption=fuelConsumption;
        this.engineLifetime=engineLifetime;
    }


    @Override
    public String getLicense()
    {
        return this.license;
    }

    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

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

    public String toString()
    {
        return "Jeep: "+
                 super.toString()+
                ", Fuel average:"+getFuelConsumption()+
                 ",Engine lifetime: "+getEngineLifetime()+
                 ", License: "+getLicense();
    }

    public boolean equals(Object other)
    {
        boolean t=other instanceof Jeep;
        Jeep j=null;
        if(t){j = (Jeep)other;}
        return super.equals(other)&&t&&(this.engineLifetime==j.engineLifetime)&&(this.license.equals(j.license))&&(this.fuelConsumption==j.fuelConsumption);
    }
}
