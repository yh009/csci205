/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 18, 2017
* Time: 2:08:44 PM
*
* Project: csci205
* Package: lab10
* File: HRDBSystem
* Description: Main program for testing Employee and Manager class
*
* ****************************************
 */
package lab10;

import java.text.ParseException;
import java.util.ArrayList;
import static lab10.HRUtility.displayEmployee;
import static lab10.HRUtility.displayEmployees;

/**
 * Main program for testing Employee and Manager class
 *
 * @author Yuxuan Hiang
 */
public class HRDBSystem {

    /**
     * The main function for testing
     *
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        ArrayList<Employee> empList = new ArrayList<Employee>(6);
        Manager mgr1 = new Manager(0, "Brian", "King", 123456,
                                   HRUtility.strToDate("2010-08-20"),
                                   60000, "ENGINEERING");
        Manager mgr2 = new Manager(1, "Keith", "Buffinton", 1010101,
                                   HRUtility.strToDate("1997-01-15"),
                                   150000, "ENGINEERING");
        Employee emp1 = new Employee(1, "Smith", "Jane", 34354436,
                                     HRUtility.strToDate("1999-09-15"),
                                     100000);
        empList.add(emp1);
        Employee emp2 = new Employee(2, "Janes", "Meredith", 435342654,
                                     HRUtility.strToDate("2001-08-10"),
                                     100000);
        empList.add(emp2);
        Employee emp3 = new Employee(201, "Randolph", "Robert", 3254101,
                                     HRUtility.strToDate("1995-09-15"),
                                     100000);
        empList.add(emp3);
        Employee emp4 = new Employee(5, "Hendrix", "James", 2354645,
                                     HRUtility.strToDate("1990-09-15"),
                                     100000);
        empList.add(emp4);
        Employee emp5 = new Employee(6, "Adam", "Bob", 35467568,
                                     HRUtility.strToDate("1995-09-15"),
                                     100000);
        empList.add(emp5);
        Employee emp6 = new Employee(200, "Casey", "Dylan", 4657657,
                                     HRUtility.strToDate("1999-09-15"),
                                     100000);
        empList.add(emp6);

        /*
        System.out.println(mgr1);
        System.out.println(mgr2);
        for (int i = 0; i < empList.size(); i++) {
            System.out.println(empList.get(i));
        }*/
        displayEmployee(mgr1);
        displayEmployee(mgr2);
        displayEmployees(empList);

    }

}
