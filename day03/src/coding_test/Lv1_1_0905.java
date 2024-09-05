package coding_test;

public class Lv1_1_0905 {
    public static void main(String[] args) {
        Lv1_1_0905 sol = new Lv1_1_0905();

        long result = sol.solution(3,20,4);
        System.out.println(result);
    }
    public long solution(int price, int money, int count) {
        long answer = 0;

        for (int i = 1; i <= count; i++) {
            answer += price * i;
        }
        return answer>money ? answer-money : 0;
    }
}
