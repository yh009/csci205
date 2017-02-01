/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: YUXUAN HUANG
* Date: Feb 1, 2017
* Time: 4:31:57 PM
*
* Project: csci205s
* Package: lab05
* File: Hello
* Description: This is a Hello World java classs
*
* ****************************************
 */
package lab05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Yuxuan Huang
 * @version 0.1
 */
public class Hello {

    private static final int NUM_INTS = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        greetUser();

        int[] x = getArrayOfRandomNums();
        System.out.println(Arrays.toString(x));
    }

    private static int[] getArrayOfRandomNums() {
        Random rand = new Random();
        int[] x = new int[NUM_INTS];
        for (int i = 0; i < NUM_INTS; i++) {
            x[i] = rand.nextInt(100);
        }
        return x;
    }

    private static void greetUser() {
        Scanner in = new Scanner(System.in);
        System.out.print("Hello. What is your name? ");
        String name = in.next();
        System.out.println(name + ", Becoming a good programmer takes practice.");
    }

}
