package coding_test;

import java.util.Scanner;

public class Lv1_2_0903 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Lv1_2_0903 sol = new Lv1_2_0903();
        int result = sol.solution(n);
        System.out.println(result);
    }
    public int solution(int n) {
        int answer = 0;
        while(n > 0){
            answer += n%10;
            n /= 10;
        }
        return answer;
    }
}
