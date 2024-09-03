package array;

public class Array2 {
    public static void main(String[] args) {
        String[] s = new String[3];
        s[0] = "A";
        s[1] = "B";
        s[2] = "A";
        System.out.println(s);
        StringBuffer sb = new StringBuffer();
        for (String str:
             s ) {
            System.out.println(str);
        }
    }
}
