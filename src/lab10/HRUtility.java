/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 18, 2017
* Time: 8:22:51 PM
*
* Project: csci205
* Package: lab10
* File: HRUtility
* Description: This is a utility class for employee exercise
*
* ****************************************
 */
package lab10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * A utility class to help print out employees
 *
 * @author Yuxuan Huang
 */
public final class HRUtility {

    private static SimpleDateFormat empDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd");

    /**
     * Print a single employee
     *
     * @param emp the employee to be printed
     */
    public static void displayEmployee(Employee emp) {
        if (emp instanceof Manager) {
            System.out.printf("%3d: %s %s [MANAGER]\n", emp.getEmpID(),
                              emp.getFirstName(), emp.getLastName());

        }
        else {
            System.out.printf("%3d: %s %s\n", emp.getEmpID(),
                              emp.getFirstName(), emp.getLastName());

        }
    }

    /**
     * Print a list of employees
     *
     * @param listOfEmps the list of employees to be printed
     */
    public static void displayEmployees(List<Employee> listOfEmps) {
        for (int i = 0; i < listOfEmps.size(); i++) {
            displayEmployee(listOfEmps.get(i));
        }
    }

    /**
     * Helper method to parse a date string into a date object. This is really
     * here just to show how to deal with an exception that may be thrown in a
     * method.
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    public static Date strToDate(String sDate) throws ParseException {
        return empDateFormat.parse(sDate);
    }

    /**
     * Helper method to parse a date object into a string
     *
     * @param date - the value of date
     */
    public static String dateToStr(Date date) {
        String sDate = empDateFormat.format(date);
        return sDate;
    }

    public static void displayManager(Manager mgr) {
        System.out.printf("Manager:    %s %s\n", mgr.getFirstName(),
                          mgr.getLastName());
        System.out.printf("Department: %s\n", mgr.getDeptName());
        System.out.printf("# Employees:%d\n", mgr.getEmpList().size());
        displayEmployees(mgr.getEmpList());
    }

}
