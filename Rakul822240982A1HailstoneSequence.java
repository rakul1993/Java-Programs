/******************************************************
*Name: Rakul Mahenthiran
*Date: Feb 22, 2014
*Program: CENG310
*Program: This program will prompt the user to enter a
*         number and performs the Hailstone Sequence
*         for that number
******************************************************/



import java.util.Scanner;

public class Rakul822240982A1HailstoneSequence
{
	public static void main(String[] args)
	{
	 Scanner input = new Scanner(System.in);
	 int count = 1;

// Read user input for number
    System.out.print("Enter a Number:\n");
    int n = input.nextInt();

	 System.out.print("The Hailstone sequence for " + n + " is:	\n" + n + ", ");

// Run loop if value of number is greater than 1
	 while (n > 1)
	 {
// The number is even if the remainder is equal to 0
     if((n % 2) == 0)
     {
      n = n / 2;
      System.out.print(n);
// Print a comma after every number is printed when number is not equal to 0
		if (n > 1)
		{
			System.out.print(", ");
		}
		count++;
     }

// The number is odd if the remainder is greater than 0
     else if((n % 2) > 0)
     {
      n = (3 * n) + 1;
	   System.out.print(n);
		if (n > 1)
		{
			System.out.print(", ");
		}
		count++;
     }
	 }

	 System.out.print("\nThe length of the sequence is:\n" + count);
	}
}
