package workshop;

public class ElectricMotor extends Engine {
    private double batteryCapacity; // kWh
    private double maxRange; // km

    public ElectricMotor(double power, double efficiency, double batteryCapacity, double maxRange) {
        super("Electric", 0, (int)power, efficiency); // 전기 모터는 배기량이 없으므로 0
        this.batteryCapacity = batteryCapacity;
        this.maxRange = maxRange;
    }

    @Override
    public void start() {
        System.out.println("Electric motor starting silently.");
    }

    @Override
    public void stop() {
        System.out.println("Electric motor stopping.");
    }

    @Override
    public double calculateFuelConsumption(double distance, double speed) {
        // 전기차의 경우 연료 소비량을 배터리 사용량으로 계산
        // 간단한 계산을 위해 속도에 따른 효율 변화는 무시
        return (distance / maxRange) * batteryCapacity;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getMaxRange() {
        return maxRange;
    }

    @Override
    public String toString() {
        return super.toString() + ", ElectricEngine{" +
                "batteryCapacity=" + batteryCapacity +
                ", maxRange=" + maxRange +
                '}';
    }
}