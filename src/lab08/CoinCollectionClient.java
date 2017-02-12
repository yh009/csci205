/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 9, 2017
* Time: 10:53:51 PM
*
* Project: csci205
* Package: lab08
* File: CoinCollectionClient
* Description: A simple GUI for CoinCollection
*
* ****************************************
 */
package lab08;

import javax.swing.JOptionPane;

/**
 * This class is a simple GUI for CoinCollection class
 *
 * @author Yuxuan Huang
 */
public class CoinCollectionClient {

    /**
     * Run the GUI
     *
     * @param args
     */
    public static void main(String args[]) {
        CoinCollection myCoins = new CoinCollection();

        //Initialize the coin collection with some coins
        myCoins.addCoins(Coin.NICKEL, 5);
        myCoins.addCoins(Coin.DIME, 3);
        myCoins.addCoins(Coin.QUARTER, 7);

        while (true) {
            StringBuilder stringOne = new StringBuilder();
            for (int i = 0; i < Coin.values().length; i++) {
                stringOne = stringOne.append(String.format("%s:%d\n",
                                                           Coin.values()[i],
                                                           myCoins.getCount(
                                                                   Coin.values()[i])));
            }
            stringOne.append(String.format("TOTAL = %.2f\nSelect your action:",
                                           myCoins.getTotal()));
            int n = JOptionPane.showOptionDialog(null, /*String.format(
                                                 "NICKEL:%d\nDIME:%d\nQUARTER:%d\nTOTAL = $%.2f\nSelect your action:",
                                                 myCoins.getCount(Coin.NICKEL),
                                                 myCoins.getCount(Coin.DIME),
                                                 myCoins.getCount(Coin.QUARTER),
                                                 myCoins.getTotal()),*/
                                                 stringOne.toString(),
                                                 "Add or remove?",
                                                 JOptionPane.YES_NO_CANCEL_OPTION,
                                                 JOptionPane.QUESTION_MESSAGE,
                                                 null, AddRemoveChoices.values(),
                                                 null);

            if (n == JOptionPane.CANCEL_OPTION || n == JOptionPane.NO_OPTION) {

                Coin result
                     = (Coin) JOptionPane.showInputDialog(null,
                                                          "Select coin type:",
                                                          "Coin Selection",
                                                          JOptionPane.QUESTION_MESSAGE,
                                                          null, Coin.values(),
                                                          null);
                if (result == null) {
                    JOptionPane.showMessageDialog(null, /*String.format(
                                                  "You have:\nNICKEL:%d\nDIME:%d\nQUARTER:%d\nTOTAL = $%.2f\n\nGoodbye!",
                                                  myCoins.getCount(Coin.NICKEL),
                                                  myCoins.getCount(Coin.DIME),
                                                  myCoins.getCount(Coin.QUARTER),
                                                  myCoins.getTotal()),*/
                                                  stringBuild(myCoins),
                                                  "Goodbye!",
                                                  JOptionPane.PLAIN_MESSAGE);
                    break;
                }
                else {
                    if (n == JOptionPane.CANCEL_OPTION) {
                        String sNum = JOptionPane.showInputDialog(null,
                                                                  "How many do you want to add?",
                                                                  "Add coins",
                                                                  JOptionPane.QUESTION_MESSAGE);
                        if (sNum == null) {
                            JOptionPane.showMessageDialog(null, /*String.format(
                                                          "You have:\nNICKEL:%d\nDIME:%d\nQUARTER:%d\nTOTAL = $%.2f\n\nGoodbye!",
                                                          myCoins.getCount(
                                                                  Coin.NICKEL),
                                                          myCoins.getCount(
                                                                  Coin.DIME),
                                                          myCoins.getCount(
                                                                  Coin.QUARTER),
                                                          myCoins.getTotal()),*/
                                                          stringBuild(myCoins),
                                                          "Goodbye!",
                                                          JOptionPane.PLAIN_MESSAGE);
                            break;
                        }
                        else {
                            int num = Integer.parseInt(sNum);
                            myCoins.addCoins(result, num);
                        }
                    }
                    else {
                        String sNum = JOptionPane.showInputDialog(null,
                                                                  String.format(
                                                                          "How many do you want to remove? Max = %d",
                                                                          myCoins.getCount(
                                                                                  result)),
                                                                  "Remove coins",
                                                                  JOptionPane.QUESTION_MESSAGE);
                        if (sNum == null) {
                            JOptionPane.showMessageDialog(null, /*String.format(
                                                          "You have:\nNICKEL:%d\nDIME:%d\nQUARTER:%d\nTOTAL = $%.2f\n\nGoodbye!",
                                                          myCoins.getCount(
                                                                  Coin.NICKEL),
                                                          myCoins.getCount(
                                                                  Coin.DIME),
                                                          myCoins.getCount(
                                                                  Coin.QUARTER),
                                                          myCoins.getTotal()),*/
                                                          stringBuild(myCoins),
                                                          "Goodbye!",
                                                          JOptionPane.PLAIN_MESSAGE);
                            break;
                        }
                        else {
                            int num = Integer.parseInt(sNum);
                            myCoins.removeCoins(result, num);
                        }
                    }
                }

            }
            else {
                JOptionPane.showMessageDialog(null, /*String.format(
                                              "You have:\nNICKEL:%d\nDIME:%d\nQUARTER:%d\nTOTAL = $%.2f\n\nGoodbye!",
                                              myCoins.getCount(Coin.NICKEL),
                                              myCoins.getCount(Coin.DIME),
                                              myCoins.getCount(Coin.QUARTER),
                                              myCoins.getTotal()),*/
                                              stringBuild(myCoins),
                                              "Goodbye!",
                                              JOptionPane.PLAIN_MESSAGE);
                break;
            }

        }

    }

    public static String stringBuild(CoinCollection c) {
        StringBuilder myString = new StringBuilder();
        myString = myString.append("You have:\n");
        for (int i = 0; i < Coin.values().length; i++) {
            myString = myString.append(String.format("%s:%d\n",
                                                     Coin.values()[i],
                                                     c.getCount(
                                                             Coin.values()[i])));
        }
        myString.append(String.format(
                "TOTAL = %.2f\nGoodbye!",
                c.getTotal()));
        return myString.toString();
    }

}
