/******************************************************
*Name: Rakul Mahenthiran
*Date: Apr 17, 2014
*Program: CENG310
*Program: This program is a simple Text editor
          application that allows the user various Text
          editing options (eg: save, fonts, styles,
          save as, exit, about and open).
******************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class MyTextEditor extends JFrame{

/**
* Declare Variables
*/
   private JTextArea editorText;
   private final int NUM_LINE = 10;//number of rows textarea
   private final int NUM_CHAR = 30;//number of columns textarea

   private JMenu fileMenu, editMenu, aboutMenu;
   private JMenuBar menuBar;

   private JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem, aboutItem;

   private JMenu editFontMenu, editStyleMenu;

   private JRadioButtonMenuItem serifItem, sansSerifItem;

   private JCheckBoxMenuItem italicItem, boldItem;

   private String fileName;

/**
* Creates the Text Editor
*/
   public MyTextEditor(){
      setTitle("My Text Editor");//set title

      editorText = new JTextArea(NUM_LINE, NUM_CHAR);//create editorText
      editorText.setLineWrap(true);//turn on line wrapping
      editorText.setWrapStyleWord(true);//turn on line wrapping
      JScrollPane scrollPane = new JScrollPane(editorText);//create vertical scroll bar
      add(scrollPane);

      buildMenuBar();

      pack();//pack & display window
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close when close button clicked
   }

/**
* Build Menu Bar
*/
   private void buildMenuBar(){
      //build menu tiles
      buildFileMenu();
      buildEditMenu();
      buildAboutMenu();

      //build menu bar
      menuBar = new JMenuBar();
      //add tiles to menu bar
      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(aboutMenu);
      //set menu bar
      setJMenuBar(menuBar);
   }

/**
* Creates File Menu
*/
   private void buildFileMenu(){
      fileMenu = new JMenu("File");//new menu item
      fileMenu.setMnemonic('F');//set key event

      newItem = new JMenuItem("New");
      newItem.setMnemonic('N');
      newItem.addActionListener(new NewListener());

      openItem = new JMenuItem("Open");
      openItem.setMnemonic('O');
      openItem.addActionListener(new OpenListener());

      saveItem = new JMenuItem("Save");
      saveItem.setMnemonic('S');
      saveItem.addActionListener(new SaveListener());

      saveAsItem = new JMenuItem("Save As");
      saveAsItem.setMnemonic('A');
      saveAsItem.addActionListener(new SaveListener());

      exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic('X');
      exitItem.addActionListener(new ExitListener());

      //add everything in "file" to menu
      fileMenu.add(newItem);// add to file menu
      fileMenu.add(openItem);
      fileMenu.addSeparator();//add separator
      fileMenu.add(saveItem);
      fileMenu.add(saveAsItem);
      fileMenu.addSeparator();
      fileMenu.add(exitItem);
   }

/**
* Creates edit menu on menu bar
*/
   private void buildEditMenu(){
      editMenu = new JMenu("Edit");//new menu item
      editMenu.setMnemonic('E');//add key event

      buildEditFontMenu();
      buildEditStyleMenu();
   }

/**
* Creates font menu
*/
   private void buildEditFontMenu(){
      serifItem = new JRadioButtonMenuItem("Serif");//create serif font option
      serifItem.addActionListener(new EditListener());

      sansSerifItem = new JRadioButtonMenuItem("Sans Serif");//create sans serif font option
      sansSerifItem.addActionListener(new EditListener());

      ButtonGroup group = new ButtonGroup(); //group buttons together to work as a pair
      group.add(serifItem);
      group.add(sansSerifItem);

      editFontMenu = new JMenu("Font");
      editFontMenu.setMnemonic('T');
      editFontMenu.add(serifItem);//add everything to font menu
      editFontMenu.add(sansSerifItem);

      editMenu.add(editFontMenu);//add font menu to edit
   }

/**
* Creates the style menu under edit tile
*/
   private void buildEditStyleMenu(){
      italicItem = new JCheckBoxMenuItem("Italic");//create style option
      italicItem.addActionListener(new EditListener());

      boldItem = new JCheckBoxMenuItem("Bold");
      boldItem.addActionListener(new EditListener());

      editStyleMenu = new JMenu("Style");
      editStyleMenu.setMnemonic('Y');
      editStyleMenu.add(italicItem);//add everything to style menu
      editStyleMenu.add(boldItem);

      editMenu.add(editStyleMenu); //add style menu to edit menu
   }

