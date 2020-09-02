//In this assignment you are to use Java GUI widget toolkit to develop a GUI interface for a simple calculator. 
//For now, your code will just produce and display the GUI elements, but will not respond to any events.

import javax.swing.*;
import java.awt.*;
public class lab08
{
   //This makes an easier transition to the next lab
   static JButton but1;
   static JButton but2;
   static JButton but3;
   static JButton but4;
   static JButton but5;
   static JButton but6;
   static JButton but7;
   static JButton but8;
   static JButton but9;
   static JButton but0;
   static JButton butStar;
   static JButton butPlus;
   static JButton butMinus;
   static JButton butC;
   static JButton butDiv;
   static JButton butEquals;
   public static void main(String[] args)
   {
      //We first create the frame that will hold everything else
      JFrame frm = new JFrame("Calculator");
      Container contentPane = frm.getContentPane();
      contentPane.setLayout(new GridLayout(7,1));
      frm.setVisible(true);
      
      //Add the title bar on top
      JLabel label = new JLabel("CSC 20 Lab08", JLabel.CENTER);
      contentPane.add(label);
      
      //Next make the text bar
      JTextField textField = new JTextField();
      contentPane.add(textField);
      
      //Next make the button area
      //Each row has it's own panel
      JPanel butT = new JPanel(new GridLayout(1,4)); //This will be the top panel
      JPanel butM = new JPanel(new GridLayout(1,4)); //Middle panel
      JPanel butB = new JPanel(new GridLayout(1,4)); //Bottom panel
      JPanel but4R = new JPanel(new GridLayout(1,4)); //Fourth row
      JPanel but5R = new JPanel(new GridLayout(1,4)); //Fifth row aka the equals sign
      //Make all the butttons.
      but1 = new JButton("1");
      but2 = new JButton("2");
      but3 = new JButton("3");
      butStar = new JButton("*");
      but4 = new JButton("4");
      but5 = new JButton("5");
      but6 = new JButton("6");
      butMinus = new JButton("-");
      but7 = new JButton("7");
      but8 = new JButton("8");
      but9 = new JButton("9");
      butPlus = new JButton("+");
      butC = new JButton("C");
      but0 = new JButton("0");
      butDiv = new JButton("/");
      butEquals = new JButton("=");
      //Organize buttons, start with first row
      butT.add(but1);
      butT.add(but2);
      butT.add(but3);
      butT.add(butPlus);
      //Second row (4, 5, 6, -)
      butM.add(but4);
      butM.add(but5);
      butM.add(but6);
      butM.add(butMinus);
      //Third row (7 8 9 *)
      butB.add(but7);
      butB.add(but8);
      butB.add(but9);
      butB.add(butStar);
      //Fourth row ( C 0 /) The C button is it's own panel
      JPanel C = new JPanel(new GridLayout(1,2));
      JPanel right = new JPanel(new GridLayout(1,2));
      C.add(butC);
      right.add(but0);
      right.add(butDiv);
      but4R.add(C);
      but4R.add(right);
      //Last row is just the equals sign
      but5R.add(butEquals);
      //Now add all those panels to the contentPane
      contentPane.add(butT);
      contentPane.add(butM);
      contentPane.add(butB);
      contentPane.add(but4R);
      contentPane.add(but5R);
         
      frm.pack();
      frm.setSize(666,420);
      frm.setResizable(true);
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frm.setVisible(true);
   }
}
//Each row is it's own panel
//the C button is a panel in a panel. 
//The equals button should be it's own panel, that's a 4x1. 
//Make panels and add things to the panel and then add the panels to the contentPane