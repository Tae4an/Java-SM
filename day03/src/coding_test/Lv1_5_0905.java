package coding_test;

import java.util.Arrays;

public class Lv1_5_0905 {
    public static void main(String[] args) {
        Lv1_5_0905 sol = new Lv1_5_0905();

        int[] num = {5,0,2,7};
        int[] result = sol.solution(num);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] numbers) {
        int[] temp = new int[5000];
        int cnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length ; j++) {
                temp[cnt++] = numbers[i] + numbers[j];
            }
        }
        temp = Arrays.copyOf(temp,cnt);
        temp = Arrays.stream(temp).distinct().toArray();

        Arrays.sort(temp);

        return temp;
    }
}
