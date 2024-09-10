package inter;

public interface Bluetooth {
    void pairing();

    default void on() {
        System.out.println("Bluetooth pairing");
    }
}
