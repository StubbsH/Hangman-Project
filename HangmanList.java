/**
 * HangmanList.java
 * Assignment: Final Project: Hanging in there with Hangman
 * Purpose: The purpose of this project is to test how much we
 *    have learned throughout the duration of this class and to
 *    test our ability to stay on track and set deadlines in
 *    order to complete our own project.
 *
 * @version 6/21/16
 * @authors Krishann Amaratunge, Helen Kimball, & Hunter Stubbs
 */

import java.awt.*;      //drawingpanel
import java.io.*;       //for file
import java.util.*;     //scanner

public class HangmanList {
   private ArrayList<String> list;
   private String level;
   
/**
 * initializes ArrayList<String> list
 */
   public HangmanList() {
      this.list = new ArrayList<String>();
   }
   
/**
 * clears list
 * creates Scanner input 
 * if private String level matches requirements, words from the file are
 *    transfered into list
 * @throws FileNotFoundException
 */
   public void setList() throws FileNotFoundException {
      list.clear();
      Scanner input = new Scanner(new File("" + level + ".txt"));
      String easy = "easy";
      String medium = "medium";
      if (level.equals(easy)) {
         while (input.hasNextLine()) {
            list.add(input.nextLine());
         }
      } else if (level.equals(medium)) {
         while (input.hasNextLine()) {
            list.add(input.nextLine());
         }    
      } else {
         while (input.hasNextLine()) {
            list.add(input.nextLine());
         }
      }
   }

/**
 * selects random int & gets word from list at that index
 * @return random word from list
 */ 
   public String getWord() {
      int random = (int) (Math.random() * list.size());
      return list.get(random);
   }
   
/**
 * sets String level
 * @param String level
 */
   public void setLevel(String level) {
      this.level = level;
   }
}