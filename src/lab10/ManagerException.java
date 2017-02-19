/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 18, 2017
* Time: 9:53:01 PM
*
* Project: csci205
* Package: lab10
* File: ManagerException
* Description:
*
* ****************************************
 */
package lab10;

/**
 * Checked exception representation any issues that might arise from Manager
 * class
 *
 * @author Yuxuan Huang
 */
public class ManagerException extends Exception {

    public ManagerException(String message) {
        super(message);
    }

}
