package tdd;

public class Account {

    private int accountNumber;
    private double balance;
    private String accountName;
    private String pin;

    public Account(int accountNumber, String accountName, String pin) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.accountName = accountName;
        this.pin = pin;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double deposit(int amount) {
        if (amount <= 0) {
            return 0;
        }
        else {
            this.balance = this.balance + amount;
        }
        return balance;
    }

    public double withdraw(double withdrawalAmount) {
        if(withdrawalAmount > this.balance) {
            System.out.println("Insufficient funds");
        }
        else{
            this.balance = this.balance - withdrawalAmount;
        }
        return balance;
    }

    public double checkAccountBalance() {
        return this.balance;
    }
}
