/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 18, 2017
* Time: 6:24:39 PM
*
* Project: csci205
* Package: lab10
* File: EmployeeTest
* Description:
*
* ****************************************
 */
package lab11;

import java.text.ParseException;
import junit.framework.TestCase;

/**
 *
 * @author mac
 */
public class EmployeeTest extends TestCase {

    static final double EPSILON = 1.0E-12;
    private Employee emp;

    public EmployeeTest(String testName) {
        super(testName);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        emp = new Employee(1, "Smith", "Jane", 34354436,
                           HRUtility.strToDate("1999-09-15"),
                           208000);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        emp = null;
    }

    /**
     * Test of changeName method, of class Employee.
     */
    public void testChangeName() {
        System.out.println("changeName");
        assertTrue(emp.getFirstName().equals("Smith"));
        assertTrue(emp.getLastName().equals("Jane"));
        String first = "Ad";
        String last = "Bob";
        //Employee instance = null;
        emp.changeName(first, last);
        assertTrue(emp.getFirstName().equals("Ad"));
        assertTrue(emp.getLastName().equals("Bob"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public void testCalculatePay() {
        System.out.println("calculatePay");
        double pay1 = emp.calculatePay(30);
        assertEquals(pay1, 100.0 * 30.0, EPSILON);
        double pay2 = emp.calculatePay(50);
        assertEquals(pay2, 100.0 * 40.0 + 100.0 * 1.5 * 10.0,
                     EPSILON);
    }

    /**
     * Test of raiseSalary method, of class Employee.
     */
    public void testRaiseSalary() {
        System.out.println("raiseSalary");
        assertTrue(emp.getSalary() == 208000);
        double salaryAdj = 10000;
        //Employee instance = null;
        double expResult = 218000;
        double result = emp.raiseSalary(salaryAdj);
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Employee.
     */
    public void testEquals() throws ParseException {
        System.out.println("equals");
        //Object obj = null;
        Employee instance = new Employee(1, "Smith", "Jane", 34354436,
                                         HRUtility.strToDate("1999-09-15"),
                                         100000);;
        boolean expResult = true;
        boolean result = instance.equals(emp);
        assertEquals(expResult, result);
        instance = new Employee(1, "Smith", "Jane", 34354000,
                                HRUtility.strToDate("1999-09-15"),
                                100000);;
        expResult = false;
        result = instance.equals(emp);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
