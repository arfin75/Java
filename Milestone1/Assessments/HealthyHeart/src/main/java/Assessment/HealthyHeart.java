/*
Name: Shah Arfin
Project Created: 05/02/2020
Project Updated 05/06/2020
*/



/* About the project:
 Make a simple calculator that asks the user for their age. Then calculate the
healthy heart rate range for that age, and display it.
Their maximum heart rate should be 220 - their age.
The target heart rate zone is the 50 - 85% of the maximum.
 * 
 */
package Assessment;

import java.util.Scanner;

/**
 *
 * @author shaharfin
 */
public class HealthyHeart {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); // scanner class for the user input

        System.out.println("What is your age?");
        int age = sc.nextInt(); // user age input
        int theHeartRate = 220 - age; // heart rate is 220 - age
        int ZoneMaximum = theHeartRate / 2; // half of maximum heart rate.
        double ZoneMinimum= theHeartRate * 0.85; // 85% of maximum heart rate taken in double data type

        //the maximum heart rate and the targer HR Zone:
        
        System.out.println("Your maximim heart rate should be " + theHeartRate + " per minute.");
        System.out.println("Your target HR Zone is " + ZoneMinimum + " - " + ZoneMaximum + " beats per min.");

    }
    
}
