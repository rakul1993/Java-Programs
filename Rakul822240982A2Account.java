/******************************************************
*Name: Rakul Mahenthiran
*Date: Mar 08, 2014
*Program: CENG310
*Program: Allows joe and Don to enter their account
*         information then withdraw or deposit money
*         from their accounts
******************************************************/
import javax.swing.*;
import java.util.*;
import java.text.*;


public class Rakul822240982A2Account
{
//declare & initalize variables
   private int id = 0;
   private double balance = 0;
   static private double annualInterestRate = 0;
   private Date date=new Date();
   DecimalFormat df = new DecimalFormat("0.00");

//default constructor
   public Rakul822240982A2Account()
   {   }

//constructor that takes id and balance
   public Rakul822240982A2Account(int id, double balance)
   {
      this.id = id;
      this.balance = balance;

   }

//set id value
   public void setID(int id)
   {
      this.id = id;
   }

//set balance value
   public void setBalance(double balance)
   {
      this.balance = balance;
   }

//set interest rate
   public void setAnnualInterestRate(double annualInterestRate)
   {
      this.annualInterestRate = annualInterestRate;
   }

//get id value
   public int getID()
   {
      return id;
   }

//get balance value
   public double getBalance()
   {
      return balance;
   }

//get annual interest rate
   public double getAnnualInterestRate()
   {
      return annualInterestRate;
   }

//get the date
   static Date getDate()
   {
      Date date = new Date();
      return date;
   }

// get mothly rate for account balance
   public double getMonthlyInterest()
   {
     return (balance * (annualInterestRate / 1200));
   }

//withdrawal function
   public void withdraw (double withdrawal)
   {
     if (balance >= withdrawal)
      {
         balance = balance - withdrawal;
      }

      else
      {
         JOptionPane.showMessageDialog(null,"\nNot sufficient balance.");
      }
   }

//deposit function
   public void deposit (double deposit)
   {
      balance = balance + deposit;
   }

// main method
	public static void main(String[] args)
	{
//cut double values off after 2 decimals
      DecimalFormat df = new DecimalFormat("0.00");

//Joe's Account
//create accountJoe object & read annual  final interest rate
      double tempInterest = Double.parseDouble (JOptionPane.showInputDialog(null,"Enter Annual Interest Rate:"));
      Rakul822240982A2Account accountJoe = new Rakul822240982A2Account();
      accountJoe.setAnnualInterestRate(tempInterest);

//read joes banking info
      int tempID = Integer.parseInt (JOptionPane.showInputDialog(null, "Enter Joes's Account ID:"));
      accountJoe.setID(tempID);
      double tempBalance = Double.parseDouble (JOptionPane.showInputDialog(null, "Enter Joe's Account Balance: ($)"));
		accountJoe.setBalance(tempBalance);

//display joes banking details
      JOptionPane.showMessageDialog(null,"Joe's Account Details:\n\n" +
                                         "Account ID: " + accountJoe.getID() +
                                         "\nAccount Balance: $" + df.format(accountJoe.getBalance()) +
                                         "\nJoe's Account was created on: " + getDate() +
                                         "\nMonthly Interest Amount: $" + df.format(accountJoe.getMonthlyInterest()));

//Don's Account
//create object accountDon
      Rakul822240982A2Account accountDon = new Rakul822240982A2Account();

// read dons banking info
      int tempID2 = Integer.parseInt (JOptionPane.showInputDialog(null, "Enter Dons's Account ID:"));
      accountDon.setID(tempID2);
      double tempBalance2 = Double.parseDouble (JOptionPane.showInputDialog(null, "Enter Dons's Account Balance: ($)"));
		accountDon.setBalance(tempBalance2);

//display dons bank info
      JOptionPane.showMessageDialog(null,"Don's Account Details:\n\n" +
                                         "Account ID: " + accountDon.getID() +
                                         "\nAccount Balance: $" + df.format(accountDon.getBalance()) +
                                         "\nJoe's Account was created on: " + getDate() +
                                         "\nMonthly Interest Amount: $" + df.format(accountDon.getMonthlyInterest()));

//Joe's Account
//choose joes transaction
      int transaction1 = Integer.parseInt (JOptionPane.showInputDialog(null,"Choose Your Operation for Joe's Account" +
                                                                            "\n\nEnter 1 to Deposit, 0 to Withdraw: "));

//if statement reads input & slects withdraw or deposit
      if (transaction1 == 0)
      {
         double tempWithdraw1 = Double.parseDouble (JOptionPane.showInputDialog(null,"\nEnter Withdrawal Amount: ($)"));
         accountJoe.withdraw(tempWithdraw1);
      }

      else if (transaction1 == 1)
      {
         double tempDeposit1 = Double.parseDouble (JOptionPane.showInputDialog(null,"\nEnter Deposit Amount: ($)"));
		   accountJoe.deposit(tempDeposit1);
      }

// invalid transaction error message
      else
      {
         JOptionPane.showMessageDialog(null,"\nERROR, Invalid Choice!!!!!!!");
      }

//Don's Account
      int transaction2 = Integer.parseInt (JOptionPane.showInputDialog(null,"Choose Your Operation for Don's Account" +
                                                                            "\n\nEnter 1 to Deposit, 0 to Withdraw: "));
      if (transaction2 == 0)
      {
         double tempWithdraw2 = Double.parseDouble (JOptionPane.showInputDialog(null,"\nEnter Withdrawal Amount: ($)"));
         accountDon.withdraw(tempWithdraw2);
      }

      else if (transaction2 == 1)
      {
         double tempDeposit2 = Double.parseDouble (JOptionPane.showInputDialog(null,"\nEnter Deposit Amount: ($)"));
		   accountDon.deposit(tempDeposit2);
      }

      else
      {
         JOptionPane.showMessageDialog(null,"\nERROR, Invalid Choice!!!!!!!");
      }

//Compare Accounts
// checking all three posible caparisons for both accounts
//displaying final balance and comparison result
      if(accountJoe.getBalance() > accountDon.getBalance())
      {
         JOptionPane.showMessageDialog(null,"Joe's Balance is: $" + accountJoe.getBalance() +
                                            "\nDon's Balance is: $" + accountDon.getBalance() +
                                            "\n\nThe Balance in Joe's account is greater than Don's.");
      }

      if(accountJoe.getBalance() < accountDon.getBalance())
      {
         JOptionPane.showMessageDialog(null,"Joe's Balance is: $" + accountJoe.getBalance() +
                                            "\nDon's Balance is: $" + accountDon.getBalance() +
                                            "\n\nThe Balance in Don's account is greater than Joe's.");
      }

      if(accountJoe.getBalance() == accountDon.getBalance())
      {
         JOptionPane.showMessageDialog(null,"Joe's Balance is: $" + accountJoe.getBalance() +
                                            "\nDon's Balance is: $" + accountDon.getBalance() +
                                            "\n\nThe Balance in Joe's account is the same as Don's.");
      }
    }
}
