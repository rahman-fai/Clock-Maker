package Parts;

import Errors.*;
import java.util.*;

public class Pin {
    private List<Gear> gears= new LinkedList<Gear>();
    private double rpm;
    private double reach;
    private String name;



    public void addGears(Gear g)throws FullPinionError {
        if (gears.size()<4 | !gears.contains(g)){
            this.gears.add(g);
        }else {
            throw new FullPinionError(g,this);
        }
        this.calcReach();
    }

    public void removeGear(Gear g) throws UnavailableGearErrors {
        if(!this.gears.remove(g)){
            throw new UnavailableGearErrors(g,this);
        }
        this.calcReach();
    }

    private void calcReach(){
        for( Gear g :this.gears){
            if(g.getDiameter()>this.reach){
                this.reach=g.getDiameter();
            }
        }
    }

    public void setRpm(double r){
        this.rpm=r;
    }

    public String getName() {
        return name;
    }
}

