/*
Name: Shah Arfin
Date Created: 05/02/2020
Date Updated: 05/06/2020
 */

 /*
Write a program that asks the user for the name of their dog, and then generates 
a fake DNA background report on the pet dog.
It should assign a random percentage to 5 dog breeds (that should add up to 100%!) 
 */
package Assessment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author shaharfin
 */
public class DogGenetics {

    public static void breedMix(String[] breedMix) { //method to mix the dog breeds with the percentage.
        Random randomizer = new Random(); //creates new random number for percentage.

        int totalPerc = 0;
        int perc;

        // In order to add 5 diff breeds with random % adding up to 100, we need a loop.
        for (int i = 0; i < breedMix.length; i++) {
            if (i == breedMix.length - 1) { // so we can get all 100 percent
                perc = 100 - totalPerc; //100-0= 100.
            } else {
                perc = randomizer.nextInt(100 - totalPerc + 1);
                totalPerc += perc;
            }

            System.out.println(perc + "%" + breedMix[i]); //this will be added to all dog breeds during execution.
        }
    }

    public static void main(String[] args) { //main method

        System.out.println("What is your dog's name?");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        System.out.println("Well then, I have this highly reliable report on " + userInput + "'s prestrigious background right here.");
        System.out.println(userInput + " is: ");

        //These strigs will be added to the breedMiz method to generate the results.
        breedMix(new String[]{" Sharpe", " Doberman", " Shitsu", " Schnauzer", " Golden Retriever"});
        System.out.println("Wow, that's QUITE the dog! ");
        
    }

}