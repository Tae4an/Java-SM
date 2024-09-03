package coding_test;

import java.util.Arrays;
import java.util.Scanner;

public class Lv1_1_0902 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        Lv1_1_0902 sol = new Lv1_1_0902();
        long[] result = sol.solution(x,n);
        System.out.println(Arrays.toString(result));
    }
    public  long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 1; i <= n; i++) {
            answer[i-1] = (long) x * i;
        }
        return answer;
    }
}
