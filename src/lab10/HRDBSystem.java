/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 18, 2017
* Time: 2:08:44 PM
*
* Project: csci205
* Package: lab10
* File: HRDBSystem
* Description: Main program for testing Employee and Manager class
*
* ****************************************
 */
package lab10;

import java.util.Date;

/**
 * Main program for testing Employee and Manager class
 *
 * @author Yuxuan
 */
public class HRDBSystem {

    /**
     * The main function for testing
     *
     * @param args
     */
    public static void main(String[] args) {
        Employee emp = new Employee(0, "Brian", "King", 123456, new Date(),
                                    60000);
        Manager mgr = new Manager(1, "Keith", "Buffinton", 1010101, new Date(),
                                  150000, "ENGINEERING");

        System.out.println(emp);
        System.out.println(mgr);
    }

}
