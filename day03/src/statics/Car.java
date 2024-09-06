package statics;

public class Car {
    private int serial;
    private String name;
    private String color;
    public static String vendor = "KK";
    public static int count = 0;

    static {
        System.out.println("static block");
        System.out.println("Loading Car Class");
    }
    public Car(){
        
    }

    public Car(String name, String color) {
        this.serial = ++count;
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
