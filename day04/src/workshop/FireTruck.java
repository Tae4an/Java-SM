package workshop;

import workshop.exception.FuelException;
import workshop.exception.ZeroException;

public class FireTruck extends Car {
    private double waterTankCapacity; // 물탱크 용량 (리터)
    private double currentWaterLevel; // 현재 물 수준 (리터)
    private boolean isSirenOn; // 사이렌 상태

    public FireTruck(String name, String color, int transmissionType, double fuelSize) {
        super(name, color, transmissionType, "소방차", fuelSize);
        this.waterTankCapacity = 10000.0; // 10,000 리터
        this.currentWaterLevel = waterTankCapacity; // 처음에는 가득 채움
        this.isSirenOn = false;
        setEngine(new Engine(6.0, 300) { // 예시: 6.0L, 300hp 엔진
            @Override
            public void start() {
                System.out.println("소방차 엔진이 시동됩니다.");
            }

            @Override
            public void stop() {
                System.out.println("소방차 엔진이 정지합니다.");
            }

            @Override
            public double calculateFuelConsumption(double distance, double speed) {
                // 소방차의 연료 소비량 계산 (예: 기본 소비량 + 추가 10%)
                return (distance / 100) * 20 * 1.1; // 가정: 100km당 20L 소비
            }
        });
    }

    @Override
    public void drive(double distance, double speed) throws FuelException, ZeroException {
        if (speed <= 0) {
            throw new ZeroException("속도는 0보다 커야 합니다.");
        }

        double fuelNeeded = getEngine().calculateFuelConsumption(distance, speed);
        if (getCurrFuel() < fuelNeeded) {
            throw new FuelException("연료가 부족합니다.");
        }

        addFuel(-fuelNeeded); // 연료 소비
        System.out.println(getName() + "가 " + distance + "km를 " + speed + "km/h로 주행했습니다.");
        System.out.println("남은 연료: " + String.format("%.2f", getCurrFuel()) + "L");
    }

    @Override
    public void addFuel(double amount) throws FuelException, ZeroException {
        if (amount == 0) {
            throw new ZeroException("연료량은 0이 될 수 없습니다.");
        }

        double newFuelLevel = getCurrFuel() + amount;

        if (amount > 0) {  // 주유하는 경우
            if (newFuelLevel > getFuelSize()) {
                throw new FuelException("연료 탱크 용량을 초과하여 주유할 수 없습니다.");
            }
            System.out.println(getName() + "에 " + amount + "L의 연료를 주유했습니다.");
        } else {  // 연료를 소비하는 경우
            if (newFuelLevel < 0) {
                throw new FuelException("사용 가능한 연료보다 더 많은 연료를 소비할 수 없습니다.");
            }
            System.out.println(getName() + "가 " + (-amount) + "L의 연료를 소비했습니다.");
        }

        setCurrFuel(newFuelLevel);
        System.out.println("현재 연료량: " + String.format("%.2f", getCurrFuel()) + "L");
    }

    public void sprayWater(double amount) throws ZeroException {
        if (amount <= 0) {
            throw new ZeroException("분사할 물의 양은 0보다 커야 합니다.");
        }
        if (currentWaterLevel < amount) {
            System.out.println("물이 부족합니다. 현재 물 잔량: " + currentWaterLevel + "L");
            return;
        }
        currentWaterLevel -= amount;
        System.out.println(amount + "L의 물을 분사했습니다.");
        System.out.println("남은 물: " + currentWaterLevel + "L");
    }

    public void refillWater(double amount) throws ZeroException {
        if (amount <= 0) {
            throw new ZeroException("물 보충량은 0보다 커야 합니다.");
        }
        if (currentWaterLevel + amount > waterTankCapacity) {
            currentWaterLevel = waterTankCapacity;
            System.out.println("물탱크가 가득 찼습니다.");
        } else {
            currentWaterLevel += amount;
            System.out.println(amount + "L의 물을 보충했습니다.");
        }
        System.out.println("현재 물 잔량: " + currentWaterLevel + "L");
    }

    public void toggleSiren() {
        isSirenOn = !isSirenOn;
        System.out.println("사이렌이 " + (isSirenOn ? "켜졌습니다." : "꺼졌습니다."));
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        baseInfo = baseInfo.substring(0, baseInfo.lastIndexOf('\n'));

        // 물 탱크 정보와 사이렌 상태 추가
        return String.format("%s\n│ 물탱크: %6.1fL / %-6.1fL (%3.1f%%) │ 사이렌: %-3s    \n└─────────────────────────────────────────────────────┘",
                baseInfo,
                currentWaterLevel, waterTankCapacity, (currentWaterLevel / waterTankCapacity) * 100,
                isSirenOn ? "ON" : "OFF");
    }
}