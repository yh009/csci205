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
package lab11;

/**
 * A basic representation for an Employee.
 *
 * @author Brian King
 */
import java.util.Date;
import java.util.HashSet;

enum SortType {

    SORT_BY_LASTNAME, SORT_BY_ID
}

/**
 * Employee - represents an employee in the database system
 *
 * @author brk009
 */
public class Employee implements Payable, Comparable<Employee> {

    private int empID;
    private String firstName;
    private String lastName;
    private int ssNum;
    private Date hireDate;
    private double salary;
    private static SortType sortType = SortType.SORT_BY_ID;

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

    public static void setSortType(SortType s) {
        Employee.sortType = s;
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
     * Compare this employee instance to another
     *
     * @param emp - the employee instance to be compared with
     * @return
     */
    @Override
    public int compareTo(Employee emp) {
        if (Employee.sortType == SortType.SORT_BY_ID) {
            if (this.getEmpID() < emp.getEmpID()) {
                return -1;
            }
            if (this.getEmpID() > emp.getEmpID()) {
                return 1;
            }
            return 0;

        }
        else {
            return this.getLastName().compareToIgnoreCase(emp.getLastName());
        }
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

    /**
     * Calculate total payment amount
     *
     * @param numHrs - number of hours works in a year
     * @return - total payment amount
     */
    @Override
    public double calculatePay(double numHrs) {

        double totalHrs = 40.0 * 52.0;
        double rate = this.salary / totalHrs;
        double totalPay;
        if (numHrs > 40.0) {
            totalPay = numHrs * rate + (numHrs - 40.0) * rate * 0.5;
            return totalPay;
        }
        else {
            totalPay = numHrs * rate;
            return totalPay;
        }

    }

    /**
     * Get the name of person to be paid
     *
     * @return - String name of person to be paid
     */
    @Override
    public String getPayTO() {
        return String.format("%s %s", this.getFirstName(), this.getLastName());
    }

    /**
     * Get the memo for paycheck
     *
     * @return - String memo for paycheck
     */
    @Override
    public String getPayMemo() {
        Date date = new Date();
        return String.format("Employee ID: %d, Pay Date: %s", this.getEmpID(),
                             HRUtility.dateToStr(date));

    }

}
