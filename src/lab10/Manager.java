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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private List<Employee> empList = new ArrayList<Employee>();

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
     * @param empList
     */
    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, String deptName
    ) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.dept = DeptType.valueOf(deptName);
        //this.empList = empList;
    }

    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, DeptType dept
    ) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.dept = dept;
        //this.empList = empList;
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

    /**
     * Add an employee to the employee list
     *
     * @param emp - the employee to be added
     * @throws ManagerException
     */
    public void addEmployee(Employee emp) throws ManagerException {
        if (this.empList.contains(emp) == true) {
            throw new ManagerException(String.format(
                    "EMPLOYEE ALREADY IN LIST: %s %s", emp.getFirstName(),
                    emp.getLastName()));
        }
        else {
            this.empList.add(emp);
        }

    }

    /**
     * Get the employee list
     *
     * @return - the employee list
     */
    public List<Employee> getEmpList() {
        return this.empList;
    }

    /**
     * Remove an employee from the list
     *
     * @param emp - the employee to be removed
     * @throws ManagerException
     */
    public void removeEmployee(Employee emp) throws ManagerException {
        if (this.empList.contains(emp) == false) {
            throw new ManagerException(String.format(
                    "EMPLOYEE DOES NOT EXIST IN LIST: %s %s", emp.getFirstName(),
                    emp.getLastName()));
        }
        else {
            this.empList.remove(emp);
        }
    }

    /**
     * Return a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.getDeptName(); //To change body of generated methods, choose Tools | Templates.
    }

}
