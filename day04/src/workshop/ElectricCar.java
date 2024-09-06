package workshop;

import workshop.exception.FuelException;
import workshop.exception.ZeroException;

public class ElectricCar extends Car {
    private final ElectricMotor electricEngine;

    public ElectricCar(String name, String color, int transmissionType, ElectricMotor engine) {
        super(name, color, transmissionType,"electric");
        this.electricEngine = engine;
    }

    @Override
    public void drive(double distance, double speed) throws FuelException, ZeroException {
        double energyConsumption = electricEngine.calculateFuelConsumption(distance, speed);
        if (energyConsumption > getCurrFuel()) {
            System.out.println("충전이 필요합니다. 주행 불가능.");
            return;
        }
        System.out.println(getName() + " 전기차가 " + distance + "km를 " + speed + "km/h로 주행합니다.");
        addFuel(-energyConsumption);
    }


    @Override
    public void addFuel(double size) throws FuelException, ZeroException {
        System.out.println(getName() + " 전기차를 충전합니다.");
    }

    @Override
    public String toString() {
        return super.toString() + ", ElectricCar{" +
                "electricEngine=" + electricEngine +
                '}';
    }
}