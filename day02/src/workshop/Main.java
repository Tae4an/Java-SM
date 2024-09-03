package workshop;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[5];
        int max = 0, min = 11;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10)+1;
            for (int j = 0; j < i; j++) {
                if(arr[j] == arr[i]){
                    i--;
                    break;
                }
            }
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }

        for (int n:
             arr) {
            System.out.printf("[%d]",n);
        }
        System.out.printf("\nmax = %d, min = %d",max,min);
    }
}
