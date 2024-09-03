package coding_test;

import java.util.Arrays;
import java.util.Scanner;

public class Lv1_1_0903 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Lv1_1_0903 sol = new Lv1_1_0903();
        int result = sol.solution(n);
        System.out.println(result);
    }
    public int solution(int n) {
        for (int i = 1; i < n; i++) {
            if(n % i == 1){
                return i;
            }
        }
        return 0;
    }
}
