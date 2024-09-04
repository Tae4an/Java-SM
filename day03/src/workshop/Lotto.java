package workshop;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
    private Random random = new Random();

    private final int price;
    private final int[] lotto = new int[5];
    private final int[] userNum = new int[5];

    private int lottoNumCollect = 0;

    public Lotto() {
        this.price = random.nextInt(1000000000, 2100000000);
        createLottoNum();
    }

    public void getPrice() {
        System.out.println("-----------------------------------");
        System.out.printf("1등 당첨금 : %10.0f원\n", price * 0.7);
        System.out.printf("2등 당첨금 : %10.0f원\n", price * 0.2);
        System.out.printf("3등 당첨금 : %10.0f원\n", price * 0.1);
        System.out.println("-----------------------------------");
    }

    private void createLottoNum() {
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = random.nextInt(5, 40) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[j] == lotto[i]) {
                    i--;
                    break;
                }
            }
        }
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int n : userNum) {
            if (n != 0) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    public void getUserNum() {
        if (isEmpty()) {
            System.out.print("입력된 번호가 없습니다..! 로또 번호를 입력해주세요.\n");
        } else {
            System.out.println("-----------------------------------");
            for (int n : userNum) {
                System.out.printf("%d ", n);
            }
            System.out.println("\n-----------------------------------");
        }
    }

    public void setUserNum(int[] num) {
        System.arraycopy(num, 0, userNum, 0, 5);
        for (int i = 0; i < lotto.length; i++) {
            if (lotto[i] == userNum[i]) lottoNumCollect++;
        }
    }

    public void lottoPricePayment() {
        if (isEmpty()) {
            System.out.print("입력된 번호가 없습니다..! 로또 번호를 입력해주세요.\n");
        } else {
            switch (lottoNumCollect) {
                case 3 -> {
                    System.out.println("축하합니다! 3등 입니다!");
                    System.out.printf("당첨금은 %10.0f원입니다. \n", price * 0.1);
                }
                case 4 -> {
                    System.out.println("축하합니다! 2등 입니다!");
                    System.out.printf("당첨금은 %10.0f원입니다. \n", price * 0.2);
                }
                case 5 -> {
                    System.out.println("축하합니다! 1등 입니다!");
                    System.out.printf("당첨금은 %10.0f원입니다. \n", price * 0.7);
                }
                default -> System.out.print("\n낙첨입니다. 다음 기회에..\n\n");
            }
        }
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "price=" + price + "원" +
                ", lotto=" + Arrays.toString(lotto) +
                ", userNum=" + Arrays.toString(userNum) +
                ", lottoNumCollect=" + lottoNumCollect +
                '}';
    }
}