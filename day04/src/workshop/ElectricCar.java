package workshop;

import workshop.exception.FuelException;
import workshop.exception.ZeroException;

public class ElectricCar extends Car {
    private double batteryCapacity; // 배터리 용량 (kWh)
    private double batteryLevel; // 현재 배터리 레벨 (%)

    public ElectricCar(String name, String color, int transmissionType, double batteryCapacity) {
        super(name, color, transmissionType, "전기차", batteryCapacity);
        this.batteryCapacity = batteryCapacity;
        this.batteryLevel = 100.0; // 처음에는 완전 충전
        setEngine(new ElectricMotor(0, 150, 0.9));
    }

    @Override
    public void drive(double distance, double speed) throws FuelException, ZeroException {
        if (speed <= 0) {
            throw new ZeroException("속도는 0보다 커야 합니다.");
        }
        if (batteryLevel <= 0) {
            throw new FuelException("배터리가 방전되었습니다.");
        }

        double consumedEnergy = ((ElectricMotor) getEngine()).calculateFuelConsumption(distance, speed);
        double consumedPercentage = (consumedEnergy / batteryCapacity) * 100;

        if (batteryLevel < consumedPercentage) {
            throw new FuelException("배터리 잔량이 부족합니다.");
        }

        batteryLevel -= consumedPercentage;
        System.out.println(getName() + "가 " + distance + "km를 " + speed + "km/h로 주행했습니다.");
        System.out.println("남은 배터리: " + String.format("%.2f", batteryLevel) + "%");
    }

    @Override
    public void addFuel(double energy) throws FuelException, ZeroException {
        if (energy <= 0) {
            throw new ZeroException("충전량은 0보다 커야 합니다.");
        }
        if (batteryLevel + energy > 100) {
            throw new FuelException("배터리 용량을 초과하여 충전할 수 없습니다.");
        }

        batteryLevel += energy;
        System.out.println(getName() + "의 배터리를 " + energy + "% 충전했습니다.");
        System.out.println("현재 배터리 레벨: " + String.format("%.2f", batteryLevel) + "%");
    }

    public void fastCharge(double minutes) throws FuelException, ZeroException {
        double chargeRate = 4.0; // % per minute for fast charging
        addFuel(minutes * chargeRate);
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        baseInfo = baseInfo.substring(0, baseInfo.lastIndexOf('\n'));

        return String.format("%s\n│ 배터리: %5.1f%% │ 용량: %5.1f kWh              \n└─────────────────────────────────────────────────────┘",
                baseInfo,
                batteryLevel, batteryCapacity);
    }
}