/******************************************************
*Name: Rakul Mahenthiran
*Date: Mar 29, 2014
*Program: CENG310
*Program: This class is a subclass of PassFail. Gathers
*         data and calculates a mark to determine if
*         student passed or failed
******************************************************/


public class PassFailExam extends PassFail
{
 private int numQuestions;
 private double eachMarks;
 private int numMissed;

/**
* constructor for PassFailExam
*
*@param numQuestions - number of test questions
*@param numMissed - number of unanswerd questions
*@param minPassMarks - minimum passing mark
*/
 public PassFailExam(int numQuestions, int numMissed, double minPassMarks)
 {
   super(minPassMarks);

   eachMarks = 100.0 / numQuestions;

   double numericMarks = 100.0 - (numMissed * eachMarks);

   setMarks(numericMarks);
 }

/**
* getter for value of each mark
*
*@return eachMarks - value of each mark
*/
 public double getEachMarks()
 {
 	return eachMarks;
 }

/**
* getter for number of questions unanswered
*
*@return numMissed - Number of questions unanswered
*/
 public int getNumMissed()
 {
 	return numMissed;
 }
}
