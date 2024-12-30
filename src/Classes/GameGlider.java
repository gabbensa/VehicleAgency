package Classes;
import Vehicle.AirVehicle;
import Interfaces.NonMotorized;

import javax.swing.*;

public class GameGlider extends AirVehicle implements NonMotorized {

    private String powerSource;
    private String energeticScore;
    private String mypath;



    public GameGlider()
    {
        super("Toy", 0, 10, false);
        this.powerSource = "Manual";
        this.energeticScore = "A";
    }


    @Override
    public String getPowerSource() {
        return powerSource;
    }

    @Override
    public String getEnergeticScore() {
        return energeticScore;
    }
    public void setImagePath(String mypath){this.mypath=mypath;}
    public String getImagePath(){return mypath;}
    public ImageIcon getImageIcon() {return new ImageIcon(getImagePath());}

    public String toString() {
        return "Game Glider: " +
                super.toString() +
                ", Power source: " + getPowerSource() +
                 ", Energetic score: " + getEnergeticScore();
    }

    public boolean equals(Object other) {
        boolean t = other instanceof GameGlider;
        GameGlider g = null;
        if (t) {
            g = (GameGlider) other;
        }
        return super.equals(other) && t && (this.energeticScore == g.energeticScore) && (this.powerSource==g.powerSource );
    }
}