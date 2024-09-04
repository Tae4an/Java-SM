package coding_test;

import java.util.Arrays;

public class Lv1_1_0904 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        Lv1_1_0904 sol = new Lv1_1_0904();
        int[] result = sol.solution(arr);
        System.out.println(Arrays.toString(result));


    }
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        int cnt = 0;
        answer[cnt++] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]){
                answer[cnt++] = arr[i];
            }
        }
        answer = Arrays.copyOf(answer,cnt);
        return answer;
    }
}
