package coding_test;

public class Lv1_3_0905 {
    public static void main(String[] args) {
        Lv1_3_0905 sol = new Lv1_3_0905();
        String s = "abcde";

        String result = sol.solution(s);
        System.out.println(result);
    }
    public String solution(String s) {
        int halfLength = s.length()/2;
        if(s.length() % 2 == 0){
            return s.substring(halfLength -1, halfLength +1);
        }else return s.substring(halfLength, halfLength +1);
    }
}
