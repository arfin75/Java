/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scannertest;
import java.util.Scanner;  // Import the Scanner class
/**
 *
 * @author shaharfin
 */
public class ScannerDemo {

    public static void main(String[] args) {

        String name;
        int age;
        int numComputer;
        String hometown;
        
        
        // Declare the object and initialize with 
        // predefined standard input object 
        Scanner sc = new Scanner(System.in); // Scanner object

        System.out.println("Please enter your name: ");
        name = sc.nextLine();// String input 
        
        System.out.println("Please enter your age: ");
        age = sc.nextInt(); // Numerical data input 
        
        System.out.println("Please enter number of computeras: ");
        numComputer = sc.nextInt();
        sc.nextLine(); //To avoid the skip
        
        //
        System.out.println("Please enter your hometown: ");
        hometown = sc.nextLine();

        System.out.println("You said: ");
        System.out.println("Name: " + name);
        System.out.println("Age:" + age);
        System.out.println("hometown: " + hometown);

    }

}
