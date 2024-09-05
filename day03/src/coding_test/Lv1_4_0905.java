package coding_test;

public class Lv1_4_0905 {
    public static void main(String[] args) {
        Lv1_4_0905 sol = new Lv1_4_0905();
        String s = "one4seveneight";

        int result = sol.solution(s);
        System.out.println(result);
    }
    public int solution(String s) {
        String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] num2 = {"0","1","2","3","4","5","6","7","8","9"};
        for (int i = 0; i < num.length; i++) {
            s = s.replace(num[i], num2[i]);
        }
        return Integer.parseInt(s);
    }
}
