package ex;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println("Start...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End...");
    }
}
