package oop3;

import java.util.Random;

public class Car {
    private int serial;
    private String name;
    private String color;
    private double fuelSize;
    private double currFuel;
    private Engine engine;
    private int transmissionType;

    private static final String[] CAR_MODELS = {"포르쉐", "BMW", "KIA", "현대", "벤츠", "VOLVO", "HONDA", "LAND ROVER", "부가티", "람보르기니", "JEEP", "쌍용"};
    private static final String[] COLORS = {"빨강", "파랑", "검정", "흰색", "은색"};
    private static final String[] TRANSMISSION_TYPES = {"수동", "자동"};

    public Car() {
        Random random = new Random();
        this.serial = random.nextInt(10000) + 1;
        this.currFuel = 10.0;
        this.fuelSize = 80.0;
        this.engine = new Engine();
    }

    public Car(String name, String color, int transmissionType) {
        this();
        this.name = name;
        this.color = color;
        this.transmissionType = transmissionType;
    }


    public void startEngine() {
        if (!engine.isEngineOnOffStatus()) {
            System.out.println(this.name + "의 시동을 겁니다.");
            engine.setEngineOnOffStatus(true);
        } else {
            System.out.println(this.name + "의 시동이 이미 걸려있습니다.");
        }
    }

    public void stopEngine() {
        if (engine.isEngineOnOffStatus()) {
            System.out.println(this.name + "의 시동을 끕니다.");
            engine.setEngineOnOffStatus(false);
        } else {
            System.out.println(this.name + "의 시동이 이미 꺼져있습니다.");
        }
    }

    public void drive(double distance, double speed) {
        if (!engine.isEngineOnOffStatus()) {
            System.out.println("먼저 시동을 걸어주세요.");
            return;
        }

        double time = distance / speed;
        double fuelConsumption = distance * 0.1;

        if (this.currFuel < fuelConsumption) {
            double fuelShortage = fuelConsumption - this.currFuel;
            System.out.printf("연료가 %.2fL 부족합니다. 현재 연료: %.2fL, 필요 연료: %.2fL\n",
                    fuelShortage, this.currFuel, fuelConsumption);
            System.out.println("주유 후 다시 시도해주세요.");
        } else {
            System.out.printf("%s가 %.2f km를 %.2f km/h의 속도로 운전합니다.\n", this.name, distance, speed);
            System.out.printf("소요 시간: %.2f 시간\n", time);
            System.out.printf("소비한 연료: %.2f L\n", fuelConsumption);

            try {
                this.addFuel(-fuelConsumption);
                System.out.printf("남은 연료: %.2f L\n", this.currFuel);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void brake() {
        if (!engine.isEngineOnOffStatus()) {
            System.out.println("시동이 꺼져 있어 브레이크를 사용할 수 없습니다.");
        } else {
            System.out.println(this.name + "의 브레이크를 밟았습니다.");
        }
    }

    public void addFuel(double size) throws Exception {
        if (this.fuelSize < (this.currFuel + size)) {
            throw new Exception("주유 가능량을 초과했습니다..!");
        }
        this.currFuel += size;
    }

    public double getCurrFuel() {
        return currFuel;
    }

    public double getFuelSize() {
        return fuelSize;
    }

    public static String[] getCarModels() {
        return CAR_MODELS;
    }

    public static String[] getColors() {
        return COLORS;
    }

    public static String[] getTransmissionTypes() {
        return TRANSMISSION_TYPES;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serial=" + serial +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", fuelSize=" + fuelSize +
                ", currFuel=" + currFuel +
                ", engine=" + engine +
                '}';
    }

    public String getName() {
        return this.name;
    }
}