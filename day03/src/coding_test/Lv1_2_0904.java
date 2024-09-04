package coding_test;

public class Lv1_2_0904 {
    public static void main(String[] args) {
        Lv1_2_0904 sol = new Lv1_2_0904();
        int[] arr = {-3, -2, -1, 0, 1, 2, 3};
        int result = sol.solution(arr);
        System.out.println(result);
    }
    public int solution(int[] number) {
        int cnt = 0, result = 0;
        for (int i = 2; i < number.length; i++) {
            for (int j = i; j < number.length; j++) {
                for (int k = j; k < number.length; k++) {
                    result = number[i-2] + number[j-1] + number[k];
                    if (result == 0) cnt++;
                }
            }
        }
        return cnt;
    }
}