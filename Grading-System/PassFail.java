/******************************************************
*Name: Rakul Mahenthiran
*Date: Mar 29, 2014
*Program: CENG310
*Program: This class is a subclass of CalculateGrade, this
*         class detremine whether the mark is a pass or
*         a fail.
******************************************************/

public class PassFail extends CalculateGrade
{
 private double minPassMarks;
 char grade;

/**
* Constructor for PassFail
*
*@param minPassMarks - student minimum passing mark
*/
 public PassFail(double minPassMarks)
 {
   this.minPassMarks = minPassMarks;
 }

/**
* Assigns Pass or Fail to mark
*
*@return grade - Student passed or failed
*/
 public char getGrade()
 {
 	char grade;

   if (marks >= minPassMarks)
   {
      grade = 'P';
   }

   else
   {
      grade = 'F';
   }

   return grade;
 }
}
