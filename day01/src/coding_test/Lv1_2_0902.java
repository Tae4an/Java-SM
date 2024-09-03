package coding_test;


import java.util.Scanner;

public class Lv1_2_0902 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lv1_2_0902 sol = new Lv1_2_0902();
        int n = scanner.nextInt();
        int result = sol.solution(n);
        System.out.println(result);
    }
    public int solution(int n) {
        int answer = 0;
        for (int i = n; i > 0; i--) {
            if (n %  i == 0){
                answer += i;
            }
        }
        return answer;
    }
}
