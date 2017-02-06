/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 4, 2017
* Time: 8:45:54 PM
*
* Project: csci205
* Package: lab06
* File: CashRegister
* Description: This class functions as a cash register. A practice for lab6
*
* ****************************************
 */
package lab06;

/**
 *
 * @author mac
 */
public class CashRegister {

    /**
     * The name of the cash drawer
     */
    private String sName;

    /**
     * The amount of cash in the drawer
     */
    private double cashInDrawer;

    /**
     * Are we currently in a transaction
     */
    private boolean isInTransaction;

    /**
     * The total amount of the transaction
     */
    private double transTotal;

    /**
     * The total numbers of items purchased in this transaction so far
     */
    private int numItemsInTrans = 0;

    /**
     * The total amount of money collected toward the transaction
     */
    private double amountPaid;

    /**
     * Initialize a default, empty cash register
     */
    public CashRegister() {
        this.cashInDrawer = 0;
        this.isInTransaction = false;
        this.numItemsInTrans = 0;
        this.transTotal = 0;
        this.amountPaid = 0;
        this.sName = "Default";
    }

    /**
     * Initialize an empty cash register with a specified name
     *
     * @param sName - the name of the register
     */
    public CashRegister(String sName) {
        this();
        this.sName = sName;
    }

    /**
     * Initialize the amount of cash to be placed in drawer
     *
     * @param initCash - the amount of cash to be placed in drawer
     */
    public void startDay(double initCash) {
        this.cashInDrawer = initCash;
    }

    /**
     * Return amount of cash in the drawer and empty out the drawer
     *
     * @return the amount of cash in the drawer
     */
    public double finishDay() {
        double result = this.cashInDrawer;
        this.cashInDrawer = 0;
        return result;
    }

    /**
     * Determine if a new transaction can happen
     *
     * @return true/false if the register is ready for new transaction
     */
    public boolean startTransaction() {
        if (this.isInTransaction() == false && this.cashInDrawer > 0.0) {
            this.isInTransaction = true;

            return true;
        }
        else {
            return false;
        }
        //return this.isInTransaction() == false && this.cashInDrawer > 0;
    }

    /**
     * Determine if a transaction is ready to be closed, finish the transaction
     * if so
     *
     * @return true/false if the transaction can be closed
     */
    public boolean finishTransaction() {
        if (this.isInTransaction() == true && this.getAmountOwed() == 0.0) {
            this.isInTransaction = false;

            this.amountPaid = 0;
            this.numItemsInTrans = 0;
            this.transTotal = 0;
            return true;
        }
        else {
            return false;
        }
        //return this.isInTransaction() == true && this.getAmountOwed() == 0;
    }

    /**
     * Scan item and add the amount to transaction total
     *
     * @param itemAmount - the amount of the item being scanned
     */
    public void scanItem(double itemAmount) {
        this.transTotal += itemAmount;
        this.numItemsInTrans++;
    }

    /**
     * Get the total amount of the transaction
     *
     * @return the total amount of the transaction
     */
    public double getTransactionTotal() {
        return this.transTotal;
    }

    /**
     * Get the total number of items of the transaction
     *
     * @return total number of items of the transaction
     */
    public int getNumItemsInTrans() {
        return this.numItemsInTrans;
    }

    /**
     * Get the amount paid for the transaction
     *
     * @return amount paid for the transaction
     */
    public double getAmountPaid() {
        return this.amountPaid;
    }

    /**
     * Get the name of the cash register
     *
     * @return name of the cash register
     */
    public String getName() {
        return this.sName;
    }

    /**
     * Return whether the cash register is in the middle of a transaction
     *
     * @return boolean whether the cash register is in the middle of a
     * transaction
     */
    public boolean isInTransaction() {
        return this.isInTransaction;
    }

    /**
     * Get the amount still owed for the transaction
     *
     * @return amount still owed for the transaction
     */
    public double getAmountOwed() {
        return this.getTransactionTotal() - this.getAmountPaid();
    }

    /**
     * Set the name of the register(default: default)
     *
     * @param name - new name of the register
     */
    public void setName(String name) {
        this.sName = name;
    }

    /**
     * Collect payment to the cash register, return change if needed
     *
     * @param paid - amount paid by customer
     * @return current balance, positive if overpaid, negative if customer still
     * owe
     */
    public double collectPayment(double paid) {
        this.amountPaid += paid;
        this.cashInDrawer += paid;
        double result = this.getAmountPaid() - this.getTransactionTotal();
        if (result > 0.0) {
            this.cashInDrawer -= result;
            this.amountPaid -= result;
        }
        return result;
        //}
    }

    /**
     * Return the string representation of the cash register status
     *
     * @return string representation of the cash register status
     */
    @Override
    public String toString() {
        if (this.isInTransaction() == false) {
            return String.format("%s: drawer: $%.2f NOT IN TRANSACTION",
                                 this.getName(), this.cashInDrawer);
            //System.out.println(" NOT IN TRANSACTION");
        }
        else {
            return String.format(
                    "%s: drawer: $%.2f CURRENT TRANS: #items: %d, total sale: $%.2f,"
                    + " amount paid: $%.2f", this.getName(), this.cashInDrawer,
                    this.getNumItemsInTrans(),
                    this.getTransactionTotal(), this.getAmountPaid());
        }
    }

}
