public class BankAccount {
    public double accountBalance;
    public String accountHolderName;
    public double accountNumber;

    // Class constructor
    public BankAccount(double balance, String accountHolderName, double accountNumber){
        this.accountBalance = balance;
        this.accountHolderName = accountHolderName;
        this.accountNumber =accountNumber;
    }

    public BankAccount (){
        this.accountBalance = 0.0;
        this.accountHolderName = "";
    }
    public void deposit(double amount){
        accountBalance += amount;
    }

    public void withdrawal(double amount){
        accountBalance -= amount;
    }

    public void transfer(BankAccount bankAccount,double amount){
        this.withdrawal(amount);
        bankAccount.deposit(amount);
    }

    public void printAccountDetail() {
        System.out.println("The account holder name is " + this.accountHolderName + " and the account balance is: "+ this.accountBalance);
    }
}
