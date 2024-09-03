package variable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String str = "java";
        int num = 100;
        double num2 = 10.25555;
        System.out.printf("[str = %s] [num = %d] [num2 = %10.3f]", str, num, num2);
        System.out.printf("ok \n");
        System.out.printf("%d \n", num); // %d: 10진수(decimal)로 출력
        System.out.printf("%o \n", num); // %o: 8진수(octal)로 출력
        System.out.printf("%x \n", num); // %x: 16진수(hexadecimal)로 출력


    }
}