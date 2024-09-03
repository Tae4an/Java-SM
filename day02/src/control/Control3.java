package control;

public class Control3  {
    public static void main(String[] args) {
        // 1 ~ 10 까지의 합과 평균을 구하시오

        int sum = 0;
        double avg = 0.0;
        int i = 0;
        int cnt = 0;

//        while(i<10){
//            ++i;
//            sum +=i;
//        }
//        avg = sum / (i * 1.0);

        while(i<10){
            ++i;
            if(i % 2 == 0){
                sum +=i;
                cnt++;
            }
        }
        avg = sum / (cnt * 1.0);
        System.out.printf("sum = %d, avg = %5.2f",sum,avg);
    }
}
