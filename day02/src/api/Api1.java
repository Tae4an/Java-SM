package api;

import java.util.Random;
import java.util.Scanner;

public class Api1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner.close() 의 중요성 정리
        int number = 0;
        try{
            System.out.print("Enter Number :");
            number = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Invalid number.. Try again!");
            scanner.close();
            return;
        }

        Random rand = new Random();
        int num  = rand.nextInt(number) + 1; // 1 ~ 10
        System.out.println(num);

        scanner.close();
    }
}
