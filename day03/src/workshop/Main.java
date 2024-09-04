package workshop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lotto lotto = new Lotto();
        System.out.println(lotto);
        int menu = 0;

        while (true) {
            try {
                System.out.println("[1. 로또 번호 입력]");
                System.out.println("[2. 로또 당첨금 목록]");
                System.out.println("[3. 내 로또 번호 확인]");
                System.out.println("[4. 로또 당첨번호 확인]");
                System.out.println("[5. 나가기]");
                System.out.print("메뉴 번호를 입력해주세요 :");
                menu = scanner.nextInt();
                if (menu == 5) {
                    System.out.println("종료합니다..");
                    scanner.close();
                    break;
                }
                if (menu <= 0 || menu > 5) {
                    System.out.print("없는 메뉴 번호입니다..!메뉴 번호를 입력해주세요(1~5) :\n\n");
                }
            } catch (Exception e) {
                System.out.println("정수를 입력해주세요..!");
                scanner.nextLine();
                continue;
            }
            switch (menu) {
                case 1 -> {
                    int[] userInputNum = new int[5];
                    for (int i = 0; i < 5; i++) {
                        try {
                            System.out.printf("%d번째 숫자를 입력해주세요(5~40): ", i + 1);
                            int num = scanner.nextInt();
                            if (num < 5 || num > 40) {
                                System.out.println("범위 내 숫자를 입력해주세요..!(5~40)");
                                i--;
                                continue;
                            }
                            boolean isDuplicate = false;
                            for (int j = 0; j < i; j++) {
                                if (userInputNum[j] == num) {
                                    System.out.println("중복된 숫자는 입력할 수 없습니다..!");
                                    isDuplicate = true;
                                    break;
                                }
                            }
                            if (isDuplicate){
                                i--;
                                continue;
                            }

                            userInputNum[i] = num;
                        } catch (Exception e) {
                            System.out.println("Try again..!");
                            scanner.nextLine();
                            i--;
                        }

                    }
                    lotto.setUserNum(userInputNum);
                    System.out.println("로또 번호가 입력되었습니다.");
                }
                case 2 -> lotto.getPrice();
                case 3 -> lotto.getUserNum();
                case 4 -> lotto.lottoPricePayment();
            }
        }
    }
}