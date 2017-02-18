/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 18, 2017
* Time: 1:22:58 PM
*
* Project: csci205
* Package: lab10
* File: Manager
* Description: Manager, as a subclass of employee
*
* ****************************************
 */
package lab10;

import java.util.Date;

/**
 * Manager is a subclass of Employee. Exercise for lab10
 *
 * @author Yuxuan Huang
 */
public class Manager extends Employee {

    /**
     * Explicit constructor to construct a new manager
     *
     * @param empID
     * @param firstName
     * @param lastName
     * @param ssNum
     * @param hireDate
     * @param salary
     * @param deptName
     */
    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, String deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.deptName = deptName;
    }
    private String deptName;

    /**
     * Get the value of deptName
     *
     * @return the value of deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Set the value of deptName
     *
     * @param deptName new value of deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.getDeptName(); //To change body of generated methods, choose Tools | Templates.
    }

}
