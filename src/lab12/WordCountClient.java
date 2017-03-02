/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 1, 2017
* Time: 2:24:18 AM
*
* Project: csci205
* Package: lab12
* File: WordCountClient
* Description: A GUI for WordCount
*
* ****************************************
 */
package lab12;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * The GUI for WordCount
 *
 * @author Yuxuan Huang
 */
public class WordCountClient {

    /**
     * Run the GUI
     *
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {

        while (true) {
            try {
                WordCount myFile;
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Select File");
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                    myFile = new WordCount(fc.getSelectedFile());

                    myFile.doIt();
                    Object[] options = {"No", "Yes"};
                    int n = JOptionPane.showOptionDialog(null, String.format(
                                                         "%s\nTry again?",
                                                         myFile),
                                                         "WordCount Results",
                                                         JOptionPane.YES_NO_OPTION,
                                                         JOptionPane.DEFAULT_OPTION,
                                                         null,
                                                         options, options[1]);
                    if (n == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Goodbye!");

                        break;

                    }
                }

                else {
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;
                }

            } catch (FileNotFoundException noSuchFile) {
                //JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null,
                                              "File Not Found! Try Again",
                                              "File Not Found",
                                              JOptionPane.ERROR_MESSAGE);

            } catch (IOException ioexception) {
                JOptionPane.showMessageDialog(null, "IO Exception",
                                              "ERROR",
                                              JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }
}
