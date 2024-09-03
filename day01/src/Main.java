public class Main {
    public static void main(String[] args) {
//        Bad Case
//        int a = 30000000000;
        int a = 300000000;

//        Bad Case
//        byte b1 = 200;

        byte b1 = 100;
        byte b2 = (byte)200;
        System.out.println(b2);

        byte num1 = 100;
        byte num2 = 100;
//        Bad Case
//        byte num3 = num1 + num2;
//        byte num3 = (byte)(num1 + num2);

        int num3 = num1 + num2;
        System.out.println(num3);

//        Bad Case
//        long num4 = 300000000000;
        long num4 = 30000000000L;
        long num5 = 15000000000L + 1500000000L;
        System.out.println(num5);

        int i1 = 1500000000;
        int i2 = 1500000000;
//        Bad Case
//        long result = i1 + 12;
        long result = i1*1L + i2*2L;
        System.out.println(result);

    }
}