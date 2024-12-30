package Classes;

import Vehicle.Vehicle;
import Vehicle.LandVehicle;
import Vehicle.SeaVehicle;
import Vehicle.AirVehicle;
import Interfaces.Motorized;
import Interfaces.LandInterface;
import Interfaces.SeaInterface;
import Interfaces.AirInterface;

import javax.swing.*;
public class HybridPlane extends Vehicle implements LandInterface,SeaInterface,AirInterface,Motorized
{
    private LandVehicle landVehicle;
    private SeaVehicle seaVehicle;
    private AirVehicle airVehicle;
    private double fuelConsumption;
    private double engineLifetime;
    private String myPath;


    public HybridPlane(String modelName, int maxPassengers, int maxSpeed,int wheelsNum, boolean windSailing, String flag,double fuelConsumption, double engineLifetime)
    {
        super(modelName, maxPassengers, maxSpeed);
        landVehicle= new LandVehicle(modelName, maxPassengers, maxSpeed, wheelsNum,"paved");
        seaVehicle = new SeaVehicle(modelName, maxPassengers,maxSpeed,windSailing, flag);
        airVehicle= new AirVehicle(modelName,maxPassengers,maxSpeed,true);
        this.fuelConsumption= fuelConsumption;
        this.engineLifetime= engineLifetime;
    }


    @Override
    public boolean getIsArmy() {return airVehicle.getIsArmy();}

    @Override
    public int getWheelsNum() {return landVehicle.getWheelsNum();}

    @Override
    public String getRoadType() {return landVehicle.getRoadType();}

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
    public String getCountryFlag() { return seaVehicle.getCountryFlag();}

    public void setImagePath(String mypath){this.myPath =mypath;}
    public String getImagePath(){return myPath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString()
    {
        String w;
        if (seaVehicle.getWindSailing() == true)
            w = "With the wind.";
        else
            w = "Without the wind.";

        return "Hybrid Plane: "+
                super.toString()+
                ", Fuel average(l/km): "+getFuelConsumption()+
                ", Engine lifetime(year): "+getEngineLifetime()+
                ", Under " + getCountryFlag() + " flag, " +
                w +
                " Num of wheels: "+ getWheelsNum()+
                ", Road type: "+ getRoadType() + "Army: "+ getIsArmy();
    }

    public boolean equals(Object other) {
        boolean t=other instanceof HybridPlane;
        HybridPlane h= null;
        if(t){h = (HybridPlane) other;}
        return super.equals(other)&&t&&(this.engineLifetime==h.engineLifetime)&&(this.fuelConsumption==h.fuelConsumption)&&(landVehicle.getRoadType()==h.getRoadType())&&(landVehicle.getWheelsNum()==h.getWheelsNum())&&(seaVehicle.getWindSailing()==h.getWindSailing()&&(airVehicle.getIsArmy()==h.getIsArmy()));
    }
}
