/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Feb 28, 2017
* Time: 10:19:23 PM
*
* Project: csci205
* Package: lab12
* File: ScanWebPage
* Description: lab12 exercise 1, scan a webpage
*
* ****************************************
 */
package lab12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Scan a web page
 *
 * @author Yuxuan Huang
 */
public class ScanWebPage {

    /**
     * Scan user specified web page and scan for specified tag, then print
     * results to specified file
     *
     * @param args
     * @throws IllegalArgumentException
     * @throws IOException
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws IOException {
        boolean notDone = true;

        while (notDone) {
            System.out.print("Enter the url to scan:");
            Scanner url = new Scanner(System.in);
            String address = url.next();
            try {
                Scanner in = ConnectURL(address);

                //URL pageLocation = new URL(address);
                //Scanner in = new Scanner(pageLocation.openStream());
                //System.out.print(
                //"Connection established. What tag do you want to scan for?");
                Scanner tag = new Scanner(System.in);
                String theTag = tag.next();
                Pattern p = Pattern.compile("<" + theTag + "[^>]*>");
                System.out.print("Enter the file name to store the results:");
                String fileName = tag.next();
                int counter = 0;
                PrintWriter out = new PrintWriter(fileName);
                String sMatch;
                while ((sMatch = in.findWithinHorizon(p, 0)) != null) {
                    counter++;
                    out.println(sMatch);

                }
                System.out.print(
                        "Wrote " + counter + " <" + theTag + "> tags to " + fileName + "\nGoodbye!\n");
                notDone = false;
                out.close();
            } catch (IllegalArgumentException illegalArg) {
                System.out.println("Invalid URL syntax! Please try again!");
            } catch (MalformedURLException exception) {
                System.out.println("Malfromed URL! Please try again!");

            } catch (FileNotFoundException pageNotFound) {
                System.out.println("Page Not Found! Please try again!");
            } catch (UnknownHostException unkownHost) {
                System.out.println("Unknown Host! Please try again!");
            }
        }

    }

    /**
     * Attempt to connect to the given URL
     *
     * @param address - the URL to be connected to
     * @return
     * @throws IOException
     */
    public static Scanner ConnectURL(String address) throws IOException {
        Scanner in = null;
        //try {
        URL pageLocation = new URL(address);
        in = new Scanner(pageLocation.openStream());
        System.out.print(
                "Connection established. What tag do you want to scan for?");

        //}
        return in;

    }

}
