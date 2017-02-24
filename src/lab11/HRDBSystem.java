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
* Description: Main program for testing Employee and Manager class lab11
*
* ****************************************
 */
package lab11;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import static lab11.HRUtility.displayEmployee;
import static lab11.HRUtility.displayEmployees;
import static lab11.HRUtility.displayManager;

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
    public static void main(String[] args) throws ParseException, ManagerException {
        ArrayList<Employee> empList = new ArrayList<Employee>(6);
        Manager mgr1 = new Manager(0, "Brian", "King", 123456,
                                   HRUtility.strToDate("2010-08-20"),
                                   60000, "HR");
        Manager mgr2 = new Manager(1, "Keith", "Buffinton", 1010101,
                                   HRUtility.strToDate("1997-01-15"),
                                   150000, "ENGINEERING");
        Employee emp1 = new Employee(15, "Smith", "Jane", 34354436,
                                     HRUtility.strToDate("1999-09-15"),
                                     50000);
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
        emp1.changeName("Yuxuan", "Huang");
        emp1.raiseSalary(10000);

        mgr1.addEmployee(emp1);
        mgr1.addEmployee(emp2);
        mgr1.addEmployee(emp3);
        mgr2.addEmployee(emp4);
        mgr2.addEmployee(emp5);
        mgr2.addEmployee(emp6);

        /*
        System.out.println(mgr1);
        System.out.println(mgr2);
        for (int i = 0; i < empList.size(); i++) {
            System.out.println(empList.get(i));
        }*/
        displayEmployee(mgr1);
        displayEmployee(mgr2);
        displayEmployees(empList);
        displayManager(mgr1);
        displayManager(mgr2);

        Contractor cont1 = new Contractor(73, "Builder", "Bob", 342942039, 30.00);
        System.out.println(cont1);
        Contractor cont2 = new Contractor(39, "Hunter", "Adam", 464567547, 40.00);
        System.out.println(cont2);

        //Create an account
        Account acc = new Account(2000.0);
        System.out.println(acc);

        // Test out a couple of payments, intentionally throwing an exception
        // with the second payment
        try {

            System.out.println("TEST: Printing a check to employee id: "
                               + empList.get(0).getEmpID());

            acc.processCheck(empList.get(0), 50); // 40 hrs + 10 hrs overtime

            System.out.println("TEST: Printing a check to contractor id: "
                               + cont1.getId());

            acc.processCheck(cont1, 35);

        } catch (InsufficientFundsException e) {

            System.out.println(e.getMessage());

        }

        // Verify that funds were debited from the account
        System.out.println(acc);

        //Ex 10
        System.out.println("*** Employees BEFORE SORT ***");

        HRUtility.displayEmployees(empList);

        System.out.println("*** Employees AFTER SORT_BY_LASTNAME ***");

        Employee.setSortType(SortType.SORT_BY_LASTNAME);

        Collections.sort(empList);

        HRUtility.displayEmployees(empList);

        System.out.println("*** Employees AFTER SORT_BY_ID ***");

        Employee.setSortType(SortType.SORT_BY_ID);

        Collections.sort(empList);

        HRUtility.displayEmployees(empList);

    }

}
