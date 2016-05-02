/******************************************************
*Name: Rakul Mahenthiran
*Date: Mar 29, 2014
*Program: CENG310
*Program: This class is a subclass of CalculateGrade and
*         implements GradeOperations. Gathers
*         data and calculates a mark and grade. Compares
*         student marks.
******************************************************/


public class FinalExam extends CalculateGrade implements GradeOperations
{
 private int numQuestions;
 private double eachMarks;
 private int numMissed;

/**
* constructor for FinalExam
*
*@param numQuestions - number of test questions
*@param numMissed - number of questions missed
*/
 public FinalExam(int numQuestions, double numMissed)
 {
   eachMarks = 100.0 / numQuestions;
   double numericMarks = 100.0 - (numMissed * eachMarks);
   adjustMarks();
   setMarks(numericMarks);
 }

//round grade
//down to whole number -if bellow xx.5
//up to whole number -if above xx.5
 private void adjustMarks()
 {
    double marks = getMarks();
    double marksTemp = Math.floor(marks);

    if((marks - marksTemp) < 0.5)
      setMarks(marks);

    else
      setMarks(Math.ceil(marks));
 }

/**
* get value of each test question
*
*@return eachMarks - question value
*/
 public double getEachMarks()
 {
   return eachMarks;
 }

/**
* get number of questions missed
*
*@return numMissed - number of quesions student missed
*/
 public int getNumMissed()
 {
   return numMissed;
 }

/**
* compare both student grades are equal
*
*@return true/false - true if marks equal, false if not
*/
 public boolean isEqual(CalculateGrade g)
 {
   if (this.getMarks() == g.getMarks())
   {
      return true;
   }

   else
   {
      return false;
   }
 }

/**
* compare this student mark is greater than other
*
*@return true/false - true is this student mark is greater than other,
*                     or else false
*/
 public boolean isGreater (CalculateGrade g)
 {
   if (this.getMarks() > g.getMarks())
   {
      return true;
   }

   else
   {
      return false;
   }
 }

/**
* compare this student mark is less than other
*
*@return true/false - true is this student mark is less than other,
*                     or else false
*/
 public boolean isLess (CalculateGrade g)
 {
   if (this.getMarks() < g.getMarks())
   {
      return true;
   }

   else
   {
      return false;
   }
 }
}
