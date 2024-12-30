package Vehicle;

import javax.swing.*;

public class SeaVehicle extends Vehicle
{
    private boolean windSailing;
    private String countryFlag;
    private String mypath;


    /**
     * constructor of SeaVehicle class
     * @param modelName , name of vehicle
     * @param maxPassengers , num of passengers
     * @param maxSpeed , max speed
     * @param windSailing , indicates if the vehicle is sailing with the wind or not
     * @param countryFlag , Flag of the vehicle
     */
    public SeaVehicle(String modelName, int maxPassengers, int maxSpeed,boolean windSailing, String countryFlag)
    {
        super(modelName, maxPassengers, maxSpeed);
        this.countryFlag=countryFlag;
        this.windSailing=windSailing;
    }

    public void setWindSailing(boolean windSailing)
    {
        this.windSailing=windSailing;
    }

    public void setCountryFlag(String countryFlag)
    {
        this.countryFlag=countryFlag;
    }

    public boolean getWindSailing()
    {
        return windSailing;
    }

    public String getCountryFlag()
    {
        return countryFlag;
    }

    public void Travel(int distance)
    {
        super.Travel(distance);
    }
    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString() {
        String w;
        if (windSailing == true)
            w = "With the wind";
        else
            w = "Without the wind";

        return super.toString() +
                "Under " + getCountryFlag() + " flag, " +
                w;
    }
    public boolean equals(Object other) {
        boolean t=other instanceof SeaVehicle;
        SeaVehicle s=null;
        if(t){s = (SeaVehicle)other;}
            return super.equals(other)&&t&&(this.windSailing==s.windSailing)&&(this.countryFlag.equals(s.countryFlag));
    }
}
