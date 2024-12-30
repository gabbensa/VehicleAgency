package Classes;
import Vehicle.AirVehicle;
import Interfaces.NonMotorized;

import javax.swing.*;

public class SpyGlider extends AirVehicle implements NonMotorized
{

    private String powerSource;
    private String energeticScore;
    private String mypath;


    /**
     * Constructor of the SpyGlider class
     * @param powerSource , source of the vehicle power
     */
    public SpyGlider(String powerSource)
    {
        super(" Confidential",1,50,true);
        this.powerSource=powerSource;
        this.energeticScore="C";
    }


    @Override
    public String getPowerSource()
    {
        return powerSource;
    }

    @Override
    public String getEnergeticScore()
    {
        return energeticScore;
    }
    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString()
    {
        return "Spy Glider: "+ super.toString()+
                 " Power source: "+getPowerSource()+
                 ", Energetic score: "+getEnergeticScore();
    }

    public boolean equals(Object other)
    {
        boolean t=other instanceof SpyGlider;
        SpyGlider s=null;
        if(t){s = (SpyGlider)other;}
        return super.equals(other)&&t&&(this.energeticScore==s.energeticScore)&&(this.powerSource.equals(s.powerSource));
    }
}
