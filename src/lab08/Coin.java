/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 9, 2017
* Time: 9:45:48 PM
*
* Project: csci205
* Package: lab08
* File: Coin
* Description:A simple enumerated type to represent the different types of coins
*
* ****************************************
 */
package lab08;

/**
 * Coin - A simple enumerated type to represent the different types of coins
 *
 * @author Yuxuan Huang
 */
public enum Coin {
    PENNY(0.01), NICKEL(0.05), DIME(0.10), QUARTER(0.25), DOLLAR(1.00);

    private double value;

    Coin(double value) {
        this.value = value;
    }

    double getValue() {
        return this.value;
    }
}
