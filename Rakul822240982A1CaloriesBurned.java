/******************************************************
*Name: Rakul Mahenthiran
*Date: Feb 22, 2014
*Program: CENG310
*Program: This program will prompt the user to enter
*         information concerning their excercise
*         activity and calculate the calories they
*         burned.
******************************************************/



import java.util.Scanner;
import java.text.*;

public class Rakul822240982A1CaloriesBurned
{
	public static void main(String[] args)
	{
	 Scanner input = new Scanner(System.in);
// Only takes 2 decimals after number
    DecimalFormat df = new DecimalFormat("0.00");
	 double age, weight, heart_rate, exercise_time;
    char gender;

// Read data into declared variables
    System.out.println("Enter your gender (m=male, f=female)");
    gender = input.next().trim().charAt(0);
    System.out.println("Enter your age:");
    age = input.nextDouble();
    System.out.println("Enter your weight:");
    weight = input.nextDouble();
    System.out.println("Enter your heart rate(bpm):");
    heart_rate = input.nextDouble();
    System.out.println("Enter the duration of exercise (in mins):");
    exercise_time = input.nextDouble();

// Checks if gender is male or female
    if (gender == 'm')
    {
// Calculate calories burned and print
     double calories = ((age * 0.2017) - (weight * 0.09036) + (heart_rate * 0.6309) - 55.0969) * exercise_time / 4.184;
     System.out.println("You burned " + df.format(calories) + " calories.");
    }

    if (gender == 'f')
    {
// Calculate calories burned and print
     double calories = ((age * 0.074) - (weight * 0.05741) + (heart_rate * 0.4472) - 20.4022) * exercise_time / 4.184;
     System.out.println("You burned " + df.format(calories) + " calories.");
    }

   }
}
