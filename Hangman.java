/**
 * Hangman.java
 * Assignment: Final Project: Hanging in there with Hangman
 * Purpose: The purpose of this project is to test how much we
 *    have learned throughout the duration of this class and to
 *    test our ability to stay on track and set deadlines in
 *    order to complete our own project.
 *
 * @version 6/21/16
 * @authors Krishann Amaratunge, Helen Kimball, & Hunter Stubbs
 */

import java.io.*;       //for file
import java.util.*;     //scanner & ArrayList

public class Hangman {
   private int guesses;                      //counts number of times user guesses a letter
   private HangmanList hangman;              //calls upon HangmanList class
   private String word;                      //current word being used in the game
   private int levelCount;                   //keeps track of which level of difficulty the user is playing
   private Point tally;                      //calls upon Point class
   private ArrayList<Character> letterList;  //contains the individual letters that make up word
   
/**
 * initializes private fields hangman, tally, & letterList
 *    of the Hangman class
 */
   public Hangman() {
      this.hangman = new HangmanList();
      this.tally = new Point();
      this.letterList = new ArrayList<Character>();   //initializes letterList as a Character list
   }
   
/**
 * sets the level & list of private field hangman
 * adds 1 to private field levelCount when called
 * @param String level
 * @throws FileNotFoundException
 */
   public void controlLevel(String level) throws FileNotFoundException {
      hangman.setLevel(level);   //sets the level of the game
      hangman.setList();         //sets the list that will be used in the game
      this.levelCount += 1;      //adds one to level count to control level of next game
   }
   
/**
 * creates new Hangman h
 * private field tally gets int points
 * while private field levelCount is less than three, h calls controlLevel
 *    & sets test to false depending the test, number of points, & value
 *    of levelCount
 * @throws FileNotFoundException
 */
   public void nextLevel() throws FileNotFoundException {
      boolean easyLevel = true;     //sets all boolean values to true
      boolean mediumLevel = true;
      boolean hardLevel = true;
      Hangman h = new Hangman();    //class calls upon itself
      int points = tally.getPoints();  //gets the points & sets the list accordingly
      while (levelCount < 3) { //ensure that once on level 3, the game countinues to get words from level three
         if (levelCount == 0 && points == 0 && easyLevel) {
            h.controlLevel("easy"); //sets level
            easyLevel = false;      //sets easyLevel as false
         } 
         else if (levelCount == 1 && points >= 40 && mediumLevel) {
            h.controlLevel("medium"); //sets level
            mediumLevel = false;      //sets mediumLevel as false
         } 
         else if (levelCount == 2 && points >= 100 && hardLevel) {
            h.controlLevel("hard"); //sets level
            hardLevel = false;      //sets hardLevel as false
         }
      }
   }
   
/**
 * creates new LetterSearch search
 * if private int guesses is less than 6, 1 is added to guesses & boolean 
 *    check is used to test if the word contains the letter
 * points are added or subtracted from private int tally based on result 
 *    of check
 * @param char letter
 */
   public void guessLetter(char letter) {
      LetterSearch search = new LetterSearch(letterList); //calls upon LetterSearch class
      if (guesses < 6) {
         guesses += 1;
         boolean check = search.findLetter(letter);
         if (check) {
            tally.add();
         } 
         else {
            tally.subtract();
         }
      } 
      else if (guesses == 6) {
         //game over
      }
   }
   
/**
 * calls upon private field hangman to set private field word to
 *    a string
 * clears private field letterList
 * sets letterList to the individual chars of word
 */
   public void setWord() {
      this.word = hangman.getWord();
      letterList.clear();
      int length = word.length();
      for (int i = 0; i < length; i++) {
         letterList.add(word.charAt(i));
      }
   }
   
/**
 * gets the size of private field letterList
 * @return int size of letterList
 */
   public int getWordSize() {
      return letterList.size();  //returns the size of the ArrayList contain the number of Character in word
   }

/**
 * @return String word
 */
   public String getWord() {
      return word;
   }
}