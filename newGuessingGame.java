//Aliza Eaton, Agastya Mamahit

//Date: 9/27/24

//Class: CS 145 In Person 8am

//Assignment: Lab #1 Guessing Game

/*Purpose: Allows the user to play a simple guessing game in which the program thinks up an
integer and allows the user to make guesses until the user gets it right. For each incorrect
guess, the program will tell the user the right answer is higher or lower.*/

//Citation: Deitel/Deitel Chapter 5
//W3 Schools
//https://codegym.cc/groups/posts/integer-division-java
//https://www.theserverside.com/video/Why-we-use-static-final-in-Java-for-constants
//https://www.geeksforgeeks.org/how-to-convert-char-to-string-in-java/
//https://www.w3schools.com/java/ref_string_charat.asp

//Notes: The code from last quarter for both of us was working and we were having trouble setting up 
//visual studio code so we are turning in same lab and working on getting VSC working.

//for taking user input 
import java.security.SecureRandom;
import java.util.Scanner;

//start class aeGuessingGame
public class newGuessingGame{
   //creates maximum for guessing game
   final static int maximum = 100;
   //prints introduction to game
   public static void intro() {
   System.out.println("This program allows you to play a guessing game.\n"
   + "I will think of a number between 1 and\n"
   + "100 and will allow you to guess until\n"
   + "you get it. For each guess, I will tell you\n"
   + "whether the right answer is higher or lower\n"
   +"than your guess.\n");
   } //end method intro
   
   //Play one round of the guessing game
   public static int playOneGame() {
      //allows method to take user input
      Scanner input = new Scanner(System.in);
      //randomNumbers object will produce secure random numbers
      SecureRandom randomNumbers = new SecureRandom();
      //produces a random number between 1-100 and stores it under rightNumber
      //adds one bc randoms numbers counts from 0
      int rightNumber = 1 + randomNumbers.nextInt(maximum);
      //initialize ints
      int guess = 0;
      int numGuesses = 0;
      
      System.out.println("\n\nI'm thinking of a number between 1 and 100...");
    
      //loop until user enters right number
      while (guess != rightNumber){
         //Ask user to guess a number between 1 and 100.
         System.out.print("Your guess?");
         guess = input.nextInt();
         
         //if user input > answer
         if (guess > rightNumber) {
            System.out.println("It's lower.");
         }
         //if user input < answer
         else if (guess < rightNumber) {
            System.out.println("It's higher.");
         }
         //add one to numGuesses for each loop
         numGuesses++;
     }
     //if user guesses number correctly
     System.out.println("You got it right in " + numGuesses + " guesses.");
     //returns number of guesses in this round
     return numGuesses;
   }//end method playOneGame
   
   //reports results to user
   public static void reportResults(int totalGames, int totalGuesses, int bestGame) {
      System.out.println("\n\nOverall results:");
      //reports # of games played
      System.out.println("\ttotal games = " + totalGames);
      //reports total guesses
      System.out.println("\ttotal guesses = " + totalGuesses);
      //# of guesses per game: divides int total guesses by int total games (returns double)
      double guessesPerGame = (double)totalGuesses / totalGames;
      //prints guesses/game rounded to 1 decimal place
      System.out.printf("\tguesses/game = %.1f%n", guessesPerGame);
      //reports fewest number of guesses used in any single game 
      System.out.println("\tbest game = " + bestGame);
   }//end method reportResults
   
   //main method
   public static void main (String[] args) {
      //allows program to take user input
      Scanner input = new Scanner(System.in);
      //initializes so playOneGame() will run one time without user input later in main()
      String playAnother = "Y";
      //initialize integers
      int numGames = 0;
      int totalGuesses = 0;
      int guessCount = 0;
      //initializing best guess to 1000 so however many guesses they guess will be lower
      int bestGuess = 1000;
      
      //runs intro()
      intro();
      
      //loops playOneGame() as long as user enters a string starting with Y or y
      while (playAnother.equals("Y") || playAnother.equals("y")){
      //runs method playOneGame() and saves its return value (numGuesses) to variable guessCount
      guessCount = playOneGame();
      System.out.print("Do you want to play again?");
      //finds best guess
      if (guessCount < bestGuess) {
      bestGuess = guessCount;
      }
      //takes user input and saves under play another
      playAnother = input.next();
      //changes play another as just the first character and saves it as a string
      playAnother = Character.toString(playAnother.charAt(0));
      //adds 1 to number of games each time a game is played
      numGames++;
      //adds guess count per a given gave to total guesses
      totalGuesses += guessCount;
      }
      //prints games results
      reportResults(numGames,totalGuesses, bestGuess);
   }//end method main
}//end class aeGuessingGame