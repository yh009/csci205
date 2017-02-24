/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 23, 2017
* Time: 6:57:55 PM
*
* Project: csci205
* Package: lab11
* File: Contractor
* Description: The contractor class for lab11
*
* ****************************************
 */
package lab11;

import java.util.Date;

/**
 * The contractor class for lab11
 *
 * @author Yuxuan Huang
 */
public class Contractor implements Payable {

    private int id;
    private String firstName;
    private String lastName;
    private int ssNum;
    private double hourlyRate;

    /**
     * Explicit constructor for contractor
     *
     * @param id
     * @param firstName
     * @param lastname
     * @param ssNum
     * @param hourlyRate
     */
    public Contractor(int id, String firstName, String lastName, int ssNum,
                      double hourlyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Get the Id of the contractor
     *
     * @return - integer as ID
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the contractor
     *
     * @param id - the integer ID to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the First name of the contractor
     *
     * @return String of first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the contractor
     *
     * @param firstName - First name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the Last name of the contractor
     *
     * @return - Last name of the contractor as String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the contractor
     *
     * @param lastname last name of the contractor to be set
     */
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    /**
     * Get the SS number of the contractor
     *
     * @return SS number as integer
     */
    public int getSsNum() {
        return ssNum;
    }

    /**
     * Set the SS number
     *
     * @param ssNum - the SS number to be set
     */
    public void setSsNum(int ssNum) {
        this.ssNum = ssNum;
    }

    /**
     * Get the hourly rate of the contractor
     *
     * @return - the hourly rate as double
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Set the hourly rate
     *
     * @param hourlyRate - the hourly rate to be set
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Return a string representation of the Contractor
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        return String.format("Contractor: %d, %s, %s, %d, %.2f", this.getId(),
                             this.getLastName(), this.getFirstName(),
                             this.getSsNum(), this.getHourlyRate());
    }

    @Override
    public double calculatePay(double numHrs) {
        return numHrs * this.getHourlyRate();
    }

    @Override
    public String getPayTO() {
        return String.format("%s %s", this.getFirstName(), this.getLastName());
    }

    @Override
    public String getPayMemo() {
        Date date = new Date();
        return String.format("Contractor ID: %d, Pay Date: %s", this.getId(),
                             HRUtility.dateToStr(date));
    }

}
