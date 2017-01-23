/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Yuxuan Huang
 * Date: 01/22/2017
 *
 * Lab: Lab02, Exercise 2
 *
 * @author Brian King, 2017-Spring
 *
 * Description:
 * A simple program to ask the user for a radius r, and compute the 
 * volume of a sphere.
 * *****************************************
 */

package lab02;

import java.util.Scanner;

public class Sphere {
	 public static void main(String[] args) {
	 	System.out.println("Enter the radius of a sphere: ");
	 	Scanner in = new Scanner(System.in);
	 	double r = in.nextFloat();
	 	double v = (double)4.0/3.0*Math.PI*Math.pow(r,3.0);
	 	long rounded_v = Math.round(v);
	 	System.out.printf(
	 		"The volume is: %.2f\n"
	 		+"Rounded to nearest integer: %d\n",
	 		v,rounded_v);
	 }

}
