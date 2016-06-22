/**
 * HangmanHead.java
 * Assignment: Final Project: Hanging in there with Hangman
 * Purpose: This class draws the gallows, head, and the game
 *    info.
 *
 * @version 6/21/16
 * @authors Krishann Amaratunge, Helen Kimball, & Hunter Stubbs
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;   

public class HangmanHead extends JPanel {
   private int length;
   private ArrayList <FoundLetter> letters = new ArrayList<FoundLetter>();
   private String level;
   private Point points;
   private int game;
   
   //takes in the length of a word, a FoundLetter ArrayListm, the level, a Point class,
   //and and int with the number value of the game
   public HangmanHead(int wordLength, ArrayList <FoundLetter> list, String level, Point points, int game){
      length = wordLength;
      if (list != null){
         for (int k = 0; k < list.size(); k++){
            (letters).add(list.get(k));
         }
      }
      
      this.level = level;
      this.points = points;
      this.game = game;                
   }
   
   //draws the gallows & the head, sets game info, & draws letters
   //that have been guessed & letter spaces
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawLine(125,50,125,25);
      g.drawLine(125,25,50,25);
      g.drawLine(50,25,50,275);
      g.drawLine(25,275,75,275); // hangman structure  
  	   g.drawOval(100,50,50,50); //head  
      
      for (int j = 0; j < letters.size(); j++){
         FoundLetter letter = (letters.get(j));
         g.setFont(new Font("SansSerif", Font.PLAIN, 30));            
         g.drawString((letter.getLetter()), (letter.getSpace() * 60 + 35), 450 );
      }    
     
      for (int i = 0; i < length; i++){
         g.drawLine( (i * 60 + 10) + 10, 450, 60 + (i * 60), 450);
         g.setFont(new Font("SansSerif", Font.PLAIN, 20));            
      }   

      // draws game information
      g.setFont(new Font("SansSerif", Font.PLAIN, 20));            
      g.drawString(("Level: " + level), 300,200);
      g.drawString(("Points: " + points.getPoints()), 500, 200);
      g.drawString(("Game: " + game), 700, 200);


   }     
}  

