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
* This class contains methods for testing Java Guassian random number generation
*
* *****************************************/
package lab04;

import java.util.Arrays;
import java.util.Random;

/**
 * The TestGaussian class is used to test several different Gaussian RNG
 * exercises from lab04.
 *
 */
public class TestGaussian {
	/**
     * Compute the standard deviation of the numbers in the given array
     *
     * @param nums[] The array for computing sd
     * @return The standard deviation of all numbers from <code>nums</code>
     */
	public static double calcStDev(double nums []) {
		double mean = 0;
		double sd = 0;
		for (int i=0;i<nums.length;i++){
			mean=mean+nums[i];
		}
		mean=mean/nums.length;
		for (int i=0;i<nums.length;i++){
			sd=sd+(1.0/nums.length)*Math.pow(nums[i]-mean,2);			
		}
		sd=Math.sqrt(sd);
		return sd;
	}


	/**
     * Compute the standard deviation of the numbers in the given array using alt_stdev method
     *
     * @param nums[] The array for computing sd
     * @return The standard deviation of all numbers from <code>nums</code>
     */
	public static double calcAltStDev(double nums []) {
		double sum1 = 0.0;
		double sum2 = 0.0;
		for (int i=0;i<nums.length;i++){
			sum1 += nums[i];
			sum2 += nums[i]*nums[i];
		}
		double mean = sum1/nums.length;
		double var = (sum2*nums.length - sum1*sum1)/((double)nums.length*nums.length);
		double sd = Math.sqrt(var);
		return sd;

	}

	static final int MAX_NUMS = 5_000_000;

	/**
     * Main program to test out each standard deviation method
     */
	public static void main(String[] args){
		Random rand = new Random();
		double[] nums = new double[MAX_NUMS];

		for (int i=0;i<MAX_NUMS;i++){
			nums[i]=rand.nextGaussian();
		}
		System.out.println("Generating "+MAX_NUMS+" numbers...");

		long startTime = System.nanoTime();
		System.out.println("sd: "+calcStDev(nums));
		long elapsedTime_1 = System.nanoTime() - startTime;
		System.out.println("TIME: "+elapsedTime_1/1000.0+" usec");

		startTime = System.nanoTime();
		System.out.println("alt_sd: "+calcAltStDev(nums));
		long elapsedTime_2 = System.nanoTime() - startTime;
		System.out.println("TIME: "+elapsedTime_2/1000.0+" usec");

		double percent = ((double)elapsedTime_2/elapsedTime_1)*100.0;

		System.out.printf("alt_sd computed in %5.2f%% of the time of sd\n",percent);

	}
}





