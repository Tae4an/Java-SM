package control;

public class Control1 {
    public static void main(String[] args) {
        int grade = 3;
        switch (grade){
            case 1:
                System.out.println("냉장고");
            case 2:
                System.out.println("세탁기");
            case 3:
                System.out.println("에어컨");
                break;
            default:
                System.out.println("Try Again");
        }
    }
}
