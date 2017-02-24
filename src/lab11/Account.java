/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 23, 2017
* Time: 8:13:34 PM
*
* Project: csci205
* Package: lab11
* File: Account
* Description:
*
* ****************************************
 */
package lab11;

/**
 * Checked exception representation any issues that might arise from Account
 * class
 *
 * @author Yuxuan Huang
 */
class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String format) {
        super(format);
    }

}

/**
 * Account class to test Payable
 *
 * @author Yuxuan Huang
 */
public class Account {

    /**
     * cash balance in the account
     */
    private double balance;

    /**
     * Create a new Account with initial balance
     *
     * @param initBalance - initial balance as double
     */
    public Account(double initBalance) {
        this.balance = initBalance;
    }

    /**
     * Get the current account balance
     *
     * @return current account balance as double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Add amount money to the balance
     *
     * @param amount - the amount to be added
     */
    public void credit(double amount) {
        this.balance += amount;
    }

    /**
     * Remove amount money from the balance, throw exception if not enough fund
     *
     * @param amount - the amount to be removed
     * @throws lab11.InsufficientFundsException
     */
    public void debit(double amount)
            throws InsufficientFundsException {
        if (this.getBalance() < amount) {
            throw new InsufficientFundsException(String.format(
                    "INSUFFICIENT FUNDS! Required: $%.2f, Available: $%.2f",
                    amount, this.getBalance()));
        }
        else {
            this.balance -= amount;
        }

    }

    /**
     * Print out a check
     *
     * @param payee - Payable object to be paid to
     * @param hoursBilled - hours worked
     * @throws InsufficientFundsException
     */
    public void processCheck(Payable payee, double hoursBilled) throws InsufficientFundsException {
        double amount = payee.calculatePay(hoursBilled);
        this.debit(amount);
        System.out.printf("Pay to: %s\nPay memo: %s\nPay amount: %.2f\n",
                          payee.getPayTO(), payee.getPayMemo(), amount);

    }

    @Override
    public String toString() {
        return String.format("Account Balance: %.2f", this.getBalance());
    }
}
