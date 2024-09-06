package statics;

public class Main  {
    public static void main(String[] args) {
        Car car = new Car("taesan", "red");
        System.out.println(car);

        Car car2 = new Car("taesan", "red");
        System.out.println(car2);
        Car car3 = new Car("taesan", "red");
        System.out.println(car3);

        System.out.println(Math.PI);

    }
}
