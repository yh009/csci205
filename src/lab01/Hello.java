/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
* Instructor: Prof Christopher Dancy
* Section: 1 pm
*
* Name: Yuxuan Huang
* Date: 01/19/2017
*
* Lab / Assignment: Lab01
*
* Description: A "Hello World" program in Java.
*
* *****************************************/

package lab01;
public class Hello
{
	public static void main( String[] args ){
		long startTime = System.nanoTime();
		System.out.println("Programming is not a spectator sport!");
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("Time to execute: " + estimatedTime + "ns");
		System.exit(0);
	}
}
