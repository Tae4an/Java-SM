package workshop;

import workshop.exception.FuelException;
import workshop.exception.ZeroException;

import java.util.Random;

public abstract class Car {
    private static int carSerial = 0;
    private String name;
    private String color;
    private double fuelSize;
    private double currFuel;
    private int transmissionType;
    private Engine engine;
    private String carType;



    private static final String[][] carModels = {
            {"Tesla Model 3", "Nissan Leaf", "Chevrolet Bolt", "Hyundai Kona Electric", "BMW i3"},  // 전기차
            {"Volkswagen Golf TDI", "BMW 320d", "Mercedes-Benz E350d", "Audi Q7 TDI", "Ford F-250 Super Duty"},  // 경유차
            {"Toyota Camry", "Honda Civic", "Ford Mustang", "Chevrolet Corvette", "Porsche 911"}  // 휘발유차
    };
    private static final String[] colors = {"빨강", "파랑", "검정", "흰색", "은색"};
    private static final String[] transmissionTypes = {"수동", "자동"};

    public Car() {
        Random random = new Random();
        carSerial++;
        this.currFuel = 10.0;
        this.fuelSize = 80.0;
    }

    public Car(String name, String color, int transmissionType, String carType) {
        this();
        this.name = name;
        this.color = color;
        this.transmissionType = transmissionType;
        this.carType = carType;
    }

    public abstract void drive(double distance, double speed) throws FuelException, ZeroException;

    public void brake(){
        System.out.println(getName()+" Brake::::");
    };

    public abstract void addFuel(double size) throws FuelException, ZeroException ;

    public double getCurrFuel() {
        return currFuel;
    }

    public double getFuelSize() {
        return fuelSize;
    }

    public static String[][] getCarModels() {
        return carModels;
    }

    public static String[] getColors() {
        return colors;
    }

    public static String[] getTransmissionTypes() {
        return transmissionTypes;
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


    public static int getCarSerial() {
        return carSerial;
    }

    public String getColor() {
        return color;
    }

    public int getTransmissionType() {
        return transmissionType;
    }

    public String getCarType() {
        return carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", fuelSize=" + fuelSize +
                ", currFuel=" + currFuel +
                ", transmissionType=" + transmissionType +
                ", engine=" + engine +
                ", carType='" + carType + '\'' +
                '}';
    }
}