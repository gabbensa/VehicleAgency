package Vehicle;

import javax.swing.*;

public abstract class Vehicle
{
    private String modelName;
    protected int distance;
    private int maxPassengers;
    private int maxSpeed;
    private String mypath;


    /**
     * Constructor of the vehicle class
     * @param modelName , name of the vehicle
     * @param maxPassengers , num of max passengers
     * @param maxSpeed, max speed
     */
    public Vehicle(String modelName, int maxPassengers, int maxSpeed)
    {

        this.modelName=modelName;
        this.maxPassengers=maxPassengers;
        this.maxSpeed=maxSpeed;
        this.distance=0;

    }

    /**
     * Allow to update or reset the distance parameter
     * @param distance , distance that the vehicle traveled
     */
    public void Travel(int distance)
    {
        if(distance==0)
            this.distance=0;
        this.distance+=distance;
    }

    public String getModelName()
    {
        return modelName;
    }

    public double getDistance()
    {
        return distance;
    }

    public int getMaxPassengers()
    {
        return maxPassengers;
    }

    public int getMaxSpeed()
    {
        return maxSpeed;
    }
    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    /**
     * Allow to print the vehicle details
     * @return print the vehicle details
     */
    public String toString()
    {
        return "Model:"+ getModelName() +
                ", Distance traveled: "+getDistance()+" km" +
                ", Max speed of "+ getMaxSpeed() +
                "Mph, can carry max of " + getMaxPassengers() + " people. ";
    }

    /**
     * Allow to compare two objects
     * @param other , other object to compare
     * @return true if equal or false if not
     */
    public boolean equals(Object other)
    {
        boolean t=other instanceof Vehicle;
        Vehicle v=null;
        if(t)
            v=(Vehicle)other;
        return t && (this.maxSpeed==v.maxSpeed)&&(this.modelName.equals(v.modelName))&&(this.maxPassengers==v.maxPassengers);
    }
}
