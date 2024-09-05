package oop3;

import java.util.Random;

public class Engine{
    private int serial;
    private boolean engineOnOffStatus;

    Random random = new Random();

    public Engine(){
        this.serial = random.nextInt(10000)+1;
        this.engineOnOffStatus = false;
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
                ", serial=" + serial +
                '}';
    }
}