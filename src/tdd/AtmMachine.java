package tdd;

import java.util.Scanner;

public class AtmMachine {

    public static void main(String[] args) {
        Bank bank = new Bank();

        goToMainMenu();

    }

    public static void goToMainMenu(){

            System.out.print("""
                    Welcome to GTBank
                    
                    1. create account
                    2. Deposit
                    3. Withdraw
                    4. Transfer
                    5. check Balance
                    6. Exit Application
                    """);
            String option = input();

            switch (option) {
                case "1": createAccount();
                case "2": deposit();
                case "3": withdraw();
                case "4": Transfer();
                case "5": checkBalance();
                case "6": exitApplication();
            }

    }

    private static void exitApplication() {
        exit();
    }

    private static void Transfer() {
        Bank bank = new Bank();
        String myPin = input();
        System.out.print("Enter the sending account: ");
        int sendingAccount = newInput();
        System.out.print("Enter the receiving account: ");
        int receivingAccount = newInput();
        System.out.print("Enter the amount to transfer: ");
        int amount = newInput();
        bank.transferFrom(myPin,sendingAccount,receivingAccount,amount);
        goToMainMenu();
    }

    private static void checkBalance() {
        Bank bank = new Bank();
        System.out.print("Enter the account to check balance: ");
        int accountNumber = newInput();
        System.out.print("Enter the pin to check balance: ");
        String myPin = input();
        bank.checkBalanceFor(myPin, accountNumber);
        goToMainMenu();
    }

    private static void withdraw() {
        Bank bank = new Bank();
        System.out.print("Enter the pin: ");
        String myPin = input();
        System.out.print("Enter the account to withdraw: ");
        int accountToWithdrawFrom = newInput();
        System.out.print("Enter the amount to withdraw: ");
        int amount = newInput();
        bank.withdrawFrom(myPin,accountToWithdrawFrom,amount);
        goToMainMenu();
    }

    public static String input(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int newInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void exit(){
        System.exit(0);
    }

    public static void deposit() {
        Bank bank = new Bank();
        System.out.print("Enter the amount to deposit: ");
        int amount = newInput();
        System.out.print("Enter the account to deposit: ");
        int accountNumber = newInput();
        bank.deposit(amount,accountNumber);
        goToMainMenu();
    }

    public static void createAccount() {
        Bank bank = new Bank();
        System.out.print("Enter account number: ");
        String accountNumber1 = input();
        System.out.print("Enter pin: ");
        String pin1 = input();
        bank.addCustomer(pin1, accountNumber1);
        goToMainMenu();
    }



}
