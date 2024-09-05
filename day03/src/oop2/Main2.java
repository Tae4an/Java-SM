package oop2;

public class Main2 {
    public static void main(String[] args) {
        Car car = new Car("k1", "red",50,10);
        System.out.println(car);

        Engine engine = new Engine(100, 3000,"s1");
        car.setEngine(engine);
        System.out.println(car.getEngine());

        System.out.println(car);
    }
}
