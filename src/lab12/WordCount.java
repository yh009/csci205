/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 1, 2017
* Time: 1:47:24 AM
*
* Project: csci205
* Package: lab12
* File: WordCount
* Description: Lab12 exercise 2, implement wc linux commandline command in java
*
* ****************************************
 */
package lab12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * implement wc linux commandline command in java
 *
 * @author Yuxuan Huang
 */
public class WordCount {

    private File theFile;
    private String fileName;
    private int lineCount;
    private int wordCount;
    private int byteCount;

    /**
     * Construct a WordCount object which takes in a File object
     *
     * @param theFile - the File object to be counted
     */
    public WordCount(File theFile) {
        this.theFile = theFile;
        this.fileName = theFile.getName();
        this.lineCount = 0;
        this.wordCount = 0;
        this.byteCount = 0;
    }

    /**
     * Construct a WordCount object which takes in a filename
     *
     * @param filename - the file name of the file to be counted
     */
    public WordCount(String filename) {
        this.fileName = filename;
        this.lineCount = 0;
        this.wordCount = 0;
        this.byteCount = 0;
    }

    /**
     * Handle the counting
     *
     * @throws FileNotFoundException
     */
    public void doIt() throws FileNotFoundException {

        try {
            File inputFile = new File(this.fileName);
            this.byteCount = (int) inputFile.length();
            Scanner in = new Scanner(inputFile);
            String line;
            while (in.hasNextLine()) {
                line = in.nextLine();
                this.lineCount++;
                //byte[] Bytes = line.getBytes();
                //this.byteCount += Bytes.length;
                String[] words = line.split(" ");
                this.wordCount += words.length;

            }
            in.close();

        } catch (FileNotFoundException fileNotFound) {
            System.out.println("File Not Found!");

        }
        //in.close();

    }

    /**
     * Gives String back in the form that is completely identical to wc
     *
     * @return String in form identical to wc
     */
    @Override
    public String toString() {
        return String.format("%d %d %d %s", this.lineCount, this.wordCount,
                             this.byteCount, this.fileName);
    }
}
