package control;

import java.util.Scanner;

public class Control4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Enter Command: ");
            String cmd = scanner.nextLine();
            if (cmd.equals("q")){
                System.out.print("Quit: ");
                break;
            } else if (cmd.equals("i")) {
                System.out.print("Insert ID: ");
                String id = scanner.nextLine();

                System.out.print("Insert PW: ");
                String pw = scanner.nextLine();
                System.out.println(id);
                System.out.println(pw);
            } else if (cmd.equals("s")) {
                System.out.print("Search: ");
            }else {
                System.out.println("Try again..!");
            }
        }
        scanner.close();
    }
}
