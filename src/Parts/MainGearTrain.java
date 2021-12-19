package Parts;

import Errors.FullPinionError;

public class MainGearTrain {
    private Pin ePin;
    private Pin fPin;
    private Pin tPin;
    private Pin cPin;
    private Pin bPin;

    public MainGearTrain(Gear e,Gear fw,Gear fp,Gear tw,Gear tp,Gear cw,Gear cp,Gear bw) throws FullPinionError {
        this.ePin.addGears(e);

        this.fPin.addGears(fw);
        this.fPin.addGears(fp);

        this.tPin.addGears(tw);
        this.tPin.addGears(tp);

        this.cPin.addGears(cw);
        this.cPin.addGears(cp);

        this.bPin.addGears(bw);

    }


}
