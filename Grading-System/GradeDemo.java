/******************************************************
*Name: Rakul Mahenthiran
*Date: Mar 29, 2014
*Program: CENG310
*Program: Calculate and show grades for Joe and Don in Pass/Fail exam
*         Calculate and show grades for Joe and Don in the Final Exam
*         Identify the student obtaining higher marks in the Final Exam
******************************************************/


import javax.swing.*;
import java.util.*;
import java.text.*;

public class GradeDemo
{
   public static void main(String[] args)
	{
//take user input
     int numQuestions  = Integer.parseInt (JOptionPane.showInputDialog(null,"How many questions are on the Pass/Fail Exam?"));
     double minPass = Double.parseDouble (JOptionPane.showInputDialog(null,"What is the minimum Pass score in Pass/Fail Exam?"));

     int joeMissed = Integer.parseInt (JOptionPane.showInputDialog(null,"How many questions did Joe miss?"));
//create object of type PassFailExam
     PassFailExam passFailJoe = new PassFailExam(numQuestions, joeMissed, minPass);

//deisplay PassFail exam data
     JOptionPane.showMessageDialog(null,"Each question counts:" + passFailJoe.getEachMarks() + " points" +
                                        "\nJoe's Pass/Fail Exam score is:" + passFailJoe.getMarks() +
                                        "\nJoe's Pass/Fail exam grade is:" + passFailJoe.getGrade());

     int donMissed = Integer.parseInt (JOptionPane.showInputDialog(null,"How many questions did Don miss?"));
     PassFailExam passFailDon = new PassFailExam(numQuestions, donMissed, minPass);

     JOptionPane.showMessageDialog(null,"Each question counts:" + passFailDon.getEachMarks() + " points" +
                                        "\nDon's Pass/Fail Exam score is:" + passFailDon.getMarks() +
                                        "\nDon's Pass/Fail exam grade is:" + passFailDon.getGrade());
//end of pass fail exam
     JOptionPane.showMessageDialog(null,"End of Operations for Pass/Fail Exam.");

     numQuestions = Integer.parseInt (JOptionPane.showInputDialog(null,"How many question are on the Final Exam?"));

     joeMissed = Integer.parseInt (JOptionPane.showInputDialog(null,"How many questions did Joe miss in the Final Exam?"));
     FinalExam finalJoe = new FinalExam(numQuestions, joeMissed);

     JOptionPane.showMessageDialog(null,"Each question counts:" + finalJoe.getEachMarks() + " points" +
                                        "\nJoe's Final Exam score is:" + finalJoe.getMarks() +
                                        "\nJoe's Final Exam grade is:" + finalJoe.getGrade());

     donMissed = Integer.parseInt (JOptionPane.showInputDialog(null,"How many questions did Don miss in the Final Exam?"));
     FinalExam finalDon = new FinalExam(numQuestions, donMissed);

     JOptionPane.showMessageDialog(null,"Each question counts:" + finalDon.getEachMarks() + " points" +
                                        "\nDon's Final Exam score is:" + finalDon.getMarks() +
                                        "\nDon's Final Exam grade is:" + finalDon.getGrade());

//end of final exam
     JOptionPane.showMessageDialog(null,"End of Operations for Final Exam.");

//using GradeOperations interfaces to compare marks
     if (finalJoe.isEqual(finalDon))
     {
      JOptionPane.showMessageDialog(null,"Joe's Final Exam marks(" + finalJoe.getMarks() +
                                         ") are equal to Don's(" + finalDon.getMarks() +
                                         ")");
     }

     else if (finalJoe.isGreater(finalDon))
     {
      JOptionPane.showMessageDialog(null,"Joe's Final Exam marks(" + finalJoe.getMarks() +
                                         ") are higher then Don's(" + finalDon.getMarks() +
                                         ")");
     }

     else if(finalJoe.isLess(finalDon))
     {
      JOptionPane.showMessageDialog(null,"Don's Final Exam marks(" + finalDon.getMarks() +
                                         ") are higher then Joe's(" + finalJoe.getMarks() +
                                         ")");
     }
   }
}
