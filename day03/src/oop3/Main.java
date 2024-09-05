package oop3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carModels = Car.getCarModels();
        String[] colors = Car.getColors();
        String[] transmissionTypes = Car.getTransmissionTypes();

        Car[] myCars = new Car[3];
        int carCnt = 0;

        Driver driver = new Driver("홍길동", 43, 1);
        System.out.println(driver);
        int menu = 0;

        while (true) {
            try {
                System.out.println("[1. 차량 구매]  [2. 내 차량 정보]  [3. 내 정보]  [4. 운전]  [5. 주유하기]  [6. 나가기]");
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
                    if (carCnt >= 3) {
                        System.out.println("더 이상 차량을 구매할 수 없습니다. 최대 3대까지만 소유 가능합니다.");
                        continue;
                    }

                    String selectedCar = null;
                    String selectedColor = null;
                    int transmissionType = 0;

                    while (true) {

                        System.out.println("\n--------------------------------------------------------------------------------------------------------------");
                        for (int i = 0; i < carModels.length; i++) {
                            System.out.print((i + 1) + ". " + carModels[i] + " ");
                        }
                        System.out.println("\n--------------------------------------------------------------------------------------------------------------");

                        System.out.print("구매할 차량 번호를 선택해주세요: ");
                        int carChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (carChoice < 1 || carChoice > carModels.length) {
                            System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
                            continue;
                        }

                        selectedCar = carModels[carChoice - 1];
                        System.out.println("선택한 차: " + selectedCar);

                        // 색상 선택
                        System.out.println("----------------------------------------");
                        for (int i = 0; i < colors.length; i++) {
                            System.out.print((i + 1) + ". " + colors[i] + " ");
                        }
                        System.out.println("\n----------------------------------------");

                        System.out.print("차량 색상 번호를 선택해주세요: ");
                        int colorChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (colorChoice < 1 || colorChoice > colors.length) {
                            System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
                            continue;
                        }

                        selectedColor = colors[colorChoice - 1];
                        System.out.println("선택한 색상: " + selectedColor);

                        // 변속기 종류 선택
                        System.out.println("------------------------------");
                        for (int i = 0; i < transmissionTypes.length; i++) {
                            System.out.print((i + 1) + ". " + transmissionTypes[i] + " ");
                        }
                        System.out.println("\n------------------------------");


                        System.out.print("변속기 종류 번호를 선택해주세요: ");
                        int transmissionChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (transmissionChoice < 1 || transmissionChoice > transmissionTypes.length) {
                            System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
                            continue;
                        }

                        transmissionType = transmissionChoice;
                        System.out.println("선택한 변속기: " + transmissionTypes[transmissionChoice - 1]);

                        Car newCar = new Car(selectedCar, selectedColor, transmissionType);
                        myCars[carCnt] = newCar;
                        carCnt++;

                        System.out.println("[최종 선택: " + selectedCar + " (" + selectedColor + ", " +
                                transmissionTypes[transmissionType - 1] + ")]");
                        System.out.println("[차량이 성공적으로 구매되었습니다!]");
                        break;
                    }
                }
                case 2 -> {
                    while (true) {
                        if (carCnt == 0) {
                            System.out.println("[소유한 차량이 없습니다.]");
                            break;
                        } else {
                            System.out.println("[내 차량 목록:]");
                            System.out.println("--------------------------------");
                            for (int i = 0; i < carCnt; i++) {
                                System.out.print((i + 1) + ". " + myCars[i].getName() + " ");
                            }
                            System.out.println("\n--------------------------------");
                            System.out.println("1. 차량 삭제");
                            System.out.println("2. 메인 메뉴로 돌아가기");
                            System.out.print("메뉴를 선택하세요: ");

                            int choice;
                            try {
                                choice = scanner.nextInt();
                                scanner.nextLine();

                                if (choice == 1) {
                                    System.out.print("삭제할 차량 번호를 입력하세요: ");
                                    int carIndex = scanner.nextInt();
                                    scanner.nextLine();

                                    if (carIndex < 1 || carIndex > carCnt) {
                                        System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
                                    } else {
                                        // 선택한 차량 제거
                                        System.out.println(myCars[carIndex - 1].getName() + " 차량이 제거되었습니다.");
                                        for (int i = carIndex - 1; i < carCnt - 1; i++) {
                                            myCars[i] = myCars[i + 1];
                                        }
                                        myCars[carCnt - 1] = null;
                                        carCnt--;
                                    }
                                } else if (choice == 2) {
                                    break;
                                } else {
                                    System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.");
                                }

                            } catch (Exception e) {
                                System.out.println("올바른 숫자를 입력해주세요.");
                                scanner.nextLine();
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("[내 정보]");
                    System.out.printf(" 이름: %s   나이: %d세   %d종 운전면허 자격증\n\n", driver.getName(), driver.getAge(), driver.getLicense());
                }
                case 4 -> {
                    if (carCnt == 0) {
                        System.out.println("소유한 차량이 없습니다. 먼저 차량을 구매해주세요.");
                        continue;
                    }

                    System.out.println("[내 차량 목록:]");
                    for (int i = 0; i < carCnt; i++) {
                        System.out.println((i + 1) + ". " + myCars[i].getName() + " (현재 연료: " + String.format("%.2f", myCars[i].getCurrFuel()) + "L)");
                    }

                    System.out.print("운전할 차량 번호를 선택하세요: ");
                    int carChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (carChoice < 1 || carChoice > carCnt) {
                        System.out.println("잘못된 번호입니다.");
                        continue;
                    }

                    Car selectedCar = myCars[carChoice - 1];

                    boolean inDrivingMode = true;
                    while (inDrivingMode) {
                        System.out.println("\n[운전 메뉴]");
                        System.out.println("1. 시동 걸기");
                        System.out.println("2. 출발하기");
                        System.out.println("3. 브레이크");
                        System.out.println("4. 시동 끄기");
                        System.out.println("5. 나가기");
                        System.out.print("메뉴를 선택하세요: ");
                        int drivingChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (drivingChoice) {
                            case 1 -> selectedCar.startEngine();
                            case 2 -> {
                                System.out.print("이동할 거리를 입력하세요 (km): ");
                                double distance = scanner.nextDouble();
                                System.out.print("평균 속도를 입력하세요 (km/h): ");
                                double speed = scanner.nextDouble();
                                scanner.nextLine();
                                selectedCar.drive(distance, speed);
                            }
                            case 3 -> selectedCar.brake();
                            case 4 -> selectedCar.stopEngine();
                            case 5 -> inDrivingMode = false;
                            default -> System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
                        }
                    }

                }
                case 5 -> {
                    while (true) {
                        if (carCnt == 0) {
                            System.out.println("소유한 차량이 없습니다. 먼저 차량을 구매해주세요.");
                            System.out.println("메인 메뉴로 돌아갑니다.");
                            break;
                        }

                        System.out.println("[내 차량 목록:]");
                        System.out.println("--------------------------------");
                        for (int i = 0; i < carCnt; i++) {
                            System.out.println((i + 1) + ". " + myCars[i].getName() + " (현재 연료: " + String.format("%.2f", myCars[i].getCurrFuel()) + "L)");
                        }
                        System.out.println("--------------------------------");
                        System.out.println("1. 차량 주유하기");
                        System.out.println("2. 메인 메뉴로 돌아가기");
                        System.out.print("메뉴를 선택하세요: ");

                        try {
                            int choice = scanner.nextInt();
                            scanner.nextLine();

                            if (choice == 1) {
                                System.out.print("주유할 차량 번호를 입력하세요: ");
                                int carIndex = scanner.nextInt();
                                scanner.nextLine();

                                if (carIndex < 1 || carIndex > carCnt) {
                                    System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
                                    continue;
                                }

                                Car selectedCar = myCars[carIndex - 1];
                                double maxRefuel = selectedCar.getFuelSize() - selectedCar.getCurrFuel();

                                System.out.printf("\n현재 기름 : %.2fL   최대 주유 가능량: %.2fL\n", selectedCar.getCurrFuel(), maxRefuel);
                                System.out.print("얼마나 주유하시겠습니까? (L): ");
                                double carFuel = scanner.nextDouble();
                                scanner.nextLine();

                                try {
                                    selectedCar.addFuel(carFuel);
                                    System.out.printf("%.2fL 주유 됐습니다!   현재 기름 : %.2fL\n", carFuel, selectedCar.getCurrFuel());
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else if (choice == 2) {
                                System.out.println("메인 메뉴로 돌아갑니다.");
                                break;
                            } else {
                                System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
                            }
                        } catch (Exception e) {
                            System.out.println("올바른 숫자를 입력해주세요.");
                            scanner.nextLine();
                        }
                    }
                }
            }
        }
        scanner.close();
    }
}