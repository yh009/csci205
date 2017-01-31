/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
* Instructor: Prof Christopher Dancy
* Section: 1 pm
*
* Name: Yuxuan Huang
* Date: 01/30/2017
*
* Lab / Assignment: Lab04
*
* Description:
* This class contains the exercise 4, calculator exercise from lab04
*
* *****************************************/

package lab04;

import java.util.Scanner;


/**
 * This is a simple calculator which read in simple arithmetic expression in the form of
 * operand1 operator operand2
 * and output the result
 *
 */
public class Calculator {

	/**
     * Compute the standard deviation of the numbers in the given array
     *
     * @param nums[] The array for computing sd
     * @return The standard deviation of all numbers from <code>nums</code>
     */


	/**
     * Main program to handle the calculation
     */
	public static void main(String[] args){
		boolean check = true;
		boolean is_double = false;
		//boolean two_is_double = false;
		System.out.println("Welcome to the Calculator");
		System.out.println("Enter expressions with two numeric operands");
		System.out.println("and a single operator from +, -, *, /, % or ^");
		//int int_num_1, int_num_2;
		double num_1, num_2;
		while(check){
    		check = false;
    		is_double = false;
    		Scanner in = new Scanner(System.in);
    		System.out.printf("Enter a simple arithmetic expression with spacing: ");
    		//catching num 1
    		if (in.hasNextInt()==true){
    			num_1 = in.nextInt();
    		} else if (in.hasNextDouble()==true){
    			num_1 = in.nextDouble();
    			is_double = true;
    		} else {
    			System.out.println("ERROR: Connot parse operand 1");
    			check = true;
    			continue;
    		}

    		//catching operand
    		String operator = in.next();
    		char ope = operator.charAt(0);
    		if (ope != '+' && ope != '-' && ope != '*' && ope != '/' && ope != '%' && ope != '^'){
    			System.out.println("ERROR: "+ope+" is not a valid operator.");
    			check = true;
    			continue;
    		}

    		//catching num 2
    		if (in.hasNextInt()==true){
    			num_2 = in.nextInt();
    		} else if (in.hasNextDouble()==true){
    			num_2 = in.nextDouble();
    			is_double = true;
    		} else {
    			System.out.println("ERROR: Connot parse operand 2");
    			check = true;
    			continue;
    		}

    		switch (ope) {
    			case '+': if (is_double!=true){
					System.out.println("The sum is " + (int)(num_1+num_2));
    				break;
    			} else {
    				System.out.println("The sum is " + (num_1+num_2));
    				break;
    			}
    					  //System.out.println("The sum is " + (num_1+num_2));
    					  //break;
    			case '-': if (is_double!=true){
					System.out.println("The difference is " + (int)(num_1-num_2));
    				break;
    			} else {
    				System.out.println("The difference is " + (num_1-num_2));
    				break;
    			}
    					  //System.out.println("The difference is "+(num_1-num_2));
    					  //break;
    			case '*': if (is_double!=true){
					System.out.println("The product is " + (int)(num_1*num_2));
    				break;
    			} else {
    				System.out.println("The product is " + (num_1*num_2));
    				break;
    			}
    					  //System.out.println("The product is "+(num_1*num_2));
    					  //break;
    			case '/': if (is_double!=true){
					System.out.println("The quotient is " + (int)(num_1/num_2));
    				break;
    			} else {
    				System.out.println("The quotient is " + (num_1/num_2));
    				break;
    			}
    					  //System.out.println("The quotient is "+(num_1/num_2));
    					  //break;
    			case '%': if (is_double!=true){
					System.out.println("The reminder is " + (int)(num_1%num_2));
    				break;
    			} else {
    				System.out.println("The reminder is " + (num_1%num_2));
    				break;
    			}
    					  //System.out.println("The reminder is "+(num_1%num_2));
    					  //break;
    			case '^': if (is_double!=true){
					System.out.println("The power is " + Math.pow((long)num_1,num_2));
    				break;
    			} else {
    				System.out.println("The power is " + Math.pow(num_1,num_2));
    				break;
    			}
    					  //System.out.println("The power is "+Math.pow(num_1,num_2));
    					  //break;
    		}

    		System.out.print("Try again? [y | n]: ");
	        String result = in.next();
	        if (result.equals("y") || result.equals("Y")){
	        	check = true;
	        }
	    }
	    System.out.print("Goodbye!\n");
	}
}
