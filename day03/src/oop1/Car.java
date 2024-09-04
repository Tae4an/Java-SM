package oop1;

public class Car {  // Car 클래스: 자동차 객체를 나타내는 클래스
    private int serial;  // 자동차의 시리얼 넘버를 저장하는 필드
    private String name;  // 자동차의 이름을 저장하는 필드
    private String color;  // 자동차의 색상을 저장하는 필드

    public Car() {  // 기본 생성자: 시리얼 넘버를 0으로 초기화하여 Car 객체를 생성
        this.serial = 0;
    }

    public Car(String name, String color) {  // 매개변수로 이름과 색상을 받는 생성자
        this(); // 기본 생성자를 호출하여 시리얼 넘버를 0으로 초기화
        this.name = name;  // 매개변수로 받은 name을 객체의 name 필드에 할당
        this.color = color;  // 매개변수로 받은 color를 객체의 color 필드에 할당
    }

    public Car(int serial, String name, String color) {  // 시리얼 넘버, 이름, 색상을 받는 생성자
        this.serial = serial;  // 매개변수로 받은 serial을 객체의 serial 필드에 할당
        this.name = name;  // 매개변수로 받은 name을 객체의 name 필드에 할당
        this.color = color;  // 매개변수로 받은 color를 객체의 color 필드에 할당
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void go() {  // 자동차가 출발할 때 호출되는 메서드
        System.out.println(this.name);
        System.out.println("Car Go");
    }

    public void brake() {  // 자동차가 멈출 때 호출되는 메서드
        System.out.println("Car Stop");
    }

    @Override
    public String toString() {  // toString 메서드: 자동차 객체의 정보를 문자열로 반환
        return "Car{" +
                "serial=" + serial +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}