/******************************************************
*Name: Rakul Mahenthiran
*Date: Apr 17, 2014
*Program: CENG310
*Program: This is a Guess WOrd Game about Movies.
*         Program prompts the user to guess the name
*         of the movie character by character, while
*         providing hints.
******************************************************/
import javax.swing.*;
import java.io.*;
import java.util.*;


public class GuessWordGame
{
   public static void main(String[] args) throws Exception
   {
      JFileChooser fileChooser = new JFileChooser();

      /*check if text file was selected */
      if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

         File file = fileChooser.getSelectedFile();   //open slected file
         Scanner input = new Scanner(file);  //create scanner object for slected file
         int wordCount = input.nextInt();  //read number of words in words.txt

         /*generate a random number from 1 to #of words */
         int rand = (int)(Math.random() * wordCount + 1);

         String hiddenWord ="empty";   //intialized string to hold word matching the random#

         /*loop to read random word from words.txt */
         for(int count = 1; count <= rand; count++){
            hiddenWord = (input.next());
            if(count != rand){   //condition to ensure loop does not jump to newline @ random word
               input.nextLine();
            }
         }

         input.next();  //skip past hint in words.txt

         /*array list to hold hint reference */
         ArrayList<Integer> hints = new ArrayList<>();
         int numHints = 6; //all hints are 6 in word.txt, so no need to read from file

         /*loop through and store all hint refrences in array list */
         for(int count2 = 1; count2 <= numHints; count2++){
            hints.add(input.nextInt());
         }

         input.close(); //close file scanner

         int missedAttempts = guessWord(hiddenWord, hints); // call guessWord method

         JOptionPane.showMessageDialog(null, "You've got the Movie!\nIt's "
                                       + hiddenWord + ".\nYou missed "
                                       + missedAttempts + " attempts.");   //game won message & attempts
      }

      /*condition for file not been selected */
      else {
         JOptionPane.showMessageDialog(null,"No File Slected");
      }
   }


/*******************************************************************************************************/


   static int guessWord(String hW, ArrayList<Integer> hint) throws Exception
   {
      int numberOfCorrectLettersGuessed = 0;
      String stringLetter = "empty";
      int numberOfMisses = 0, attempts = 0;
      int hintCount = hint.size(), hintUsed = 0;

      StringBuilder guessedWord = new StringBuilder();   //string builder object created

      /*fill string with '*' based on word length for guessing */
      for(int count3 = 1; (hW.length()) >= count3; count3++){
         guessedWord.append('*');
      }

      java.io.File file2 = new java.io.File("hints.txt");   //open file hints.txt

      /*guess until word is found loop */
      while (numberOfCorrectLettersGuessed < (hW.length())){
         stringLetter = (JOptionPane.showInputDialog(null,"Geuss a letter in the Movie's name(2004-present) < "
                                                      + guessedWord + " >" ));   //read user guess letter as string

         char letter = stringLetter.charAt(0);  //convert string scanned to char

         /*check if guess is correct and set it or if letter already exists*/
         for (int i = 0; i < guessedWord.length(); i++){

            if (letter == hW.charAt(i)){
               if(letter == guessedWord.charAt(i)){
                  JOptionPane.showMessageDialog(null, "'" + letter + "' is already in the Movie's name.");
                  break;   //break loop so message in not repeated multiple times
               }

               else{
                  guessedWord.setCharAt(i,letter);
                  numberOfCorrectLettersGuessed++;
               }
            }
         }

         boolean wordFound = false;

         /*check if letter doesn't exist in word*/
         for(int i = 0; i < hW.length(); i++){
            if(letter == hW.charAt(i)){
               wordFound = true;
            }
         }

         /*hint and help option*/
         if(wordFound == false){
            String helpString = JOptionPane.showInputDialog(null, "Sorry: " + letter + " is not in the Movie's name.\n"
							                          + "Do you need a hint? You'll get in total " + hintCount
							                          + " hints\n" + "Enter 'y' or 'n' And it'll be your #"
                                               + (hintUsed + 1));

            char help = helpString.charAt(0);   //convert help string to char
            numberOfMisses++;
            attempts++;

            /*if user accepts help*/
            if(help == 'y'){
               Scanner input2 = new Scanner(file2);   //create scanner object for file

               /*check if hints are available then loop to display hint*/
               if(hintUsed < 6){
                  while(hintUsed < hint.size()){
                     for (int i = 0; i < hint.get(hintUsed); i++){
                        if (i == (hint.get(hintUsed) - 1)){
                           JOptionPane.showMessageDialog(null,input2.nextLine());
                        }
                        else{
                           input2.nextLine();
                        }
                     }
                     hintUsed++;
                     hintCount--;
                     input2.close();   //close file scanner
                     break;   //break loop after 1 run
                  }
               }

               /*check if all hints are used then diplay bonus hint*/
               else if(hintUsed == 6){
                  JOptionPane.showMessageDialog(null, "SORRY: You've used all available hints.");
                  char firstLetter = '\0', lastLetter = '\0';

                  /*loop to capture first and last letter*/
                  for(int i = 0; i < hW.length(); i++){
                     if(i == 0){
                        firstLetter = hW.charAt(i);
                     }
                     if(i == (hW.length() - 1)){
                        lastLetter = hW.charAt(i);
                     }
                  }
                  JOptionPane.showMessageDialog(null, "A BONUS hint: The Movie starts with '" +
                                                firstLetter + "' and ends with '" + lastLetter + "'.");
               }
            }

            /*continue loop is user doesnt choose hint*/
            else{
               continue;
            }
         }
      }
      return attempts;  //returns number of missed attempts
   }
}
