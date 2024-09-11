package bank;

import bank.exception.InException;
import bank.exception.ZeroException;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("111", 1000);
        System.out.println(account);

        account.deposit(500);
        System.out.println(account);


        try {
            account.withdraw(2000);
        }
        catch (ZeroException e) {
            throw new RuntimeException(e);
        } catch (InException e) {
            throw new RuntimeException(e);
        }

        System.out.println(account);

    }
}
