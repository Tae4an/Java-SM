package oop1;

public class Main {  // Main 클래스: 프로그램의 진입점
    public static void main(String[] args) {  // main 메서드: 프로그램이 시작되는 지점
        Car car = new Car();  // 기본 생성자를 호출하여 Car 객체 생성
        System.out.println(car);  // 생성된 car 객체의 정보를 출력

        car.go();  // car 객체의 go 메서드를 호출
        car.brake();  // car 객체의 brake 메서드를 호출

        System.out.println();

        Car myCar = new Car(1234,"포르쉐","black");  // 매개변수가 있는 생성자를 호출하여 Car 객체 생성
        System.out.println(myCar);  // 생성된 myCar 객체의 정보를 출력

        myCar.go();  // myCar 객체의 go 메서드를 호출
        myCar.brake();  // myCar 객체의 brake 메서드를 호출
    }
}
