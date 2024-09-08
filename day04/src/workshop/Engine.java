package workshop;

public abstract class Engine {
    private static int engineSerial = 0;
    private double displacement;
    private int horsePower;


    protected Engine(double displacement, int horsePower) {
        engineSerial++;
        this.displacement = displacement;
        this.horsePower = horsePower;
    }

    public abstract void start();
    public abstract void stop();
    public abstract double calculateFuelConsumption(double distance, double speed);


    public double getDisplacement() {
        return displacement;
    }

    public int getHorsePower() {
        return horsePower;
    }


    @Override
    public String toString() {
        return String.format("%.1fL %dHP (#%d)", displacement, horsePower, engineSerial);
    }
}