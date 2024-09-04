package coding_test;

import java.util.Arrays;

public class Lv1_3_0904 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Lv1_3_0904 sol = new Lv1_3_0904();
        int[] result = sol.solution(arr, commands);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] temp = new int[commands.length];
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];

            int length = j - i + 1;

            int[] subArray = new int[length];

            for (int m = 0; m < length; m++) {
                subArray[m] = array[i - 1 + m];
            }

            for (int l = 0; l < subArray.length; l++) {
                for (int m = l+1; m < subArray.length; m++) {
                    if (subArray[l] > subArray[m]){
                        int tmp = subArray[m];
                        subArray[m] = subArray[l];
                        subArray[l] = tmp;
                    }
                }
            }
            temp[n] = subArray[k - 1];
        }
        return temp;
    }
}
