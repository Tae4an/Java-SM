package edu.sm.app;


import static edu.sm.app.Utility.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            int choice = getIntInput();
            switch (choice) {
                case 1 -> signUp();
                case 2 -> { if(login()) showLoggedInMenu(); }
                case 3 -> {
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
    }

}