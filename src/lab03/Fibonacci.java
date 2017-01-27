/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 * Instructor: Prof Christopher Dancy
 * Section: 1 pm
 *
 * Name: Yuxuan Huang
 * Date: 01/27/2017
 *
 * Lab / Assignment: Lab03
 *
 * Description:
 * This function compute the nth Fibonacci number recursively and non-recursively
 *
 * *****************************************/
package lab03;

import java.util.Scanner;

/**
 * A simple class designed to give the user an opportunity to test a recursive
 * and non-recursive version of fibonacci
 *
 * Date: 2015-fall
 * @author BRK
 */
public class Fibonacci {

    /**
     * Compute the nth fibonacci number recursively
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int recFib(int n) {
        // TODO - Complete this method
        if (n==0)
            return 0;
        else if (n==1)
            return 1;
        else
            return recFib(n-1)+recFib(n-2);
    }

    /**
     * Compute the nth fibonacci number non-recursively, using a while loop.
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int nonRecFib(int n) {
        // TODO - Complete this method
        int a=1;
        int b=1;
        int c=0;
        //n=n-1;
        while (n>2) {
            c=a+b;
            a=b;
            b=c;
            //System.out.printf("%d\n",c);
            n=n-1;
        }
        return c;
    }

    /**
     * Main program to test both fibonacci methods
     */
    public static void main(String[] args) {
        System.out.println("What fibonacci number do you want?");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println("Recursive fib: " + recFib(n));
        System.out.println("Non-recursive fib: " + nonRecFib(n));
    }

}
