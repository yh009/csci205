/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 18, 2017
* Time: 10:38:10 PM
*
* Project: csci205
* Package: lab10
* File: ManagerTest
* Description:
*
* ****************************************
 */
package lab10;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author mac
 */
public class ManagerTest extends TestCase {

    static final double EPSILON = 1.0E-12;
    private Manager mgr;
    private ArrayList<Employee> listOfEmps;

    public ManagerTest(String testName) {
        super(testName);
        listOfEmps = new ArrayList<Employee>();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mgr = new Manager(0, "Brian", "King", 123456,
                          HRUtility.strToDate("2010-08-20"),
                          60000, "HR");
        Employee emp1 = new Employee(1, "Smith", "Jane", 34354436,
                                     HRUtility.strToDate("1999-09-15"),
                                     100000);
        listOfEmps.add(emp1);
        Employee emp2 = new Employee(2, "Janes", "Meredith", 435342654,
                                     HRUtility.strToDate("2001-08-10"),
                                     100000);
        listOfEmps.add(emp2);
        Employee emp3 = new Employee(201, "Randolph", "Robert", 3254101,
                                     HRUtility.strToDate("1995-09-15"),
                                     100000);
        listOfEmps.add(emp3);
        Employee emp4 = new Employee(5, "Hendrix", "James", 2354645,
                                     HRUtility.strToDate("1990-09-15"),
                                     100000);
        listOfEmps.add(emp4);
        Employee emp5 = new Employee(6, "Adam", "Bob", 35467568,
                                     HRUtility.strToDate("1995-09-15"),
                                     100000);
        listOfEmps.add(emp5);
        Employee emp6 = new Employee(200, "Casey", "Dylan", 4657657,
                                     HRUtility.strToDate("1999-09-15"),
                                     100000);
        listOfEmps.add(emp6);

        mgr.addEmployee(emp1);
        mgr.addEmployee(emp2);
        mgr.addEmployee(emp3);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        listOfEmps.clear();
    }

    /**
     * Test of addEmployee method, of class Manager.
     */
    public void testAddEmployee() throws Exception {
        System.out.println("addEmployee");
        Employee emp4 = new Employee(5, "Hendrix", "James", 2354645,
                                     HRUtility.strToDate("1990-09-15"),
                                     100000);
        //Manager instance = null;
        assertTrue(mgr.getEmpList().size() == 3);
        assertTrue(mgr.getEmpList().get(0).equals(listOfEmps.get(0)));
        assertTrue(mgr.getEmpList().get(1).equals(listOfEmps.get(1)));
        assertTrue(mgr.getEmpList().get(2).equals(listOfEmps.get(2)));
        mgr.addEmployee(emp4);
        assertTrue(mgr.getEmpList().size() == 4);
        assertTrue(mgr.getEmpList().get(3).equals(listOfEmps.get(3)));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpList method, of class Manager.
     */
    public void testGetEmpList() throws ParseException {
        System.out.println("getEmpList");
        //Manager instance = null;
        List<Employee> expResult = new ArrayList<Employee>();
        Employee emp1 = new Employee(1, "Smith", "Jane", 34354436,
                                     HRUtility.strToDate("1999-09-15"),
                                     100000);
        expResult.add(emp1);
        Employee emp2 = new Employee(2, "Janes", "Meredith", 435342654,
                                     HRUtility.strToDate("2001-08-10"),
                                     100000);
        expResult.add(emp2);
        Employee emp3 = new Employee(201, "Randolph", "Robert", 3254101,
                                     HRUtility.strToDate("1995-09-15"),
                                     100000);
        expResult.add(emp3);
        List<Employee> result = mgr.getEmpList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeEmployee method, of class Manager.
     */
    public void testRemoveEmployee() throws Exception {
        System.out.println("removeEmployee");
        Employee emp3 = new Employee(201, "Randolph", "Robert", 3254101,
                                     HRUtility.strToDate("1995-09-15"),
                                     100000);
        assertTrue(mgr.getEmpList().size() == 3);
        assertTrue(mgr.getEmpList().get(0).equals(listOfEmps.get(0)));
        assertTrue(mgr.getEmpList().get(1).equals(listOfEmps.get(1)));
        assertTrue(mgr.getEmpList().get(2).equals(listOfEmps.get(2)));

        mgr.removeEmployee(emp3);
        assertTrue(mgr.getEmpList().size() == 2);
        assertTrue(mgr.getEmpList().get(0).equals(listOfEmps.get(0)));
        assertTrue(mgr.getEmpList().get(1).equals(listOfEmps.get(1)));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test(expected = ManagerException.class)
    public void testAddEmployeeException() throws ParseException {
        boolean wasThrown = false;
        Employee emp1 = new Employee(1, "Smith", "Jane", 34354436,
                                     HRUtility.strToDate("1999-09-15"),
                                     100000);
        try {
            mgr.addEmployee(emp1);
            //fail("Improper checking for low scanItem()");
        } catch (ManagerException expected) {

        }

    }

    @Test(expected = ManagerException.class)
    public void testRemoveEmployeeException() throws ParseException {
        boolean wasThrown = false;
        Employee emp6 = new Employee(200, "Casey", "Dylan", 4657657,
                                     HRUtility.strToDate("1999-09-15"),
                                     100000);
        try {
            mgr.removeEmployee(emp6);
            //fail("Improper checking for low scanItem()");
        } catch (ManagerException expected) {

        }
    }
}
