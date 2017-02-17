/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 15, 2017
* Time: 2:15:19 PM
*
* Project: csci205
* Package: lab09
* File: CashRegisterTest
* Description: Test file for CashRegister
*
* ****************************************
 */
package lab09;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author mac
 */
public class CashRegisterTest extends TestCase {

    static final double EPSILON = 1.0E-12;

    private CashRegister instance;

    public CashRegisterTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        instance = new CashRegister();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        instance = null;
    }

    /**
     * Test of getPurchaseCount method, of class CashRegister.
     */
    public void testGetPurchaseCount() {
        System.out.println("getPurchaseCount");
        //CashRegister instance = new CashRegister();

        // Test the initial state. It should have NO items
        assertEquals(0, instance.getPurchaseCount());

        //Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);

        int expResult = 2;
        int result = instance.getPurchaseCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfPurchases method, of class CashRegister.
     */
    public void testGetListOfPurchases() {
        System.out.println("getListOfPurchases");
        //CashRegister instance = new CashRegister();

        assertEquals(true, instance.getListOfPurchases().isEmpty());

        instance.scanItem(0.55);
        instance.scanItem(1.27);

        List<Double> expResult = Arrays.asList(0.55, 1.27);

        List<Double> result = instance.getListOfPurchases();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTransactionTotal method, of class CashRegister.
     */
    public void testGetTransactionTotal() {
        System.out.println("getTransactionTotal");
        //CashRegister instance = new CashRegister();
        assertEquals(0, instance.getTransactionTotal(), EPSILON);

        //Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        double expResult = 1.82;
        double result = instance.getTransactionTotal();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentCollected method, of class CashRegister.
     */
    public void testGetPaymentCollected() {
        System.out.println("getPaymentCollected");
        //CashRegister instance = new CashRegister();
        assertEquals(0, instance.getPaymentCollected(), EPSILON);

        instance.collectPayment(Money.TWENTY, 1);
        instance.collectPayment(Money.QUARTER, 2);
        double expResult = 20.50;
        double result = instance.getPaymentCollected();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of scanItem method, of class CashRegister.
     */
    /*public void testScanItem() {
        System.out.println("scanItem");
        double price = 0.0;
        CashRegister instance = new CashRegister();
        instance.scanItem(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of collectPayment method, of class CashRegister.
     */
    /*public void testCollectPayment() {
        System.out.println("collectPayment");
        Money moneyType = null;
        int unitCount = 0;
        CashRegister instance = new CashRegister();
        instance.collectPayment(moneyType, unitCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test for a collect money to be a bad unitCount and throw an
     * IllegalArgumentException
     */
    public void testCollectPaymentIllegalArgumentException() {
        //CashRegister instance = new CashRegister();
        boolean wasThrown = false;
        try {
            instance.collectPayment(Money.TWENTY, -1);
            fail("Improper checking for low scanItem()");
        } catch (IllegalArgumentException expected) {

        }

    }

    /**
     * Test of giveChange method, of class CashRegister.
     */
    public void testGiveChange() throws Exception {
        System.out.println("giveChange");
        //CashRegister instance = new CashRegister();
        assertEquals(instance.getTransactionTotal(),
                     instance.getPaymentCollected(), EPSILON);

        instance.scanItem(1.50);
        instance.collectPayment(Money.DOLLAR, 3);

        double expResult = 1.50;
        double result = instance.giveChange();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public void testGiveChangeChangeException() {
        //CashRegister instance = new CashRegister();
        boolean wasThrown = false;
        try {
            instance.scanItem(5.00);
            instance.giveChange();
            fail("Improper checking for low scanItem()");
        } catch (ChangeException expected) {

        }
    }

    /**
     * Test of main method, of class CashRegister.
     */
    /*public void testMain() {
        System.out.println("main");
        String[] args = null;
        CashRegister.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test for a scanned item to be a bad scan and throw an
     * IllegalArgumentException
     */
    public void testScanItemIllegalArgumentException() {
        //CashRegister instance = new CashRegister();
        boolean wasThrown = false;
        try {
            instance.scanItem(-0.5);
            fail("Improper checking for low scanItem()");
        } catch (IllegalArgumentException expected) {

        }
        try {
            //now, let's scan for a large value
            instance.scanItem(1.0E6);
            fail("Improper checking for high scanItem()");
        } catch (IllegalArgumentException expected) {

        }

    }

    /**
     * Test for equals method in Cash Register
     */
    public void testEquals() {
        System.out.println("testEquals");
        CashRegister instance2 = new CashRegister();
        assertTrue(instance.equals(instance2));

        instance.scanItem(1.00);
        instance.scanItem(0.50);
        instance.collectPayment(Money.QUARTER, 2);
        assertFalse(instance.equals(instance2));
        instance2.scanItem(1.00);
        instance2.scanItem(0.50);
        instance2.collectPayment(Money.QUARTER, 2);
        assertTrue(instance.equals(instance2));
    }

}
