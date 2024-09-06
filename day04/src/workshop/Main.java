package workshop;

public class Main {
    public static void main(String[] args) {
        Car [] cars = new Car[5];
        cars[0] = new ElectricCar("테슬라","red",2,new ElectricMotor(10,90,10000,500));

        System.out.println(cars[0]);
    }
}
