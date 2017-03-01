/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 1, 2017
* Time: 1:42:32 PM
*
* Project: csci205
* Package: lab12
* File: ScanWebPageTest
* Description: Test of ScanWebPage class
*
* ****************************************
 */
package lab12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Scanner;
import junit.framework.TestCase;

/**
 * Test of ScanWebPage class
 *
 * @author Yuxuan Huang
 */
public class ScanWebPageTest extends TestCase {

    public ScanWebPageTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

    }

    /**
     * Test of ConnectURL method, of class ScanWebPage.Expect
     * IllegalArgumentException
     *
     * @throws java.io.IOException
     */
    public void testConnectURLIllegalArgumentException() throws IOException {
        System.out.println("ConnectURL");
        String address = "http:\\www.bucknell.edu";
        //Scanner expResult = null;
        try {
            Scanner result = ScanWebPage.ConnectURL(address);
        } catch (IllegalArgumentException expected) {
        }
    }

    /**
     * Test of ConnectURL method, of class ScanWebPage.Expect
     * MalformedURLException
     *
     * @throws IOException
     */
    public void testConnectMalformedURLException() throws IOException {
        System.out.println("ConnectURL");
        String address = "www.bucknell.edu";
        //Scanner expResult = null;
        try {
            Scanner result = ScanWebPage.ConnectURL(address);
        } catch (MalformedURLException expected) {
        }
    }

    /**
     * Test of ConnectURL method, of class ScanWebPage.Expect
     * FileNotFoundException
     *
     * @throws IOException
     */
    public void testConnectFileNotFoundException() throws IOException {
        System.out.println("ConnectURL");
        String address = "http://www.bucknell.edu/blah.html";
        //Scanner expResult = null;
        try {
            Scanner result = ScanWebPage.ConnectURL(address);
        } catch (FileNotFoundException expected) {
        }
    }

    /**
     * Test of ConnectURL method, of class ScanWebPage.Expect
     * UnknownHostException
     *
     * @throws IOException
     */
    public void testConnectUnknownHostException() throws IOException {
        System.out.println("ConnectURL");
        String address = "http://www.bucknell.ed";
        //Scanner expResult = null;
        try {
            Scanner result = ScanWebPage.ConnectURL(address);
        } catch (UnknownHostException expected) {
        }
    }

    /**
     * Test of ConnectURL method, of class ScanWebPage.Expect no exception
     *
     * @throws IOException
     */
    public void testConnect() throws IOException {
        System.out.println("ConnectURL");
        String address = "http://www.bucknell.edu";
        //Scanner expResult = null;
        try {
            Scanner result = ScanWebPage.ConnectURL(address);
        } catch (IOException unexpected) {
            fail("fail to establish connection");
        }
    }

}
