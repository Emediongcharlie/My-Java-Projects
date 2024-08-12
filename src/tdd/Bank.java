package tdd;
import java.util.ArrayList;
import java.util.Random;

public class Bank {

    ArrayList<Account> accounts = new ArrayList<>();
    private int noOfCustomers;

    public int getNoOfCustomers() {
        return noOfCustomers;
    }

    public void addCustomer(String name, String pin) {
        Account myaccount = new Account(generateAccount(), name, pin);
        accounts.add(myaccount);
        noOfCustomers++;
    }

    public int getAddCustomer() {
        return noOfCustomers;
    }

    public int generateAccount(){
        return noOfCustomers + 1;
    }

    public void withdrawFrom(String pin, int accountNumber, int amount) {
        if(findAccountWith(accountNumber).getPin().equals(pin)){
            Account myaccount = findAccountWith(accountNumber);
            myaccount.withdraw(amount);
        }
    }
    public Account findAccountWith(int accountNumber) {
        for (Account account : accounts) {
            boolean accountFound =  account.getAccountNumber() == accountNumber;
            if (accountFound) {return account;}
        }
      return null;
    }

    public void transferFrom(String pin, int sendingAccountNumber, int receivingAccountNumber, int amount) {
        if(findAccountWith(sendingAccountNumber) != null) {
            Account myaccount = findAccountWith(sendingAccountNumber);
            Account myAccountTwo = findAccountWith(receivingAccountNumber);
            myaccount.withdraw(amount);
            myAccountTwo.deposit(amount);

        }
    }

    public void checkBalanceFor(String pin, int accountNumber) {
        if(accounts.get(accountNumber).getPin().equals(pin)) {
            Account myaccount = findAccountWith(accountNumber);
            myaccount.checkAccountBalance();
        }
    }

    public void deposit(int amount, int accountNumber){
       Account myAccount = findAccountWith(accountNumber);
        myAccount.deposit(amount);
    }

}
