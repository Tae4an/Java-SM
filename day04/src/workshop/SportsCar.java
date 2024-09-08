package workshop;

import workshop.exception.FuelException;
import workshop.exception.ZeroException;

public class SportsCar extends Car {
    private boolean turboMode;
    private int maxSpeed;

    public SportsCar(String name, String color, int transmissionType, double fuelSize, int maxSpeed) {
        super(name, color, transmissionType, "스포츠카", fuelSize);
        this.turboMode = false;
        this.maxSpeed = maxSpeed;
        setEngine(new Engine(3.0, 400) {
            @Override
            public void start() {
                System.out.println("스포츠카 엔진이 고동을 시작합니다!");
            }

            @Override
            public void stop() {
                System.out.println("스포츠카 엔진이 조용해집니다.");
            }

            @Override
            public double calculateFuelConsumption(double distance, double speed) {
                // 스포츠카의 연료 소비량 계산 (기본 소비량 + 속도에 따른 추가 소비)
                double baseFuelConsumption = (distance / 100) * 15; // 기본 100km당 15L 소비
                double speedFactor = speed / 100; // 속도가 높을수록 연료 소비 증가
                return baseFuelConsumption * (1 + speedFactor) * (turboMode ? 1.2 : 1);
            }
        });
    }

    @Override
    public void drive(double distance, double speed) throws FuelException, ZeroException {
        if (speed <= 0) {
            throw new ZeroException("속도는 0보다 커야 합니다.");
        }
        if (speed > maxSpeed) {
            System.out.println("최대 속도를 초과하여 " + maxSpeed + "km/h로 주행합니다.");
            speed = maxSpeed;
        }

        double fuelNeeded = getEngine().calculateFuelConsumption(distance, speed);
        if (getCurrFuel() < fuelNeeded) {
            throw new FuelException("연료가 부족합니다.");
        }

        addFuel(-fuelNeeded);
        System.out.println(getName() + "가 " + distance + "km를 " + speed + "km/h로 " +
                (turboMode ? "터보 모드로 " : "") + "주행했습니다.");
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
            System.out.println(getName() + "에 " + amount + "L의 고급 연료를 주유했습니다.");
        } else {  // 연료를 소비하는 경우
            if (newFuelLevel < 0) {
                throw new FuelException("사용 가능한 연료보다 더 많은 연료를 소비할 수 없습니다.");
            }
        }

        setCurrFuel(newFuelLevel);
    }

    public void toggleTurboMode() {
        turboMode = !turboMode;
        System.out.println("터보 모드를 " + (turboMode ? "켰습니다." : "껐습니다."));
    }

    @Override
    public void brake() {
        super.brake();
        System.out.println("스포츠카의 고성능 브레이크가 작동합니다!");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        baseInfo = baseInfo.substring(0, baseInfo.lastIndexOf('\n'));

        return String.format("%s\n│ 터보 모드: %-5s │ 최대 속도: %3d km/h           \n└─────────────────────────────────────────────────────┘",
                baseInfo,
                turboMode ? "ON" : "OFF", maxSpeed);
    }
}