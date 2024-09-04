package oop1;

public class Main2 {  // Main2 클래스: 프로그램의 두 번째 진입점
    public static void main(String[] args) {  // main 메서드: 프로그램이 시작되는 지점
        Car car1 = new Car();  // 기본 생성자를 호출하여 Car 객체 생성 (serial = 0, name = null, color = null)
        Car car2 = new Car("k5", "red");  // 이름과 색상을 매개변수로 받아 Car 객체 생성 (serial = 0)
        Car car3 = new Car(1234, "k5", "black");  // 시리얼 넘버, 이름, 색상을 매개변수로 받아 Car 객체 생성

        car2.setColor("blue");

        System.out.println(car2.getColor());

        System.out.println(car1);  // car1 객체의 정보를 출력
        System.out.println(car2);  // car2 객체의 정보를 출력
        System.out.println(car3);  // car3 객체의 정보를 출력
    }
}
