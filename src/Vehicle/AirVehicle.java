package Vehicle;

import javax.swing.*;

public class AirVehicle extends Vehicle
{
    private boolean isArmy;
    private String mypath;


    /**
     * Constructor of AirVehicle
     * @param modelName , name of the vehicle
     * @param maxPassengers , max passengers
     * @param maxSpeed , max speed
     * @param isArmy , indicate if the vehicle is for army or civil using
     */
    public AirVehicle(String modelName, int maxPassengers, int maxSpeed, boolean isArmy) {
        super(modelName, maxPassengers, maxSpeed);
        this.isArmy=isArmy;
    }
    public void Travel(int distance)
    {
        super.Travel(distance);
    }

    public void setArmy(boolean isArmy)
    {
        this.isArmy=isArmy;
    }

    public boolean getIsArmy()
    {
        return isArmy;
    }
    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString()
    {
        return super.toString() +
                 "Army: "+ getIsArmy();
    }

    public boolean equals(Object other)
    {
        boolean t=other instanceof AirVehicle;
        AirVehicle a=null;
        if(t)
            a=(AirVehicle)other;
        return super.equals(other) && t && (this.isArmy==a.isArmy);
    }
}
