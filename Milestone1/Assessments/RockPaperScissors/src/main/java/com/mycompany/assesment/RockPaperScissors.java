/*
 * Rock Paper Scissor
 * By: Shah Arfin
 * Date created: 5/02/2020
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assesment;

// to read user input and get random number
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author shaharfin
 */
public class RockPaperScissors {

    public static boolean playing(int userPlays) { // boolean type method
        
        if (userPlays == 1) {
            System.out.println("you may play again."); // 
            return true;

        } else {
            System.out.println("Thanks for playing.");
            return false;
        }

    }

    public static void main(String[] args) { //main method

        Scanner sc = new Scanner(System.in); // scanner class for user input
        Random randomizer = new Random(); // to generate random number for compInput

        boolean plays = true;

        while (plays) { // when boolean value is true

           // initalize all variables. These will keep count of the wins and ties.
            int ties = 0; 
            int userWins = 0;
            int computerWins = 0;

            System.out.println("How many rounds do you want to play?");
            int rounds = sc.nextInt(); // Player round input

            if (rounds <= 10) { // Player needs to enter between 1 -10, they play.
                for (int i = 0; i < rounds; i++) { // for loop to make the rounds go

                    System.out.println("choose 1 for rock, 2 for paper and 3 for scissors");
                    int userInput = sc.nextInt(); // Player enters choice

                    if (userInput > 3 || userInput < 1) { 
                        System.out.println("please try a number between 1 - 3.");
                        System.out.println("\nTry again");
                    
                    }

                    int computerInput = (randomizer.nextInt(3 - 1) + 1); // value passes to computer variable. (max-min)+min
                    System.out.println(computerInput);
                    
                    

                    // All the possiblilies written out for wins for user and comp and ties.
                    if (userInput == computerInput) {
                        System.out.println("you both chose: " + userInput);
                        System.out.println("Game is tie");
                        ties++; // both will get 1
                        
                    } else if (userInput == 1 && computerInput == 2) { // rock and paper
                        System.out.println("Computer Wins! you said Rock? Computer said paper. ");
                        computerWins++; // compWins value raise 1
                        
                    } else if (userInput == 2 && computerInput == 3) {// paper and scissor
                        System.out.println("Computer Wins! you said Paper? Computer said scisosr.");
                        computerWins++;
                        
                    } else if (userInput == 3 && computerInput == 2) {// scissor and paper
                        System.out.println("You Win! you said scissor? computer said paper.");
                        userWins++;
                        
                    } else if (userInput == 2 && computerInput == 1) {// paper and rock
                        System.out.println("you win! you said paper? Computer said rock.!");
                        userWins++;
                        
                    } else if (userInput == 1 && computerInput == 3) {//rock and scissor
                        System.out.println(" you win!you said rock, computer said scissor.");
                        userWins++;
                        
                    } else if (userInput == 3 && computerInput == 1) {//scissor and rock
                        System.out.println(" Computer Win! you said scissor, computer said rock.");
                        computerWins++;
                    }
                }

            } else {

                System.out.println("Error Number, Bye"); // user answers a diff number they exit.
                System.exit(0); // exists the game
            }

            if (userWins == computerWins) { // boyh equal
                System.out.println("\nYou both ties: " + ties);
                
            } else if (userWins > computerWins) {
                
                System.out.println("You are the over all Winner!");
                
            } else if (computerWins > userWins) {
                
                System.out.println("The computer is the over all Winner!");
            }

            /*// Display all the results.
            System.out.println("\nYou both Ttes: " + ties);
            System.out.println("Number of User Wins: " + userWins);
            System.out.println("Number of Computer Wins: " + computerWins);
            */

            System.out.println("\nDo you want to play again? Press 1 for yes and 2 for no!");
            int userPlays = sc.nextInt();
            plays = playing(userPlays);
        }
    }
}
