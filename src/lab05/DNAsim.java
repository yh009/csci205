/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: YUXUAN HUANG
* Date: Feb 1, 2017
* Time: 6:19:11 PM
*
* Project: csci205
* Package: lab05
* File: DNAsim
* Description: Generating a simulated DNA sequence for analyzsis
*
* ****************************************
 */
package lab05;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yh009
 */
public class DNAsim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Hello. Welcome to the DNA simulator. How long? ");
        int length = in.nextInt();
        System.out.print("What %GC-content? ");
        double gcContentPct = in.nextDouble();
        char[] dna = generateDNA(length, gcContentPct);
        printDNAStats(dna);
        printLongestRepeat(dna);

    }

    /**
     * Generate the genome of the desired length into an array of char values
     *
     * @param length the desired length of the genome
     * @param gcContentPct the desired percentage of GC-content
     * @return the array of character values representing the genome serie
     */
    public static char[] generateDNA(int length, double gcContentPct) {
        System.out.println("Generating...");
        Random rand = new Random();
        double[] x = new double[length];
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            x[i] = rand.nextDouble() * 100;
            if (x[i] < gcContentPct / 2) {
                result[i] = 'C';
            }
            else if (x[i] < gcContentPct) {
                result[i] = 'G';
            }
            else if (x[i] < (gcContentPct + (100 - gcContentPct) / 2)) {
                result[i] = 'A';
            }
            else {
                result[i] = 'T';
            }

        }
        System.out.println("Complete!");
        return result;

    }

    /**
     * Print the observed stats of the given DNA sequence
     *
     * @param dna the DNA sequence to be analyzed
     */
    public static void printDNAStats(char[] dna) {
        int A = 0;
        int C = 0;
        int G = 0;
        int T = 0;
        int length = dna.length;

        for (int i = 0; i < length; i++) {
            switch (dna[i]) {
                case 'A':
                    A++;
                    break;
                case 'C':
                    C++;
                    break;
                case 'G':
                    G++;
                    break;
                default:
                    T++;
                    break;
            }
        }
        double len = (double) length;
        System.out.println("Actual content of DNA sequence");
        System.out.printf("A: %d (%.1f%%)\n", A, A / len * 100.0);
        System.out.printf("C: %d (%.1f%%)\n", C, C / len * 100.0);
        System.out.printf("G: %d (%.1f%%)\n", G, G / len * 100.0);
        System.out.printf("T: %d (%.1f%%)\n", T, T / len * 100.0);

    }

    /**
     * Print the length and index position of the longest repeating nucleotide
     *
     * @param dna the DNA sequence to be analyzed
     */
    public static void printLongestRepeat(char[] dna) {
        int G_idx = 0;
        int CG_idx = 0;
        int G_max = 0;
        int G_ctr = 0;
        int CG_max = 0;
        int CG_ctr = 0;
        boolean CG_alt = false;
        int length = dna.length;

        for (int i = 0; i < length; i++) {
            if (dna[i] == 'G') {
                G_ctr++;
            }
            else {
                if (G_ctr > G_max) {
                    G_max = G_ctr;
                    G_idx = i - G_ctr;
                    G_ctr = 0;
                }
                else {
                    G_ctr = 0;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (CG_alt == false) {
                if (dna[i] == 'C' && dna[i + 1] == 'G') {
                    CG_ctr=CG_ctr+2;
                    CG_alt = true;
                }
                else {
                    if (CG_ctr > CG_max) {
                        CG_max = CG_ctr;
                        CG_idx = i - CG_ctr * 2;
                        CG_ctr = 0;
                    }
                    else {
                        CG_ctr = 0;
                    }
                }
            }
            else {
                i++;
                CG_alt = false;
            }
        }
        System.out.printf("Longest repeated nucleotide: %d G's [index: %d]\n",
                          G_max, G_idx);
        System.out.printf("Longest repeated dinucleotide: %d CG's [index: %d]\n",
                          CG_max, CG_idx);

    }

}
