package oop3;

import java.util.Random;

public class Engine{
    private int serial;
    private int gear;
    private boolean engineOnOffStatus;

    Random random = new Random();

    public Engine(){
        this.serial = random.nextInt(10000)+1;
        this.engineOnOffStatus = false;
        this.gear = 0;
    }


    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }


    public boolean isEngineOnOffStatus() {
        return engineOnOffStatus;
    }

    public void setEngineOnOffStatus(boolean engineOnOffStatus) {
        this.engineOnOffStatus = engineOnOffStatus;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineOnOffStatus=" + engineOnOffStatus +
                ", gear=" + gear +
                ", serial=" + serial +
                '}';
    }
}