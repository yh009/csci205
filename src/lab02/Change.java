/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Yuxuan Huang
 * Date: 01/22/2017
 *
 * Lab: Lab02, Exercise 4
 *
 * Description:
 * This is a simple program to compute a proper amount of change given some
 * number of pennies.
 *
 * @author BRK 2012-fall, with slight modifications in 2015
 */

package lab02;

import java.util.Scanner;

public class Change {

    final static int PENNIES_PER_DOLLAR = 100;
    final static int PENNIES_PER_QUARTER = 25;
    final static int PENNIES_PER_DIME = 10;
    final static int PENNIES_PER_NIKCEL = 5;

    public static void main(String[] args) {
        boolean check = true;
        while(check){
            check = false;
            Scanner in = new Scanner(System.in);

            System.out.println("Enter the number of pennies: ");

            int pennies = in.nextInt();

            int total_pennies = pennies;

            int dollars = pennies / PENNIES_PER_DOLLAR;
            pennies %= PENNIES_PER_DOLLAR;

            // Compute number of quarters
            int quarters = pennies / PENNIES_PER_QUARTER;
            pennies %= PENNIES_PER_QUARTER;

            int dimes = pennies / PENNIES_PER_DIME;
            pennies %= PENNIES_PER_DIME;

            int nickels = pennies / PENNIES_PER_NIKCEL;
            pennies %= PENNIES_PER_NIKCEL;

            // Compute number of pennies leftover
            //pennies %= PENNIES_PER_QUARTER;

            // Output the results
            System.out.printf(
                "%4d pennies breaks down to:\n"
                +"%4d dollars  = $%.2f\n"
                +"%4d quarters = $%.2f\n"
                +"%4d dimes    = $%.2f\n"
                +"%4d nickels  = $%.2f\n"
                +"%4d pennies  = $%.2f\n",
                total_pennies,
                dollars, dollars * PENNIES_PER_DOLLAR / 100.0,
                quarters, quarters * PENNIES_PER_QUARTER / 100.0,
                dimes, dimes * PENNIES_PER_DIME / 100.0,
                nickels, nickels * PENNIES_PER_NIKCEL / 100.0,
                pennies, pennies / 100.0);

            System.out.print("Try again? [y | n]: ");
            String result = in.next();
            if (result.equals("y") || result.equals("Y")){
                check = true;
            }
                //"You have %d quarters yielding $%.2f with %d pennies left%n",
                //quarters, quarters * PENNIES_PER_QUARTER / 100.0, pennies);
        }
        System.out.print("Goodbye!\n");
    }
}
