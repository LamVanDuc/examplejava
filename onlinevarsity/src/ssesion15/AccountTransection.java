package ssesion15;

import session14.Account;

import java.util.Scanner;

public class AccountTransection {
    String accountNumber;
    double balance = 25000;

    public static void main(String[] args) {

        double amountIn;
        int choce;
        IbankingValidation validationDeposit, validationWithdraw;
        IbankingOperation canWithdrawMoney = null, canDepositMoney;

        Scanner input = new Scanner(System.in);

        AccountTransection objAccountTrans = new AccountTransection();

        canDepositMoney =(aa,amount) ->(objAccountTrans.balance - amount);
        canDepositMoney=(aa, amount) ->(objAccountTrans.balance + amount);

        System.out.println("Enter the account number: ");
        objAccountTrans.accountNumber = input.nextLine();
        System.out.println("Enter the option");
        System.out.println("1: Deposit Money");
        System.out.println("2: Withdraw Money");
        choce = input.nextInt();
        if (choce == 1){
            System.out.println("Enter the amount to be deposited");
            amountIn = input.nextDouble();
            if (validationDeposit.validate(amountIn)) {
                System.out.println("Unabal to perform operation deposit is more than 10000");
            } else {
                System.out.println("Account Number: " + objAccountTrans.accountNumber + " Balance after Deposit: " + objAccountTrans.transaction(canDepositMoney, amountIn, objAccountTrans));
            }
        }else if (choce == 2 ){
                 System.out.println("Your available balance is : " + objAccountTrans.balance);


                System.out.println("Enter the amount to be withdrawn");
            amountIn = input.nextDouble();

            double bal= objAccountTrans.transaction(canWithdrawMoney , amountIn , objAccountTrans);
            if(validationWithdraw.validate(bal)){
                System.out.println("Unable to perform operation as after withdrawal balance would be less than 200 and your current balance is : "+bal);
            }
            else{
                System.out.println("Account Number: "+objAccountTrans.accountNumber+ " Balance after withdrawal : "+objAccountTrans.transaction(canWithdrawMoney,amountIn,objAccountTrans));
            }
         } else {
        System.out.println("invalid choice");
        }
    }


    @FunctionalInterface
    interface IbankingOperation{
        double operate(AccountTransection aa,double amount);
    }

    @FunctionalInterface
    interface IbankingValidation{
        boolean validate(double amount);
    }

    public double transaction(IbankingOperation operation, double amount,AccountTransection a){
        return operation.operate(a,amount);
    }


}
