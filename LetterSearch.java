/**
 * LetterSearch.java
 * Assignment: Final Project: Hanging in there with Hangman
 * Purpose: The purpose of this project is to test how much we
 *    have learned throughout the duration of this class and to
 *    test our ability to stay on track and set deadlines in
 *    order to complete our own project.
 *
 * @version 6/21/16
 * @authors Krishann Amaratunge, Helen Kimball, & Hunter Stubbs
 */

import java.util.*;     //for ArrayList

public class LetterSearch {
   private ArrayList<Character> letterList;  //list created to contain all the letters of a word
   
/**
 * initializes private field letterList
 * @param ArrayList<Character> letterList
 */
   public LetterSearch(ArrayList<Character> letterList) {
      this.letterList = letterList;          //list set to given list of word's letters
   }
   
/**
 * searches through letterList for a char &, if found, shows all instances'
 *    of the char in letterList
 * @param char letter
 * @return boolean true (if int count == 1), else false
 */
   public boolean findLetter(char letter) {
      int count = 0;
      int length = letterList.size();
      for (int i = 0; i < length; i++) {
         if (letterList.get(i) == letter) {  //searchs to see if the guessed letter is in the word
            //show letter on screen (in correct position relative to its placement in the word)
            count = 1;
         }
      }
      if (count == 1) {
         return true;      //returns true if the letter is in the word
      } 
      return false;        //returns false if the letter is not in the word
   }
}