/**
 * SimpleFrame.java
 * Assignment: Final Project: Hanging in there with Hangman
 * Purpose: This is our main class/GUI class. It creates the
 *    frame & the letter buttons and quit buttons for the frame.
 *    It calls upon classes to set the level and get the 
 *    appropriate from that level. And, in its main method, it
 *    calls upon itself.
 *
 * @version 6/21/16
 * @authors Krishann Amaratunge, Helen Kimball, & Hunter Stubbs
 */

import javax.swing.*; //for GUI components
import java.awt.*; //for various graphical objects
import java.awt.event.*; //for action events
import java.io.*;
import java.util.*;   
import java.awt.Color;

//GUI/main class
public class SimpleFrame {
   //class calls upon itself
   public static void main(String[] args) throws FileNotFoundException {
      SimpleFrame gui = new SimpleFrame();                    
   }
   
   private String hangmanWord;
   private ArrayList <String> wordLetters;
   private ArrayList <FoundLetter> foundLetters = new ArrayList<FoundLetter>();
   private Point hangmanPoints = new Point();
   private int wrongGuesses;
   private JPanel hangmanDrawing;
   private JFrame frame;
   private int wordLength;
   private String level;
   private int gameNum = 1;

   //sets visual details of the GUI such as the width and height,
   //calls upon other classes like HangmanList and Point,
   //& sets all of the letter buttons (a-z)
   public SimpleFrame() throws FileNotFoundException{
      frame = new JFrame(); //creates GUI frame 
      frame.setSize(new Dimension(900, 650)); //sets size of frame
      frame.setForeground(Color.WHITE); //sets background of frame color
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends run when frame is closed
      frame.setTitle("HANGMAN"); //names frame (appears in top left corner)
      frame.setLayout(new BorderLayout());
      
      //NORTH PANEL title and start over/quit buttons
      JPanel npanel = new JPanel(new FlowLayout());
      npanel.setSize(new Dimension(900, 50));     
      npanel.add(new JLabel("HANGMAN THE GAME"));
     
      npanel.add(new JLabel("HANGMAN THE GAME"));
      JButton quitButton = new JButton( new AbstractAction("Quit") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            System.exit(0);         
         }         
      });   

      quitButton.setBackground(Color.PINK);
      npanel.add(quitButton);        
      frame.add(npanel, BorderLayout.NORTH);
      
      // set the level of word difficulty 
      hangmanPoints.setTotalPoints(0);
      if ((this.hangmanPoints.getPoints()) < 40){
         this.level = "easy";
      }
      else if((this.hangmanPoints.getPoints() >= 40) && (this.hangmanPoints.getPoints() < 80)) {
         this.level = "medium";
      }
      else {
         this.level = "hard";
      }
         
      // choosing game word                 
      HangmanList hangman = new HangmanList();
      hangman.setLevel(level);
      hangman.setList();
         this.hangmanWord = hangman.getWord();
      int length = hangmanWord.length();
      wordLength = length;
      wordLetters = new ArrayList<String>();
      for (int i = 0; i < wordLength; i++){
         wordLetters.add(hangmanWord.substring(i, i + 1));
      }          

      // methods for letter buttons      
      JPanel letters = new JPanel(new GridLayout(2, 13));
      letters.setSize(new Dimension(900, 150));             
      
      JButton aButton = new JButton( new AbstractAction("a") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'a'){
                  (foundLetters).add(new FoundLetter(i, "a")); 
               }
            }          

            if (wordLetters.indexOf("a") < 0){
               wrongGuesses++;     
            }             
           
            
            drawBody(foundLetters);                 
          }
      });
      letters.add(aButton);
         
      JButton bButton = new JButton( new AbstractAction("b") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'b'){
                  (foundLetters).add(new FoundLetter(i, "b")); 
               }
            }          
         
            if (wordLetters.indexOf("b") < 0){
               wrongGuesses++;     
            }              
            drawBody(foundLetters);
         }
      });
         
      letters.add(bButton);   
        
      JButton cButton = new JButton( new AbstractAction("c") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'c'){
                  (foundLetters).add(new FoundLetter(i, "c")); 
               }
            }          
         
            if (wordLetters.indexOf("c") < 0){
               wrongGuesses++;     
            }              
            drawBody(foundLetters);  
         }
      });
         
      letters.add(cButton);              
        
      JButton dButton = new JButton( new AbstractAction("d") {
         @Override
         public void actionPerformed( ActionEvent e ) {            
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'd'){
                  (foundLetters).add(new FoundLetter(i, "d")); 
               }
            }          
            
            if (wordLetters.indexOf("d") < 0){
               wrongGuesses++;     
            }              
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(dButton);   
        
      JButton eButton = new JButton( new AbstractAction("e") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'e'){
                  (foundLetters).add(new FoundLetter(i, "e")); 
               }
            }          
         
            if (wordLetters.indexOf("e") < 0){
               wrongGuesses++;     
            }              
         drawBody(foundLetters);
   
         }
      });
      
      letters.add(eButton);   
     
      JButton fButton = new JButton( new AbstractAction("f") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'f'){
                  (foundLetters).add(new FoundLetter(i, "f")); 
               }
            }    
            if (wordLetters.indexOf("f") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(fButton);
        
      JButton gButton = new JButton( new AbstractAction("g") {
         @Override
         public void actionPerformed( ActionEvent e ) {           
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'g'){
                  (foundLetters).add(new FoundLetter(i, "g")); 
                  drawBody(foundLetters);
               }
            }                                       
            
            if (wordLetters.indexOf("g") < 0){
               wrongGuesses++;     
            }  
            drawBody(foundLetters);   
         }
      });
         
      letters.add(gButton);
        
      JButton hButton = new JButton( new AbstractAction("h") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'h'){
                  (foundLetters).add(new FoundLetter(i, "h")); 
               }
            }    
            if (wordLetters.indexOf("h") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(hButton);
        
      JButton iButton = new JButton( new AbstractAction("i") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'i'){
                  (foundLetters).add(new FoundLetter(i, "i")); 
               }
            }    
            if (wordLetters.indexOf("i") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(iButton);

      JButton jButton = new JButton( new AbstractAction("j") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'j'){
                  (foundLetters).add(new FoundLetter(i, "j")); 
               }
            }    
            if (wordLetters.indexOf("j") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(jButton);
      
      JButton kButton = new JButton( new AbstractAction("k") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'k'){
                  (foundLetters).add(new FoundLetter(i, "k")); 
               }
            }    
            if (wordLetters.indexOf("k") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(kButton);
      
      JButton lButton = new JButton( new AbstractAction("l") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'l'){
                  (foundLetters).add(new FoundLetter(i, "l")); 
               }
            }    
            if (wordLetters.indexOf("l") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(lButton);
      
      JButton mButton = new JButton( new AbstractAction("m") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'm'){
                  (foundLetters).add(new FoundLetter(i, "m")); 
               }
            }    
            if (wordLetters.indexOf("m") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(mButton);
      
      JButton nButton = new JButton( new AbstractAction("n") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'n'){
                  (foundLetters).add(new FoundLetter(i, "n")); 
               }
            }    
            if (wordLetters.indexOf("n") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(nButton);
      
      JButton oButton = new JButton( new AbstractAction("o") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'o'){
                  (foundLetters).add(new FoundLetter(i, "o")); 
               }
            }    
            if (wordLetters.indexOf("o") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(oButton);
      
      JButton pButton = new JButton( new AbstractAction("p") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'p'){
                  (foundLetters).add(new FoundLetter(i, "p")); 
               }
            }    
            if (wordLetters.indexOf("p") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(pButton);
      
      JButton qButton = new JButton( new AbstractAction("q") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'q'){
                  (foundLetters).add(new FoundLetter(i, "q")); 
               }
            }    
            if (wordLetters.indexOf("q") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(qButton);
      
      JButton rButton = new JButton( new AbstractAction("r") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'r'){
                  (foundLetters).add(new FoundLetter(i, "r")); 
               }
            }    
            if (wordLetters.indexOf("r") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(rButton);
      
      JButton sButton = new JButton( new AbstractAction("s") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 's'){
                  (foundLetters).add(new FoundLetter(i, "s")); 
               }
            }    
            if (wordLetters.indexOf("s") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(sButton);
      
      JButton tButton = new JButton( new AbstractAction("t") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 't'){
                  (foundLetters).add(new FoundLetter(i, "t")); 
               }
            }    
            if (wordLetters.indexOf("t") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(tButton);
      
      JButton uButton = new JButton( new AbstractAction("u") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'u'){
                  (foundLetters).add(new FoundLetter(i, "u")); 
               }
            }    
            if (wordLetters.indexOf("u") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(uButton);
      
      JButton vButton = new JButton( new AbstractAction("v") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'v'){
                  (foundLetters).add(new FoundLetter(i, "v")); 
               }
            }    
            if (wordLetters.indexOf("v") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(vButton);
      
      JButton wButton = new JButton( new AbstractAction("w") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'w'){
                  (foundLetters).add(new FoundLetter(i, "w")); 
               }
            }    
            if (wordLetters.indexOf("w") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(wButton);
      
      JButton xButton = new JButton( new AbstractAction("x") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'x'){
                  (foundLetters).add(new FoundLetter(i, "x")); 
               }
            }    
            if (wordLetters.indexOf("x") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(xButton);
      
      JButton yButton = new JButton( new AbstractAction("y") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'y'){
                  (foundLetters).add(new FoundLetter(i, "y")); 
               }
            }    
            if (wordLetters.indexOf("y") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(yButton);
      
      JButton zButton = new JButton( new AbstractAction("z") {
         @Override
         public void actionPerformed( ActionEvent e ) {
            for (int i = 0; i < wordLength; i++){
               if (hangmanWord.charAt(i) == 'z'){
                  (foundLetters).add(new FoundLetter(i, "z")); 
               }
            }    
            if (wordLetters.indexOf("z") < 0){
               wrongGuesses++;     
            }               
         drawBody(foundLetters);
   
         }
      });
         
      letters.add(zButton); 
      
      frame.add(letters, BorderLayout.SOUTH);                                           
      hangmanDrawing = new JPanel(new BorderLayout());      
      drawBody(foundLetters);     
      frame.add(hangmanDrawing, BorderLayout.CENTER);          
      frame.setVisible(true);
   }
 
   // method that draws the letters and body parts depending on what the user does               
   public void drawBody(ArrayList <FoundLetter> letters){
      if(wrongGuesses == 0){
         HangmanStructure body = new HangmanStructure(this.wordLength, letters, level, hangmanPoints, gameNum);
         body.setBackground(Color.WHITE);
         hangmanDrawing.add(body, BorderLayout.CENTER);
         frame.setVisible(true);  
               
      } else if (wrongGuesses == 1 ){
        HangmanHead head = new HangmanHead(this.wordLength, letters, level, hangmanPoints, gameNum);
        head.setBackground(Color.WHITE);
        hangmanDrawing.add(head, BorderLayout.CENTER); 
        frame.setVisible(true);  
              
      } else if (wrongGuesses == 2 ){
         HangmanTorso torso = new HangmanTorso(this.wordLength, letters, level, hangmanPoints, gameNum);
         torso.setBackground(Color.WHITE);
         hangmanDrawing.add(torso, BorderLayout.CENTER); 
         frame.setVisible(true);
         
      } else if (wrongGuesses == 3 ){
         HangmanLeftArm arm = new HangmanLeftArm(this.wordLength, letters,  level, hangmanPoints, gameNum);
         arm.setBackground(Color.WHITE);
         hangmanDrawing.add(arm, BorderLayout.CENTER); 
         frame.setVisible(true);
         
      } else if (wrongGuesses == 4 ){
         HangmanRightArm arm = new HangmanRightArm(this.wordLength, letters,  level, hangmanPoints, gameNum);
         arm.setBackground(Color.WHITE);
         hangmanDrawing.add(arm, BorderLayout.CENTER); 
         frame.setVisible(true);
         
      } else if (wrongGuesses == 5 ){
         HangmanLeftLeg leg = new HangmanLeftLeg(this.wordLength,  letters, level, hangmanPoints, gameNum);
         leg.setBackground(Color.WHITE);
         hangmanDrawing.add(leg, BorderLayout.CENTER); 
         frame.setVisible(true);
         
      } else if (wrongGuesses == 6 ){
         HangmanRightLeg leg = new HangmanRightLeg(this.wordLength,  letters, level, hangmanPoints, gameNum);
         leg.setBackground(Color.WHITE);
         hangmanDrawing.add(leg, BorderLayout.CENTER); 
         frame.setVisible(true);
      }
   }                                     
}  