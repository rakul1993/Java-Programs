/******************************************************
*Name: Rakul Mahenthiran
*Date: Feb 22, 2014
*Program: CENG310
*Program: This program will prompt the user to enter a
*         number and performs the Hailstone Sequence
*         for that number (using JOption)
******************************************************/

import javax.swing.*;

public class Rakul822240982A1HailstoneSequence2
{
	public static void main(String[] args)
	{
      int n, n2;
      int count = 1;
      String newString;

      n = Integer.parseInt(JOptionPane.showInputDialog (null,"Enter a number:"));
      n2 = n;
// Allows string to be modified
      StringBuffer str = new StringBuffer (n);

// Run loop if value of number is greater than 1
	   while (n > 1)
	   {
// The number is even if the remainder is equal to 0
       if((n % 2) == 0)
       {
        n = n / 2;
        str.append(n);
// Print a comma after every number is printed when number is not equal to 0
		  if (n > 1)
		  {
			str.append(", ");
		  }
		  count++;
       }

// The number is odd if the remainder is greater than 0
       else if((n % 2) > 0)
       {
        n = (3 * n) + 1;
	     str.append(n);
		  if (n > 1)
		  {
			str.append(", ");
		  }
		  count++;
       }
      }

      JOptionPane.showMessageDialog(null,"The Hailstone Sequence for " + n2 + " is:\n" + n2 + ", " + str + "\nThe length of sequence is " + count);

   }
}
