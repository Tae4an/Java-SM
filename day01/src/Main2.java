public class Main2 {
    public static void main(String[] args) {
        float f1 = 10.2f;
        float f2 = 10.2f;
        float f3 = f1 + f2;

        System.out.println(f3);

        double d1  =10.2;
        int a = 10;
        int b = 3;
//        Bad Case
//        double result = a/b;

        double result = a*1.0/b;
        System.out.println(result);
        /*
          3.3333333333333335와 같이 끝에 5가 붙는 이유는 부동소수점 연산의 근사 오차 때문이다.
          컴퓨터는 실수를 2진법으로 표현하는 과정에서 정확히 표현하지 못하고, 근사값으로 처리하기 때문에 이런 작은 오차가 발생.
         */

    }

}
