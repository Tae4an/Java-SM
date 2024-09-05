package oop3;

import java.util.Random;

public class Car {
    private int serial;
    private String name;
    private String color;
    private double fuelSize;
    private double currFuel;
    private Engine engine;
    private double handle;
    private boolean headLight;
    private int transmissionType;
    private boolean driverBoarding;

    private static final String[] CAR_MODELS = {"포르쉐", "BMW", "KIA", "현대", "벤츠", "VOLVO", "HONDA", "LAND ROVER", "부가티", "람보르기니", "JEEP", "쌍용"};
    private static final String[] COLORS = {"빨강", "파랑", "검정", "흰색", "은색"};
    private static final String[] TRANSMISSION_TYPES = {"수동", "자동"};



    public Car() {
        Random random = new Random();
        this.serial = random.nextInt(10000) + 1;
        this.handle = 0.0;
        this.headLight = false;
        this.currFuel = 10.0;
        this.fuelSize = 80.0;
        this.driverBoarding = false;
        this.engine = new Engine();
    }


    public Car(String name, String color, int  transmissionType) {
        this();
        this.name = name;
        this.color = color;
        this.transmissionType = transmissionType;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // 액셀 메서드
    public void acceleration(int distance){
        System.out.printf("%s가 %d만큼 달렸습니다.\n", this.name, distance);
        this.currFuel -= distance/100.0;
    }
    public void brake(){
        System.out.printf("Brake:::: %s \n",this.toString());
    }

    public void addFuel(double size) throws Exception {
        if(this.fuelSize < (this.currFuel + size)){
            throw new Exception("주유 가능량을 초과했습니다..!");
        }
        this.currFuel += size;
    }


    public double getCurrFuel() {
        return currFuel;
    }

    public boolean isHeadLight() {
        return headLight;
    }

    public void setHeadLight(boolean headLight) {
        this.headLight = headLight;
    }

    public void handlling(double handle) {
        this.handle = handle;
    }

    public boolean isDriverBoarding() {
        return driverBoarding;
    }

    public void setDriverBoarding(boolean driverBoarding) {
        this.driverBoarding = driverBoarding;
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



    /*
    public void go(int distance){

    }


    public void addFuel(double size) throws Exception {
        if(this.fuelSize < (this.currFuel + size)){
            throw new Exception("EC0001");
        }
        this.currFuel += size;
    }

     */

}

