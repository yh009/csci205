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
* This class contain all methods for the ArrayChallenge
*
* *****************************************/
package lab04;

import java.util.Arrays;
/**
 * The ArrayChallenge class is used to evaluate several different array
 * exercises from lab04.
 *
 */
public class ArrayChallenge 
{

	/**
     * Concatenate two arrays into one.
     *
     * @param a1 The first array to be concatenated
     * @param a2 The second array to be concatenated
     * @return The concatenated array from <code>a1</code> and <code>a2</code>
     */
	public static double[] concat(double[] a1,double[] a2) {
		double[] result = Arrays.copyOf(a1, a1.length+a2.length);
		for (int i=a1.length;i<a1.length+a2.length;i++) {
			result[i]=a2[i-a1.length];
		}
		return result;
	}

	/**
     * Reverse the given array recursively
     *
     * @param a The array to be reversed
     * @return The reversed array from <code>a</code>
     */
	public static double[] reverse(double[] a) {
		//double temp = 0.0;
		double[] head = new double[1];
		double[] tail = new double[1];
		//double[] temp;
		if (a.length == 1) {
			return a;
		} else if (a.length == 0) {
			return null;
		} else {
			head[0] = a[a.length-1];
			tail[0] = a[0];
			double[] new_a = Arrays.copyOfRange(a,1,a.length-1);
			return concat(head,concat(reverse(new_a),tail));
			
		}
	}


	/**
     * Compute the alternating sum of all elements in given array
     *
     * @param a The array to be tested
     * @return The alternating sum from <code>a</code>
     */
	public static double altSum(double[] a) {
		int alter = 0;
		double result = 0;
		for (int i=0;i<a.length;i++) {
			if (alter==0) {
				result = result + a[i];
				alter = 1;
			} else if (alter==1) {
				result = result - a[i];
				alter = 0;
			}

		}
		return result;
	}

	/**
     * Test whether or not the given array is in increasing order
     *
     * @param a The array to be tested
     * @return true/false array <code>a</code> is in increasing order
     */
	public static boolean isSorted(double[] a) {
		boolean result = false;
		for (int i=1;i<a.length;i++) {
			if (a[i]<a[i-1]) {
				return result;
			}
		}
		result = true;
		return result;
	}



	/**
     * Main program to test out each Array processing method
     */
	public static void main(String[] args) {
		double[] array1 = { 2, 3, 5, 7, 11 };
		double[] array2 = { 1, 4, 6, 8, 0 };
		System.out.printf("array1: %s\n", Arrays.toString(array1));
		System.out.printf("array2: %s\n", Arrays.toString(array2));
		System.out.printf("concat test: %s\n", Arrays.toString(concat(array1,array2)));
		System.out.printf("reverse test: %s\n", Arrays.toString(reverse(array1)));

		System.out.printf("altSum test: %.1f\n", altSum(concat(array1,array2)));
		System.out.printf("sorted test 1: %b\n", isSorted(array1));
        System.out.printf("sorted test 2: %b\n", isSorted(array2));
	}
}