/**
* Creates about menu in main menu
*/
   private void buildAboutMenu(){
      aboutMenu = new JMenu("About");
      aboutMenu.setMnemonic('A');
      aboutItem = new JMenuItem("Created by Rakul Mahenthiran, ID: 822 240 982");
      aboutMenu.add(aboutItem);
   }

/**
* Handles event when new is selected in file menu
*/
   private class NewListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         editorText.setText("");
         fileName = null;
      }
   }

/**
* Handles event when open is selected in file menu
*/
   private class OpenListener implements ActionListener{
      public void actionPerformed (ActionEvent e){

         JFileChooser chooseFile = new JFileChooser();//user chooses file
         int chooserStatus = chooseFile.showOpenDialog(null);

         if (chooserStatus == JFileChooser.APPROVE_OPTION){
            File selectedFile = chooseFile.getSelectedFile();
            fileName = selectedFile.getPath();//get file location

            // open file
            if (!openFile(fileName)){
                JOptionPane.showMessageDialog(null, "Error Reading" + fileName, "Error", JOptionPane.ERROR_MESSAGE);
            }
         }
      }
   }

/**
* Method used to open file
*/
   private boolean openFile(String fileName){
      boolean check;
      String inputLine, editorString = "";

      //try catch block
      try{
         //open file
         FileReader file_reader = new FileReader(fileName);
         BufferedReader input_file = new BufferedReader(file_reader);

         //reads file to be used with editor
         inputLine = input_file.readLine();

         while (inputLine != null){
            editorString = editorString+ inputLine + "\n";
            inputLine = input_file.readLine();
         }
         editorText.setText(editorString);

         //close file
         input_file.close();

         //check if task completed
         check = true;
      }

      catch (IOException e){
         check = false;
      }
      return check;
   }

/**
* Handles event when save is selected in file menu
*/
   private class SaveListener implements ActionListener{
      public void actionPerformed(ActionEvent e){

         int chooserStatus;

         if (e.getActionCommand() == "Save As" || fileName == null){
            JFileChooser chooseFile = new JFileChooser();
            chooserStatus = chooseFile.showSaveDialog(null);

            if (chooserStatus == JFileChooser.APPROVE_OPTION){
               File selectedFile = chooseFile.getSelectedFile();// get reference
               fileName = selectedFile.getPath();// get file path
            }
         }

         //save failed error
         if (!saveFile(fileName)){
            JOptionPane.showMessageDialog(null,"Error saving " +fileName, "Error", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

 /**
* method used to save file
*/
   private boolean saveFile(String fileName){
      boolean check;
      String editorString;

      try{
         //open file
         FileWriter fwriter = new FileWriter(fileName);
         PrintWriter outputFile = new PrintWriter(fwriter);
         //write in file
         editorString = editorText.getText();
         outputFile.print(editorString);

         //close file
         outputFile.close();

         //task complete check
         check = true;
      }

      catch (IOException e){
         check = false;
      }

      return check;
   }

/**
* Handles event when exit is selected in file menu
*/
   private class ExitListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         System.exit(0);
      }
   }

/**
* Handles event when edit options are selected in menu
*/
   private class EditListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         Font textFont = editorText.getFont();//get font

         //font name and size
         String fontName = textFont.getName();
         int fontSize = textFont.getSize();

         int fontStyle = Font.PLAIN;

         //font selection
         if (serifItem.isSelected()) fontName = "Serif";
         if (sansSerifItem.isSelected()) fontName = "Sans Serif";

         //style selection
         if (italicItem.isSelected()) fontStyle += Font.ITALIC;
         if (boldItem.isSelected()) fontStyle += Font.BOLD;

         //set font and/or style
         editorText.setFont(new Font(fontName, fontStyle, fontSize));
      }
   }

/**
* Main method containing the text editor contructor to start application
*/
   public static void main(String[] args) {
        new MyTextEditor();
   }


}
