/******************************************************
*Name: Rakul Mahenthiran
*Date: Mar 29, 2014
*Program: CENG310
*Program: Holds the numeric marks and converts them to
*         corresponding letter grade. This class is the
*         top parent class.
******************************************************/


public class CalculateGrade
{
 protected double marks;

//default constructor
 public CalculateGrade(){}

/**
* Setter for Marks Value
*
*@param marks - Input student Marks
*/
 public void setMarks(double marks)
 {
   this.marks = marks;
 }

/**
* Getter for Marks Value
*
*@return marks - student Marks
*/
 public double getMarks()
 {
   return marks;
 }

/**
* assign grade to mark
*
*@return letterGrade - student letter grade
*/
 public char getGrade()
 {
 	char letterGrade;

   if (marks >= 90)
   {
      letterGrade = 'A';
   }

   else if (marks >= 80 && marks < 90)
   {
      letterGrade = 'B';
   }

   else if (marks >= 70 && marks < 80)
   {
      letterGrade = 'C';
   }

   else if (marks >= 60 && marks < 70)
   {
      letterGrade = 'D';
   }

   else
   {
      letterGrade = 'F';
   }
   return letterGrade;
 }
}
