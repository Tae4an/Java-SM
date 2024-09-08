package workshop;

public class ElectricMotor extends Engine {
    private double efficiency; // 효율 (0.0 ~ 1.0)

    public ElectricMotor(double displacement, int horsePower, double efficiency) {
        super(displacement, horsePower);
        this.efficiency = efficiency;
    }

    @Override
    public void start() {
        System.out.println("전기 모터가 조용히 시동됩니다.");
    }

    @Override
    public void stop() {
        System.out.println("전기 모터가 즉시 정지합니다.");
    }

    @Override
    public double calculateFuelConsumption(double distance, double speed) {
        // 전기차의 경우 연료 소비량 대신 전력 소비량을 계산 (kWh)
        double timeHours = distance / speed;
        double powerConsumption = getHorsePower() * 0.745 * timeHours; // 마력을 kW로 변환
        return powerConsumption / efficiency;
    }

    @Override
    public String toString() {
        return String.format("ElectricMotor: %.1fL %dHP (효율: %.1f%%)",
                getDisplacement(), getHorsePower(), efficiency * 100);
    }
}