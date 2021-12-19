package Parts;

import Errors.FullPinionError;

import java.util.ArrayList;

public class Clock {

    public void makeTrain(int min,int max,double mod, double BpH, int E, double d) throws FullPinionError {
        ArrayList<Double[]> options= new ArrayList<Double[]>();
        Gear EW = new Gear(E);

        for(double C=max; C>=min;C--){
            for(double T=max;T>=min;T--){
                for (double t=max;t>=min;t--){
                    for(double f =max; f>=min;f--){
                        if((C*T)/(t*f)== 60.0 ){
                            for(double F=max; F>=min;F--){
                                for(double e=max;e>=min;e--){
                                    if(((C*T*F*2*E)/(t*f*e))%60==0 && ((C*T)/(t*f))==60.0){
                                        if((F/e)==(BpH/(60.0*2*(double)E))){
                                            if(C>T && C>t && C>f && C>e && C>F){
                                                if(F*mod>72 ){
                                                    Double[] train=new Double[6];
                                                    Gear cW = new Gear((int)C,mod);
                                                    Gear tW = new Gear((int)t,mod);
                                                    Gear TW = new Gear((int)T,mod);
                                                    Gear fW = new Gear((int)f,mod);
                                                    Gear FW = new Gear((int)F,mod);
                                                    Gear eW = new Gear((int)e,mod);
                                                    train[0]=C;
                                                    train[1]=t;
                                                    train[2]=T;
                                                    train[3]=f;
                                                    train[4]=F;
                                                    train[5]=e;
                                                    int sCount=0;
                                                    for(int i=4;i>0;i=i-2){//checks wheels
                                                        double x=(train[i-1]*mod)/2+(train[i-2]*mod)/2;//distance between pinion and wheel (touching)
                                                        if (x-((train[i]*mod)/2+mod+d/2)>=1){//if distance between + tooth height(mod) > larger wheel + pin diameter
                                                            sCount++;
                                                        }
                                                    }
                                                    if(sCount==2){
                                                        MainGearTrain g = new MainGearTrain(EW,eW,FW,fW,TW,tW,cW);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }




}
