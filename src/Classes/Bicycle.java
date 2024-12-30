package Classes;

import Vehicle.LandVehicle;
import Interfaces.NonMotorized;

import javax.swing.*;

public class Bicycle extends LandVehicle implements NonMotorized
{
    String powerSource;
    String energeticScore;
    private String mypath;


    public Bicycle(String modelName,int maxSpeed,String roadType)
    {
        super(modelName,1,maxSpeed,2,roadType);
        this.powerSource="Manual";
        this.energeticScore="A";
    }
    @Override
    public String getPowerSource() {
        return this.powerSource;
    }

    @Override
    public String getEnergeticScore() {
        return this.energeticScore;
    }
    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString()
    {
        return "Bicycle: "+
                 super.toString()+
                ", Power Source:"+getPowerSource()+
                ",Energetic Score: "+getEnergeticScore();
    }

    public boolean equals(Object other)
    {
        boolean t=other instanceof Bicycle;
        Bicycle b=null;
        if(t){b = (Bicycle) other;}
        return super.equals(other)&&t&&(this.powerSource== b.powerSource)&&(this.energeticScore==b.energeticScore);
    }
}
