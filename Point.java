/**
 * Point.java
 * Assignment: Final Project: Hanging in there with Hangman
 * Purpose: The purpose of this project is to test how much we
 *    have learned throughout the duration of this class and to
 *    test our ability to stay on track and set deadlines in
 *    order to complete our own project.
 *
 * @version 6/21/16
 * @authors Krishann Amaratunge, Helen Kimball, & Hunter Stubbs
 */

public class Point {
   private int totalPoints;   //all the points accumulated over a level
   
/**
 * initializes int totalPoints
 */
   public Point(){
      totalPoints = 0;        //points start at a zero value
   }
   
/**
 * adds 10 to totalPoints
 */
   public void add(){
      totalPoints += 10;      //adds 10 points for each word the user guesses
   }
   
/**
 * if subtracts 5 from totalPoints as long as its value will remain
 *    >= 0
 */
   public void subtract(){
      int points = this.totalPoints;
      points -= 5;
      if (points > 0){              //ensures that the points will not go negative if penalized
         this.totalPoints = points;
      }
      else {                        //if the points will go negative, they are just set to 0 value
         this.totalPoints = 0;
      }      
   }
/**
 * gets private int totalPoints
 * @return totalPoints
 */
   public int getPoints(){
      return this.totalPoints;   //returns the number of points so that they can appear on screen
   }    

/**
 * sets totalPoints to given value
 * @param int x
 */
   public void setTotalPoints(int x){
      this.totalPoints = x;
   }
}