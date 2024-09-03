package coding_test;

import java.util.Scanner;

public class Lv1_3_0902 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lv1_3_0902 sol = new Lv1_3_0902();
        long n = scanner.nextLong();
        long result = sol.solution(n);
        System.out.println(result);
    }
    public long solution(long n) {
        long answer = -1;

        for (long i = 1; i <= n; i++) {
            long num = i * i;
            if(num == n){
                ++i;
                answer = i * i;
                return answer;
            }
        }
        return answer;
    }
}
