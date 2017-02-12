/**
 * CSCI 205 - Software Engineering and Design Lab08
 *
 * This exercise is designed to teach the student about enumerated types, a
 * powerful class mechanism in Java, particularly when compared to enumerations
 * in other languages. The student steps through creating a CoinCollection
 * class, adding several capabilities throughout the lab exercise.
 *
 * @author Prof. Brian King 2014-fall, modified 2015-spring
 */
package lab08;

/**
 * A class to represent a collection of coins. The coins that can be stored are
 * determined by the enumerated type {@link Coin}.
 */
public class CoinCollection {

    /**
     * An array to store the individual values of each coin
     */
    //private static final double[] coinValues = {0.05, 0.10, 0.25};
    /**
     * array of integers contains actual count of each coin type in the
     * collection
     */
    private final int coinCount[];

    /**
     * Constructor to create a new empty coin collection. No coins are in the
     * collection when created.
     */
    public CoinCollection() {
        this.coinCount = new int[Coin.values().length];
    }

    /**
     * Add coins to the collection
     *
     * @param coinType - The type of coin to add
     * @param count - The number of coins to add of the specified type
     */
    public void addCoins(Coin coinType, int count) {
        this.coinCount[coinType.ordinal()] += count;
    }

    /**
     * Remove coins from the collection
     *
     * @param coinType - The type of coin to remove
     * @param count - the number of coins to remove
     * @return - the number of coins actually removed, ensuring that we can't
     * remove more coins than we have, preventing negative coin amounts.
     */
    public int removeCoins(Coin coinType, int count) {
        if (this.coinCount[coinType.ordinal()] >= count) {
            this.coinCount[coinType.ordinal()] -= count;
            return count;
        }
        else {
            int result = this.coinCount[coinType.ordinal()];
            this.coinCount[coinType.ordinal()] = 0;
            return result;
        }
    }

    /**
     * Return the count of the specified coin type in the collection
     *
     * @param coinType - the coin type to return the count for
     * @return the number of coins of the specified type
     */
    public int getCount(Coin coinType) {
        return this.coinCount[coinType.ordinal()];
    }

    /**
     * Compute the total amount of the collection
     *
     * @return the total amount of the collection in dollars
     */
    public double getTotal() {
        double total = 0.0;
        for (Coin coin : Coin.values()) {
            total += this.getCount(coin) * coin.getValue();
        }
        return total;
    }

    /**
     * Print readable status of the class
     *
     * @return formatted String output of class status
     */
    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Coin.values().length; i++) {
            result = result.append(String.format("%s:%d ", Coin.values()[i],
                                                 this.getCount(Coin.values()[i])));
        }
        result.append(String.format("= %.2f", this.getTotal()));
        return result.toString();
        /*return String.format("NICKEL:%d DIME:%d QUARTER:%d = $%.2f",
                             this.getCount(Coin.NICKEL),
                             this.getCount(Coin.DIME),
                             this.getCount(Coin.QUARTER),
                             this.getTotal());*/
    }

    /**
     * Main program - designed to test out the CoinCollection class
     */
    public static void main(String args[]) {
        CoinCollection myCoins = new CoinCollection();

        myCoins.addCoins(Coin.NICKEL, 5);
        myCoins.addCoins(Coin.DIME, 3);
        myCoins.addCoins(Coin.QUARTER, 7);

        System.out.println(myCoins);

        System.out.println("TEST: Removing 10 nickels, only 5 to remove ");
        System.out.printf("ACTUAL: Removed %d nickels%n",
                          myCoins.removeCoins(Coin.NICKEL, 10));

        System.out.println(myCoins);

        System.out.println("TEST: Removing 1 quarter");
        System.out.printf("RESPONSE: Removed %d quarter%n",
                          myCoins.removeCoins(Coin.QUARTER, 1));

        System.out.println(myCoins);
    }

}
