/**
 * FoundLetter.java
 * Assignment: Final Project: Hanging in there with Hangman
 * Purpose: This class is used to put the spaces between the
 *    letters that are presented on screen of our GUI.
 *
 * @version 6/21/16
 * @authors Krishann Amaratunge, Helen Kimball, & Hunter Stubbs
 */

public class FoundLetter {
   private int space;
   private String letter;
   
   //takes in an int & a String
   public FoundLetter(int space, String letter){
      this.space = space;
      this.letter = letter;
   }
   
   //returns space
   public int getSpace(){
      return space;
   }
   
   //returns letter
   public String getLetter(){
      return letter;
   }
}