package array;

public class Array4 {
    public static void main(String[] args) {
        int[] a = new int[5];
        int[] b = {1,2,3,4,5};
        int[] c = new int[]{1,2,3,4,5};

        int[][] d = new int[2][];
        d[0] = new int[10];
        d[1] = new int[5];

        System.out.println(d.length);
        System.out.println(d[0].length);
        System.out.println(d[1].length);


        int[][] e = {{1,2,3},{4,5,6}};
        int[][] f = new int[][]{{1,2,3},{4,5,6}};
        // Bad Case
        // int[][] g;
        // g = {{1,2,3},{4,5,6}};
    }
}
