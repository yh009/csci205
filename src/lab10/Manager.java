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

enum DeptType {
    ENGINEERING, HR, ADMIN, STAFF, OTHER;
    //private String value;

    //DeptType(String value) {
    //this.value = value;
    //}
}

/**
 * Manager is a subclass of Employee. Exercise for lab10
 *
 * @author Yuxuan Huang
 */
public class Manager extends Employee {

    private DeptType dept;

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
        this.dept = DeptType.valueOf(deptName);
    }

    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, DeptType dept) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.dept = dept;
    }

    /**
     * Get the department type
     *
     * @return department type
     */
    public DeptType getDept() {
        return this.dept;
    }

    /**
     * Set the department type
     *
     * @param dept - the department type to be set
     */
    public void setDept(DeptType dept) {
        this.dept = dept;
    }

    /**
     * Get the value of deptName
     *
     * @return the value of deptName
     */
    public String getDeptName() {
        return dept.name();
    }

    /**
     * Set the value of deptName
     *
     * @param deptName new value of deptName
     */
    public void setDeptName(String deptName) {
        this.dept = DeptType.valueOf(deptName);
    }

    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.getDeptName(); //To change body of generated methods, choose Tools | Templates.
    }

}
