package control;

public class Control2 {
    public static void main(String[] args) {
        // 1 ~ 10 까지의 합과 평균을 구하시오

        int sum = 0;
        double avg = 0.0;
        int cnt = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
            cnt++;
        }
        avg = sum / (cnt * 1.0);
        System.out.printf("sum = %d, avg = %5.2f",sum,avg);
    }
}
