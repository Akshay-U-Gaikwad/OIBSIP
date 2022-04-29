import java.text.NumberFormat;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Account current = new Account();
        current.setType("Current ");
        current.setBalance(700000);
        current.setRate(0.00);

        Account savings = new Account();
        savings.setType("Savings");
        savings.setBalance(300000);
        savings.setRate(8.00);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Scanner input = new Scanner(System.in);

        boolean session = true;

        while (session) {

            System.out.println("\nATM Menu:\n  \n"
                    + "1. Deposit \n"
                    + "2. Withdrawal \n"
                    + "3. Transfer Money \n"
                    + "4. Check Your Account Balance\n"
                    + "5. End Your Session \n"
                    + "Enter selection: ");

            int selection = input.nextInt();

            switch (selection) {

                case 1:
                    System.out.print("Enter (1) for Saving Account or (2) for Current Account: \n");
                    int depAccount = input.nextInt();

                    if (depAccount == 1) {

                        System.out.println(
                                "Your Saving Account balance is: \n" + formatter.format(savings.getBalance()));

                        System.out.println("Please Enter The Amount For Deposit!!\n");
                        double deposit = input.nextDouble();

                        savings.deposit(deposit);

                        System.out.println(
                                "Your Saving Account  balance is: \n" + formatter.format(savings.getBalance()));

                    }

                    else if (depAccount == 2) {

                        System.out.println("Your  Current Account balance is:\n "
                                + formatter.format(current.getBalance()));

                        System.out.println("Please Enter The Amount For Deposit!!\n");
                        double deposit = input.nextDouble();

                        current.deposit(deposit);

                        System.out.println(
                                "Current Account balance is: \n" + formatter.format(current.getBalance()));

                    }

                    break;

                case 2:
                    System.out.print("Enter (1) for Saving Account or (2) for Current Account: \n");
                    int witAccount = input.nextInt();

                    if (witAccount == 1) {

                        System.out.println(
                                "Your Saving Account  balance is: \n" + formatter.format(savings.getBalance()));

                        System.out.println("Please Enter The Amount For Withdrawal!!\n");
                        double withdraw = input.nextDouble();

                        savings.withdraw(withdraw);

                        System.out.println(
                                "Your Saving Account  balance is: \n" + formatter.format(savings.getBalance()));

                    }

                    else if (witAccount == 2) {

                        System.out.println("Your Current Account balance is: \n"
                                + formatter.format(current.getBalance()));

                        System.out.println("Please Enter The Amount For Withdrawal!!\n");
                        double withdraw = input.nextDouble();

                        current.withdraw(withdraw);

                        System.out.println(
                                "Your Current Account balance is: \n" + formatter.format(current.getBalance()));

                    }

                    break;

                case 3:
                    System.out.print(
                            "From which account do you wish to transfer funds from?, (1) for Saving Account or (2) for Current Account: \n");
                    int tranAccount = input.nextInt();

                    if (tranAccount == 1) {

                        System.out.println(
                                "Your Saving Account balance is: \n" + formatter.format(savings.getBalance()));

                        System.out.print(
                                "How much money do you wish to transfer from Saving Account to Current Account?:\n ");
                        double tranAmount = input.nextDouble();

                        savings.withdraw(tranAmount);
                        current.deposit(tranAmount);

                        System.out.println("Your Money Successfully Transferred " + formatter.format(tranAmount)
                                + " from Saving Account to Current Account\n");

                        System.out.println("Current Account Balance is : \n" + formatter.format(current.getBalance()));
                        System.out.println("Saving Account Balance is : \n" + formatter.format(savings.getBalance()));

                    }

                    else if (tranAccount == 2) {

                        System.out.println("Your Current Account balance is:\n "
                                + formatter.format(current.getBalance()));

                        System.out.print(
                                "How much money do you wish to transfer from Current Account to Saving Account?:\n ");
                        double tranAmount = input.nextDouble();

                        current.withdraw(tranAmount);
                        savings.deposit(tranAmount);

                        System.out.println("Your Money Successfully Transferred " + formatter.format(tranAmount)
                                + " from Current Account  to Saving Account\n");

                        System.out.println("Current Account  Balance is : \n" + formatter.format(current.getBalance()));
                        System.out.println("Saving Account  Balance is : \n" + formatter.format(savings.getBalance()));

                    }

                    break;

                case 4:
                    System.out.println("Current Account Balance is :\n" + formatter.format(current.getBalance()));
                    System.out.println("Saving Account Balance is :\n" + formatter.format(savings.getBalance()));

                    break;

                case 5:
                    session = false;

                    break;

            }

        }

        System.out.println("Thank you for banking with us!!!");
        System.out.println("Have a Great day!!!");

    }

}

class Account {

    String type;
    double balance;
    double rate;

    void setType(String accType) {

        type = accType;
    }

    void setBalance(double accBal) {

        balance = accBal;
    }

    void setRate(double accRate) {

        rate = accRate;
    }

    void deposit(double dep) {

        balance += dep;
    }

    void withdraw(double wit) {

        balance -= wit;
    }

    String getType() {

        return type;
    }

    double getBalance() {

        return balance;
    }

    double getRate() {

        return rate;

    }

}
