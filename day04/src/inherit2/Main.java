package inherit2;

public class Main {
    public static void main(String[] args) {
        /*
        추상 클래스는 인스턴스화 할 수 없음
        Shape shape = new Shape():

         */

        Shape[] shape = new Shape[3];
        shape[0] = new Circle(10,10,54);
        shape[1] = new Rectangle(20,20,100,200);
        shape[2] = new Triangle(30,30,300,400);


        for(Shape s: shape){
            System.out.println(s);
            System.out.println(s.getArea());
            System.out.println(s.getCircum());
        }

    }
}
