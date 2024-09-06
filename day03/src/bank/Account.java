package bank;

import bank.exception.InException;
import bank.exception.ZeroException;

public class Account {
    private String accNo;
    private double balance;

    public Account() {
    }

    public Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public String getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void deposit(double amount){
        this.balance += amount;
    }
    public void withdraw(double amount) throws ZeroException, InException {
        if (amount >= 0){
            throw new ZeroException("Amount must be greater than 0");
        }
        if (amount > balance){
            throw new InException("Insufficient balance");
        }
        this.balance -= amount;
    }

}
