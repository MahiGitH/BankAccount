import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankMain {

    public static int mainMenu(BankAccount bankAccount){
        System.out.println("Hello " + bankAccount.accountHolderName + "!");
        //Todo
        System.out.println("Welcome to the Main Menu, what would you like to do today? ");
        System.out.println("1.To check account balance");
        System.out.println("2.To make a withdraw");
        System.out.println("3. To make a Deposit");
        System.out.println("4. To make a transfer to another account");
        System.out.println("0. To exit ");


        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        return input;
    }
    public static void main(String[] args) throws Exception {
        //Create a class with a main method where you instantiate a BankAccount object with 500 dollars.
        //Deposit 100 dollars into the account and then print the account details to the console.
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        BankAccount david = new BankAccount(50, "David", 1);
//        drew.deposit(100);
        BankAccount mahi = new BankAccount(500, "Mahi", 2);
        BankAccount joe = new BankAccount(30, "Joe", 3);

        bankAccounts.add(david);
        bankAccounts.add(mahi);
        bankAccounts.add(joe);
        System.out.println("Hello Welcome to the Bank!");
        System.out.println("Are you an existing customer? (-1 to exit)");
        System.out.println("1. yes");
        System.out.println("2. no");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        double accountBalance = 0.0;
        String accountHolderName = "";

        switch(input){
            case 1:
                    if (input == 1) {
                        System.out.println("Please select the account number of the account you'd like to access");
                        for (BankAccount bankAccount : bankAccounts) {
                            System.out.println(bankAccount.accountHolderName+ ": " + bankAccount.accountNumber);
                        }
                        int num = scan.nextInt();
                        int accountnum = Integer.parseInt(String.valueOf(num))-1;
                        BankAccount current = bankAccounts.get(accountnum);
                        mainMenu(current);
                        break;
                    }

            case 2:
                if (input == 2) {
                System.out.println("Lets make a new account");
                System.out.println("What's the name of account");
                accountHolderName = scan.next();
                System.out.println("What's the beginning balance");
                accountBalance = scan.nextDouble();
                break;
                }
            case 3:
                if(input == -1) {
                    System.out.println("Thanks for banking with us");
                    System.exit(0);
                    break;
                }
            default:
                System.out.println("Invalid entry");
        }
        Random rand = new Random();
        int account = rand.nextInt();
        BankAccount bankAccount = new BankAccount(accountBalance, accountHolderName,account);
        BankAccount bankAccount2 = new BankAccount();
        int choice = mainMenu(bankAccount);
        do {
            switch(choice){
                case 1:
                    System.out.println("your balance is " + bankAccount.accountBalance);
                    break;
                case 2:
                    System.out.println("enter your withdrawal amount: ");
                    double withdrawalAmount = scan.nextDouble();
                    bankAccount.withdrawal(withdrawalAmount);
                    System.out.println("your balance is now " + bankAccount.accountBalance);
                    break;
                case 3:
                    System.out.println("enter your deposit amount: ");
                    double depositAmount = scan.nextDouble();
                    bankAccount.deposit(depositAmount);
                    System.out.println("your balance is now " + bankAccount.accountBalance);
                    break;
                case 4:
                    while (true) {
                        System.out.println("Please enter the account number to transfer to: ");
                       int acc = scan.nextInt();
                        int accountNumber = Integer.parseInt(String.valueOf(acc))-1;
                        if(accountNumber>bankAccounts.size()){
                            System.out.println("Account doesn't exist");
                            break;
                        }
                        System.out.println("Please enter the amount to transfer");
                        double transferAmount = scan.nextDouble();
                        bankAccount.transfer(bankAccount2, transferAmount);
                        System.out.println("The name on the account is: " + bankAccount.accountHolderName + " and they have a balance of " + bankAccount.accountBalance);
                        System.out.println(" Transferred account balance is now " + bankAccount2.accountBalance);
                    }
                    break;
                default:
                    System.out.println("Invalid entry");
            }
            choice = mainMenu(bankAccount);
        } while (choice != 0);


    }


}