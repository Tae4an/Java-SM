package workshop;

import workshop.exception.FuelException;
import workshop.exception.ZeroException;

public class Tank extends Car {
    private int armorThickness;
    private String weaponType;
    private boolean isInCombatMode;

    public Tank(String name, String color, int transmissionType, double fuelSize, int armorThickness, String weaponType) {
        super(name, color, transmissionType, "탱크", fuelSize);
        this.armorThickness = armorThickness;
        this.weaponType = weaponType;
        this.isInCombatMode = false;
        setEngine(new Engine(12.0, 1500) { // 예시: 12.0L, 1500hp 엔진
            @Override
            public void start() {
                System.out.println("탱크 엔진이 굉음과 함께 시동됩니다.");
            }

            @Override
            public void stop() {
                System.out.println("탱크 엔진이 멈춥니다.");
            }

            @Override
            public double calculateFuelConsumption(double distance, double speed) {
                // 탱크의 연료 소비량 계산 (기본 소비량 + 속도와 전투 모드에 따른 추가 소비)
                double baseFuelConsumption = (distance / 100) * 250; // 기본 100km당 250L 소비
                double speedFactor = speed / 50; // 속도가 높을수록 연료 소비 증가
                double combatModeFactor = isInCombatMode ? 1.5 : 1.0; // 전투 모드일 때 연료 소비 50% 증가
                return baseFuelConsumption * speedFactor * combatModeFactor;
            }
        });
    }

    @Override
    public void drive(double distance, double speed) throws FuelException, ZeroException {
        if (speed <= 0) {
            throw new ZeroException("속도는 0보다 커야 합니다.");
        }
        if (speed > 70) {
            System.out.println("경고: 최대 속도 70km/h를 초과했습니다. 속도를 70km/h로 제한합니다.");
            speed = 70;
        }

        double fuelNeeded = getEngine().calculateFuelConsumption(distance, speed);
        if (getCurrFuel() < fuelNeeded) {
            throw new FuelException("연료가 부족합니다.");
        }

        addFuel(-fuelNeeded);
        System.out.println(getName() + " 탱크가 " + distance + "km를 " + speed + "km/h로 " +
                (isInCombatMode ? "전투 태세로 " : "") + "이동했습니다.");
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
            System.out.println(getName() + " 탱크에 " + amount + "L의 연료를 주유했습니다.");
        } else {  // 연료를 소비하는 경우
            if (newFuelLevel < 0) {
                throw new FuelException("사용 가능한 연료보다 더 많은 연료를 소비할 수 없습니다.");
            }
        }

        setCurrFuel(newFuelLevel);
        System.out.println("현재 연료량: " + String.format("%.2f", getCurrFuel()) + "L");
    }

    public void toggleCombatMode() {
        isInCombatMode = !isInCombatMode;
        System.out.println(getName() + " 탱크가 " + (isInCombatMode ? "전투 태세로 전환되었습니다." : "이동 태세로 전환되었습니다."));
    }

    public void fire() {
        System.out.println(getName() + " 탱크가 " + weaponType + "(으)로 포격을 실시합니다!");
    }

    public void checkArmor() {
        System.out.println(getName() + " 탱크의 장갑 두께: " + armorThickness + "mm");
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        baseInfo = baseInfo.substring(0, baseInfo.lastIndexOf('\n'));

        return String.format("%s\n│ 장갑: %3d mm │ 무기: %-10s │ 전투모드: %-3s \n└─────────────────────────────────────────────────────┘",
                baseInfo,
                armorThickness, weaponType, isInCombatMode ? "ON" : "OFF");
    }
}