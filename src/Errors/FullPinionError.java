package Errors;

import Parts.Gear;
import Parts.Pin;

public class FullPinionError extends Exception{
    private Pin pin;
    private Gear g;

    public FullPinionError(Gear g, Pin p){
        this.pin= p;
        this.g=g;

    }
    @Override
    public String getMessage() {
        return "Error: Unable to add "+ g.getName()+", " + pin.getName()+" is full";
    }
}
