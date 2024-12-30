package Classes;

import Vehicle.Vehicle;
import Vehicle.LandVehicle;
import Vehicle.SeaVehicle;
import Interfaces.Motorized;
import Interfaces.LandInterface;
import Interfaces.SeaInterface;

import javax.swing.*;

public class Amphibious extends Vehicle implements LandInterface,SeaInterface,Motorized
{
    private LandVehicle landVehicle;
    private SeaVehicle seaVehicle;
    private double fuelConsumption;
    private double engineLifetime;
    private String mypath;



    public Amphibious(String modelName, int maxPassengers, int maxSpeed, boolean windSailing, double fuelConsumption, double engineLifetime)
    {
        super(modelName, maxPassengers, maxSpeed);
        landVehicle= new LandVehicle(modelName, maxPassengers, maxSpeed, 4,"dirt");
        seaVehicle = new SeaVehicle(modelName, maxPassengers,maxSpeed,windSailing, "Israel");
        this.fuelConsumption= fuelConsumption;
        this.engineLifetime= engineLifetime;
    }


    @Override
    public int getWheelsNum() {
        return landVehicle.getWheelsNum();
    }

    @Override
    public String getRoadType() {
        return landVehicle.getRoadType();
    }

    @Override
    public void setFuelConsumption(double fuelConsumption)
    {this.fuelConsumption=fuelConsumption;}

    @Override
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public double getEngineLifetime() {
        return this.engineLifetime;
    }

    @Override
    public void setWindSailing(boolean windSailing) {seaVehicle.setWindSailing(windSailing);}

    @Override
    public void setCountryFlag(String countryFlag) {seaVehicle.setCountryFlag(countryFlag);}

    @Override
    public boolean getWindSailing() {
        return seaVehicle.getWindSailing();
    }

    @Override
    public String getCountryFlag() {
        return seaVehicle.getCountryFlag();
    }

    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString()
    {
        String w;
        if (seaVehicle.getWindSailing() == true)
            w = "With the wind.";
        else
            w = "Without the wind.";

        return "Amphibious: "+
                super.toString()+
                ", Fuel average(l/km): "+getFuelConsumption()+
                 ", Engine lifetime(year): "+getEngineLifetime()+
                ", Under " + getCountryFlag() + " flag, " +
                 w +
                 " Num of wheels: "+ getWheelsNum()+
                ", Road type: "+ getRoadType() ;
    }

    public boolean equals(Object other) {
        boolean t=other instanceof Amphibious;
        Amphibious a=null;
        if(t){a = (Amphibious) other;}
        return super.equals(other)&&t&&(this.engineLifetime==a.engineLifetime)&&(this.fuelConsumption==a.fuelConsumption)&&(landVehicle.getRoadType()==a.getRoadType())&&(landVehicle.getWheelsNum()==a.getWheelsNum())&&(seaVehicle.getWindSailing()==a.getWindSailing());
    }
}
