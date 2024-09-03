package array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array3 {
    public static void main(String[] args) {
        int a[][] = new int[5][5];
        // 1 ~ 100 까지의 랜덤한 숫자를 각 인덱스에 넣고

        Random random = new Random();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = random.nextInt(100)+1;
            }
        }

        for (int[] n:a){
            for (int num:
                 n) {
                System.out.printf("[%d]",num);
            }
            System.out.println();
        }
        System.out.println("------------------------");
        System.out.println(Arrays.deepToString(a));

    }
}
