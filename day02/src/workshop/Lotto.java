package workshop;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        // 1. 팀별 게임 룰을 정한다.
        /**
         1. 사용자는 직접 로또 번호를 입력 가능하다.
         2. 로또 당첨 번호는 5 ~ 40 까지의 (중복x) 랜덤 값
         3. 첫 번쨰 부터 숫자 부터 3개 번호 일치 시 3등, 4개 번호 일치 시 2등, 5개 번호 일치 시 1등 (당첨 번호와 라인이 일치해야함)
         4. 1등 상금은 총 금액의 70%, 2등 상금은 총 금액의 20%, 3등 상금은 총 금액의 10%
         **/

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 2. 게임을 시작 하면 랜덤하게 상금이 만들어 진다.
        double price = random.nextInt(1000000000, 2100000000);
        System.out.println("----------------------");
        System.out.printf("로또 총 상금: %10.0f원\n", price);
        System.out.printf("로또 1등 상금: %10.0f원\n", price * 0.7);
        System.out.printf("로또 2등 상금: %10.0f원\n", price * 0.2);
        System.out.printf("로또 3등 상금: %10.0f원\n", price * 0.1);
        System.out.println("----------------------");

        // 3. 게임을 시작 하면 랜덤하게 당첨번호가 만들어 진다.
        int[] lotto = new int[5];

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = random.nextInt(5, 40) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[j] == lotto[i]) {
                    i--;
                    break;
                }
            }
        }

//        System.out.print("당첨 번호: ");
//        for (int n :
//                lotto) {
//            System.out.print(n + " ");
//        }
//        System.out.println();


        // 4. 사용자가 번호를 입력 하고 당첨 여부를 확인 한다.
        int[] userNum = new int[5];

        System.out.println();
        for (int i = 0; i < userNum.length; i++) {
            try {
                System.out.printf("%d번째 숫자를 입력해주세요: ", i + 1);
                userNum[i] = scanner.nextInt();
                if (userNum[i] < 5 || userNum[i] > 40) {
                    System.out.println("범위 내 숫자를 입력해주세요..!(5~40)");
                    i--;
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Try again..!");
                scanner.nextLine();
                i--;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (userNum[j] == userNum[i]) {
                    System.out.println("중복된 숫자는 입력할 수 없습니다..!");
                    i--;
                    break;
                }
            }
        }

        System.out.println();
        int cnt = 0;
        for (int i = 0; i < lotto.length; i++) {
            if (lotto[i] == userNum[i]) cnt++;
        }

        // 5. 등수에 따라 당첨금을 부여 한다.
        switch (cnt) {
            case 3:
                System.out.println("축하합니다! 3등 입니다!");
                System.out.printf("당첨금은 %10.0f원입니다. \n", price * 0.1);
                break;
            case 4:
                System.out.println("축하합니다! 2등 입니다!");
                System.out.printf("당첨금은 %10.0f원입니다. \n", price * 0.2);
                break;
            case 5:
                System.out.println("축하합니다! 1등 입니다!");
                System.out.printf("당첨금은 %10.0f원입니다. \n", price * 0.7);
                break;
            default:
                System.out.println("낙첨입니다. 다음 기회에..");
        }
        scanner.close();
    }
}

