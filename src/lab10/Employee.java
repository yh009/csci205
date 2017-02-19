/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2016
 *
 * Name: Yuxuan Huang
 * Date: Feb 17, 2017
 * Time: 9:35pm
 *
 * Project: csci205
 * Package: lab10
 * File: Employee
 * Description:
 * A very basic abstraction for an employee in a simple HR system
 * ****************************************
 */
package lab10;

/**
 * A basic representation for an Employee.
 *
 * @author Brian King
 */
import java.util.Date;
import java.util.HashSet;

/**
 * Employee - represents an employee in the database system
 *
 * @author brk009
 */
public class Employee {

    private int empID;
    private String firstName;
    private String lastName;
    private int ssNum;
    private Date hireDate;
    private double salary;

    private static HashSet<Integer> setOfIDs = new HashSet<Integer>();

    /**
     * Explicit construct to create new employee
     *
     * @param empID
     * @param firstName
     * @param lastName
     * @param ssNum
     * @param hireDate
     * @param salary
     */
    public Employee(int empID, String firstName, String lastName, int ssNum,
                    Date hireDate, double salary) {
        if (empID <= 0 || setOfIDs.contains(empID) == true) {
            this.empID = generateID();
            setOfIDs.add(this.empID);
        }
        else {
            this.empID = empID;
            setOfIDs.add(this.empID);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public int getEmpID() {
        return empID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSsNum() {
        return ssNum;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * Change the name of the employee
     *
     * @param first - New first name
     * @param last - New last name
     */
    public void changeName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * Raise the salary by <code>salaryAdj</code> dollars.
     *
     * @param salaryAdj - amount to add to the current salary
     * @return the new salary
     */
    public double raiseSalary(double salaryAdj) {
        this.salary += salaryAdj;
        return this.salary;
    }

    /**
     * Compare whether two objects are equal
     *
     * @param obj the object to be compared with
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.ssNum != other.ssNum) {
            return false;
        }
        return true;
    }

    /**
     * Generating unique ID for each employee
     *
     * @return a unique ID as Integer
     */
    private static Integer generateID() {
        Integer ID = 1;
        while (true) {
            if (setOfIDs.contains(ID) == true) {
                ID++;
            }
            else {
                return ID;
            }
        }

    }

    /**
     * Return a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        String s = this.empID + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += "," + HRUtility.dateToStr(this.hireDate);
        s += String.format(",%.2f", this.salary);
        return s;
    }
}
