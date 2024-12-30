package Vehicle;

import javax.swing.*;

public class LandVehicle extends Vehicle
{
    private int wheelsNum;
    private String roadType;
    private String mypath;


    /**
     * constructor of LandVehicle class
     * @param modelName , name of the vehicle
     * @param maxPassengers , num of max passengers
     * @param maxSpeed , max speed
     * @param wheelsNum , wheels num of the vehicle
     * @param roadType , type of the road the vehicle can travel on
     */
    public LandVehicle(String modelName, int maxPassengers, int maxSpeed, int wheelsNum,String roadType) {
        super(modelName, maxPassengers, maxSpeed);
        this.wheelsNum=wheelsNum;
        this.roadType=roadType;
    }

    public String getRoadType()
    {
        return roadType;
    }
    public int getWheelsNum()
    {
        return wheelsNum;
    }
    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString()
    {
        return super.toString()+
                 " Num of wheels: "+ getWheelsNum()+
                 ", Road type: "+ getRoadType();
    }

    public boolean equals(Object other)
    {
        boolean t = other instanceof LandVehicle;
        LandVehicle s = null;
        if (t) {
            s = (LandVehicle) other;
        }
        return super.equals(other) && t && (this.roadType == s.roadType) && (this.wheelsNum == s.wheelsNum);
    }
}
