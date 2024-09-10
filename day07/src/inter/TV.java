package inter;

public class TV implements Remote,Bluetooth {

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    public void volumeUp() {

    }

    @Override
    public void pairing() {
        on();
        System.out.println("Tv is pairing");
    }
}
