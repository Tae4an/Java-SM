package coding_test;

public class Lv1_2_0905 {
    public static void main(String[] args) {
        Lv1_2_0905 sol = new Lv1_2_0905();
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};

        int result = sol.solution(a,b);
        System.out.println(result);
    }
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }
}
