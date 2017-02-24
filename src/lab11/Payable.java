/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 23, 2017
* Time: 2:38:57 PM
*
* Project: csci205
* Package: lab11
* File: Payable
* Description: The interface allow accounting to gather
* information for writing checks to employees and contractors
*
* ****************************************
 */
package lab11;

/**
 * Allow accounting to gather information for writing checks to employees and
 * contractors
 *
 * @author Yuxuan Huang
 */
public interface Payable {

    /**
     * Calculate the amount of money should be paid
     *
     * @param numHrs - number of hours to pay for
     * @return - total amount to be paid
     */
    double calculatePay(double numHrs);

    /**
     * Return who should be paid to
     *
     * @return - string indicating who to paid to
     */
    String getPayTO();

    /**
     * Fill the memo field of the check
     *
     * @return - string of memo
     */
    String getPayMemo();
}
