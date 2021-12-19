package Parts;

import Errors.FullPinionError;

public class MainGearTrain {
    private Pin ePin;
    private Pin fPin;
    private Pin tPin;
    private Pin cPin;
    private Pin bPin;

    public MainGearTrain(Gear ew,Gear ep,Gear fw,Gear fp,Gear tw,Gear tp,Gear cw) throws FullPinionError {
        this.ePin.addGears(ep);
        this.ePin.addGears(ew);

        this.fPin.addGears(fw);
        this.fPin.addGears(fp);

        this.tPin.addGears(tw);
        this.tPin.addGears(tp);

        this.cPin.addGears(cw);


    }


}
