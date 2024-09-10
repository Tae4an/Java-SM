package inter;

public class Mobile {
    public static void main(String[] args) {
//        Remote remote=  new TV();
//        remote.turnOff();
//        remote.turnOn();

        Bluetooth bluetooth = new TV();
        bluetooth.on();
        bluetooth.pairing();
    }
}
