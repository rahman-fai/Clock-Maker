package Parts;

import java.util.HashSet;
import java.util.LinkedList;

public class Gear {
    private int teethNum;
    private double mod;
    private double diameter = teethNum*mod;
    private double rpm;
    private boolean Boodriver=false;
    private String name;

    public Gear(int teethNum,double module){
        this.mod=module;
        this.teethNum=teethNum;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public double getDiameter(){
        return this.diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public int getTeethNum() {
        return teethNum;
    }
}

