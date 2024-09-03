package array;

import java.util.Arrays;
import java.util.Random;

public class Array1 {
    public static void main(String[] args) {
        int[] a = new int[3];
        Random random = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100)+1;
        }
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        for (int n :
                a) {
            System.out.println(n);
        }
    }
}
