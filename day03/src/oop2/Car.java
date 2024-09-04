package oop2;

import java.util.Random;

public class Car {
    private int serial;
    private String name;
    private String color;
    private double fuelSize;
    private double currFuel;

    public Car() {
        Random random = new Random();
        this.serial = random.nextInt(10000) + 1;
    }

    public Car(int serial, String name, String color, double fuelSize, double currFuel) {
        this.serial = serial;
        this.name = name;
        this.color = color;
        this.fuelSize = fuelSize;
        this.currFuel = currFuel;
    }

    public Car(String name, String color, double fuelSize, double currFuel) {
        this();
        this.name = name;
        this.color = color;
        this.fuelSize = fuelSize;
        this.currFuel = currFuel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serial=" + serial +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", fuelSize=" + fuelSize +
                ", currFuel=" + currFuel +
                '}';
    }

    public void go(int distance){
        System.out.printf("%s가 %d만큼 달렸습니다.\n", this.name, distance);
        this.currFuel -= distance/100.0;
    }
    public void brake(){
        System.out.printf("Brake:::: %s \n",this.toString());
    }

    public void addFuel(double size) throws Exception {
        if(this.fuelSize < (this.currFuel + size)){
            throw new Exception("EC0001");
        }
        this.currFuel += size;
    }

}
