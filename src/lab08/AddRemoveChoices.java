/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 9, 2017
* Time: 11:05:20 PM
*
* Project: csci205
* Package: lab08
* File: AddRemoveChoices
* Description: A simple enumerated type to represent buttons in JOptionPane
*
* ****************************************
 */
package lab08;

/**
 * A simple enumerated type to represent buttons in JOptionPane
 *
 * @author Yuxuan Huang
 */
public enum AddRemoveChoices {

    DONE("Done"), REMOVE("Remove Coins"), ADD("Add Coins");

    private String label;

    AddRemoveChoices(String s) {
        this.label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}
