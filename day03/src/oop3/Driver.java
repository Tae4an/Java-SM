package oop3;

public class Driver {
    private String name;
    private int age;
    private int license;

    public Driver() {
    }

    public Driver(String name, int age, int license) {
        this.name = name;
        this.age = age;
        this.license = license;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }



    public int getLicense() {
        return license;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", license=" + license +
                '}';
    }
}
