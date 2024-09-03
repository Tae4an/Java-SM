package op;

public class Op2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int result = ++a + b++;
        System.out.printf("%d, %d, %d",a,b,result);
    }
}
