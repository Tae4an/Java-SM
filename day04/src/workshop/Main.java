package workshop;

import workshop.exception.FuelException;
import workshop.exception.ZeroException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] carModels = {
                {"Tesla Model 3", "Nissan Leaf", "Chevrolet Bolt"},  // 전기차
                {"대형 소방차", "중형 소방차", "소형 소방차"},  // 소방차
                {"Ferrari", "Lamborghini", "Porsche"},  // 스포츠카
                {"K2 전차", "M1 Abrams", "Leopard 2"}  // 탱크
        };
        String[] colors = {"빨강", "파랑", "검정", "흰색", "은색"};
        String[] transmissionTypes = {"수동", "자동"};

        Car[] myCars = new Car[5];
        int carCnt = 0;

        Driver driver = new Driver("홍길동", 43, 1);
        System.out.println(driver);
        int menu = 0;

        while (true) {
            try {
                System.out.println("[1. 차량 구매]  [2. 내 차량 정보]  [3. 내 정보]  [4. 운전]  [5. 주유/충전하기]  [6. 나가기]");
                System.out.print("메뉴 번호를 입력해주세요: ");
                menu = scanner.nextInt();
                scanner.nextLine();

                if (menu == 6) {
                    System.out.println("종료합니다..");
                    break;
                } else if (menu < 1 || menu > 6) {
                    System.out.println("메뉴에 없는 번호입니다..! 다시 입력해주세요(1~6)");
                    continue;
                }

            } catch (Exception e) {
                System.out.println("메뉴 번호를 입력해주세요..!(정수)");
                scanner.nextLine();
                continue;
            }

            switch (menu) {
                case 1 -> {
                    if (carCnt >= 5) {
                        System.out.println("더 이상 차량을 구매할 수 없습니다. 최대 5대까지만 소유 가능합니다.");
                        continue;
                    }

                    System.out.println("\n차량 유형을 선택하세요:");
                    System.out.println("1. 전기차  2. 소방차  3. 스포츠카  4. 탱크");
                    int carType = scanner.nextInt();
                    scanner.nextLine();

                    if (carType < 1 || carType > 4) {
                        System.out.println("잘못된 차량 유형입니다.");
                        continue;
                    }

                    System.out.println("\n차량 모델을 선택하세요:");
                    for (int i = 0; i < carModels[carType - 1].length; i++) {
                        System.out.println((i + 1) + ". " + carModels[carType - 1][i]);
                    }
                    int modelChoice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\n차량 색상을 선택하세요:");
                    for (int i = 0; i < colors.length; i++) {
                        System.out.println((i + 1) + ". " + colors[i]);
                    }
                    int colorChoice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\n변속기 종류를 선택하세요:");
                    for (int i = 0; i < transmissionTypes.length; i++) {
                        System.out.println((i + 1) + ". " + transmissionTypes[i]);
                    }
                    int transmissionChoice = scanner.nextInt();
                    scanner.nextLine();

                    String selectedModel = carModels[carType - 1][modelChoice - 1];
                    String selectedColor = colors[colorChoice - 1];
                    int selectedTransmission = transmissionChoice;

                    Car newCar;
                    switch (carType) {
                        case 1 -> newCar = new ElectricCar(selectedModel, selectedColor, selectedTransmission, 75.0);
                        case 2 -> newCar = new FireTruck(selectedModel, selectedColor, selectedTransmission, 100.0);
                        case 3 -> newCar = new SportsCar(selectedModel, selectedColor, selectedTransmission, 80.0, 300);
                        case 4 -> newCar = new Tank(selectedModel, selectedColor, selectedTransmission, 1500.0, 700, "120mm 주포");
                        default -> throw new IllegalStateException("Unexpected value: " + carType);
                    }

                    myCars[carCnt] = newCar;
                    carCnt++;

                    System.out.println("차량이 성공적으로 구매되었습니다!");
                }

                case 2 -> {
                    if (carCnt == 0) {
                        System.out.println("소유한 차량이 없습니다.");
                    } else {
                        System.out.println("\n내 차량 목록:");
                        for (int i = 0; i < carCnt; i++) {
                            System.out.println((i + 1) + ". " + myCars[i].toString());
                        }
                    }
                }

                case 3 -> System.out.println(driver);

                case 4 -> {
                    if (carCnt == 0) {
                        System.out.println("소유한 차량이 없습니다.");
                        continue;
                    }

                    System.out.println("\n운전할 차량을 선택하세요:");
                    for (int i = 0; i < carCnt; i++) {
                        System.out.println((i + 1) + ". " + myCars[i].getName());
                    }
                    int carChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (carChoice < 1 || carChoice > carCnt) {
                        System.out.println("잘못된 선택입니다.");
                        continue;
                    }

                    Car selectedCar = myCars[carChoice - 1];
                    System.out.print("운전할 거리를 입력하세요 (km): ");
                    double distance = scanner.nextDouble();
                    System.out.print("속도를 입력하세요 (km/h): ");
                    double speed = scanner.nextDouble();
                    scanner.nextLine();

                    try {
                        selectedCar.drive(distance, speed);
                    } catch (FuelException | ZeroException e) {
                        System.out.println("오류: " + e.getMessage());
                    }

                    // 차량 특별 기능 사용
                    if (selectedCar instanceof ElectricCar) {
                        System.out.print("급속 충전 시간을 입력하세요 (분): ");
                        double chargeTime = scanner.nextDouble();
                        scanner.nextLine();
                        try {
                            ((ElectricCar) selectedCar).fastCharge(chargeTime);
                        } catch (FuelException | ZeroException e) {
                            System.out.println("오류: " + e.getMessage());
                        }
                    } else if (selectedCar instanceof FireTruck) {
                        System.out.print("물을 분사할 양을 입력하세요 (L): ");
                        double waterAmount = scanner.nextDouble();
                        scanner.nextLine();
                        try {
                            ((FireTruck) selectedCar).sprayWater(waterAmount);
                        } catch (ZeroException e) {
                            System.out.println("오류: " + e.getMessage());
                        }
                    } else if (selectedCar instanceof SportsCar) {
                        ((SportsCar) selectedCar).toggleTurboMode();
                    } else if (selectedCar instanceof Tank) {
                        ((Tank) selectedCar).fire();
                    }
                }

                case 5 -> {
                    if (carCnt == 0) {
                        System.out.println("소유한 차량이 없습니다.");
                        continue;
                    }

                    System.out.println("\n주유/충전할 차량을 선택하세요:");
                    for (int i = 0; i < carCnt; i++) {
                        System.out.println((i + 1) + ". " + myCars[i].getName());
                    }
                    int carChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (carChoice < 1 || carChoice > carCnt) {
                        System.out.println("잘못된 선택입니다.");
                        continue;
                    }

                    Car selectedCar = myCars[carChoice - 1];
                    System.out.print("주유/충전할 양을 입력하세요: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    try {
                        selectedCar.addFuel(amount);
                        System.out.println("주유/충전이 완료되었습니다.");
                    } catch (FuelException | ZeroException e) {
                        System.out.println("오류: " + e.getMessage());
                    }
                }
            }
        }
        scanner.close();
    }
}