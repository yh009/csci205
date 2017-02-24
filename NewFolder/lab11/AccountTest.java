/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 23, 2017
* Time: 8:45:55 PM
*
* Project: csci205
* Package: lab11
* File: AccountTest
* Description:
*
* ****************************************
 */
package lab11;

import junit.framework.TestCase;

/**
 *
 * @author mac
 */
public class AccountTest extends TestCase {

    static final double EPSILON = 1.0E-12;
    private Account acc;
    private Employee emp;

    public AccountTest(String testName) {
        super(testName);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        acc = new Account(2000);
        emp = new Employee(1, "Smith", "Jane", 34354436,
                           HRUtility.strToDate("1999-09-15"),
                           100000);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        acc = null;
        emp = null;
    }

    /**
     * Test of credit method, of class Account.
     */
    public void testCredit() {
        System.out.println("credit");
        double amount = 0.0;
        acc.credit(500);
        assertEquals(2500.0, acc.getBalance(), EPSILON);
    }

    /**
     * Test of debit method, of class Account.
     *
     * @throws java.lang.Exception
     */
    public void testDebit() throws Exception {
        System.out.println("debit");
        double amount = 0.0;
        acc.debit(500);
        assertEquals(1500.0, acc.getBalance(), EPSILON);
    }

    /**
     * Test of processCheck method, of class Account.
     *
     * @throws java.lang.Exception
     */
    public void testProcessCheck() throws Exception {
        System.out.println("processCheck");
        Payable payee = emp;
        double hoursBilled = 20.0;
        acc.processCheck(payee, hoursBilled);
        assertEquals(2000 - payee.calculatePay(hoursBilled), acc.getBalance(),
                     EPSILON);

    }

    /**
     * Test of InsufficientFundsException throw properly
     *
     * @throws Exception
     */
    public void testProcessCheckInsufficientFundsException() throws Exception {
        boolean wasThrown = false;
        Payable payee = emp;
        double hoursBilled = 1000.0;
        try {
            acc.processCheck(payee, hoursBilled);
        } catch (InsufficientFundsException expected) {

        }

    }

}
