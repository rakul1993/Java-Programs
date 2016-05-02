/******************************************************
*Name: Rakul Mahenthiran
*Date: Feb 22, 2014
*Program: CENG310
*Program: This program will prompt the user to enter
*         information concerning a meal then calculate
*         the calories from the meal
******************************************************/

import javax.swing.*;

public class Rakul822240982A1CalorieCalculator
{
	public static void main(String[] args)
	{
      String name;
      double weight, fat, carbs, protein;
      double calories;

// Read user input data into the variables using Input Dialog box
      name = JOptionPane.showInputDialog (null,"Enter the name of the dish:");
      weight = Integer.parseInt (JOptionPane.showInputDialog (null,"Enter the weight of dish (in grams):"));
      fat = Integer.parseInt (JOptionPane.showInputDialog (null,"Enter the percent fat (without the % sign):"));
      carbs = Integer.parseInt (JOptionPane.showInputDialog (null,"Enter the percent carbohydrates (without the % sign):"));
      protein = Integer.parseInt (JOptionPane.showInputDialog (null,"Enter the percent protein (without the % sign):"));

// Calculate calories
      calories = (9 * (weight * (fat/100))) + (4 * (weight * (carbs/100))) + (4 * (weight * (protein/100)));

// Display calories calculated
      JOptionPane.showMessageDialog (null,"Dish is: " + name + "\n" + "Weight of thr dish is: " + weight + " grams \n" + "Calculated calories in the dish is: " + calories + " calories");
	}
}
