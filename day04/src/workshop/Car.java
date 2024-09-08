package workshop;

import workshop.exception.FuelException;
import workshop.exception.ZeroException;

public abstract class Car {
    private static int carSerial = 0;
    private String name;
    private String color;
    private double fuelSize;
    private double currFuel;
    private int transmissionType;
    private Engine engine;
    private String carType;

    public Car(String name, String color, int transmissionType, String carType, double fuelSize) {
        carSerial++;
        this.name = name;
        this.color = color;
        this.transmissionType = transmissionType;
        this.carType = carType;
        this.fuelSize = fuelSize;
        this.currFuel = fuelSize / 2; // 초기 연료량을 연료 탱크의 절반으로 설정
    }

    public abstract void drive(double distance, double speed) throws FuelException, ZeroException;

    public void brake() {
        System.out.println(getName() + " Brake::::");
    }

    public abstract void addFuel(double size) throws FuelException, ZeroException;

    public double getCurrFuel() {
        return currFuel;
    }

    public double getFuelSize() {
        return fuelSize;
    }

    protected void setCurrFuel(double fuel) {
        this.currFuel = fuel;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        String transmissionString = (transmissionType == 1) ? "자동" : "수동";
        String fuelPercentage = String.format("%.1f", (currFuel / fuelSize) * 100);

        return String.format(
                "\n┌─────────────────────────────────────────────────────┐\n" +
                        "│ %-20s                               \n" +
                        "├─────────────────────────────────────────────────────┤\n" +
                        "│ 유형: %-10s │ 색상: %-8s │ 변속기: %-4s \n" +
                        "│ 연료: %5.1fL / %-5.1fL (%s%%)                     \n" +
                        "│ 엔진: %-49s \n" +
                        "└─────────────────────────────────────────────────────┘",
                name,
                carType, color, transmissionString,
                currFuel, fuelSize, fuelPercentage,
                (engine != null) ? engine.toString() : "정보 없음"
        );
    }
}