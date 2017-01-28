/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 * Instructor: Prof Christopher Dancy
 * Section: 1 pm
 *
 * Name: Yuxuan Huang
 * Date: 01/27/2017
 *
 * Lab / Assignment: Lab03
 *
 * Description:
 * StringChallenge
 *
 * *****************************************/
package lab03;

/**
 * The StringChallenge class is used to evaluate several different string
 * exercises from lab03.
 *
 * @author brk009
 */
public class StringChallenge {

    /**
     * Count the number of vowels in a string.
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowels(String s) {
        // TODO - Finish this method!
        int theLength = s.length();
        int numVowels = 0;
        for (int i = 0;i < theLength; i++){
            String j = s.substring(i,i+1);
            if (j.equalsIgnoreCase("a") == true) {
                numVowels++;
            }
            else if (j.equalsIgnoreCase("e") == true) {
                numVowels++;
            }
            else if (j.equalsIgnoreCase("i") == true) {
                numVowels++;
                //System.out.print(theLength + "\n");
            }
            else if (j.equalsIgnoreCase("o") == true) {
                numVowels++;
            }
            else if (j.equalsIgnoreCase("u") == true) {
                numVowels++;
            }

        }
        
        return numVowels;
    }

    /**
     * Count the number of vowels in a string. This method uses recursion
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowelsRec(String s) {
        // TODO - Finish this method!
        if (s.length() == 0 || s == null) {
            return 0;
        } else if (s.substring(0,1).equalsIgnoreCase("a") == true || s.substring(0,1).equalsIgnoreCase("i") == true || s.substring(0,1).equalsIgnoreCase("e") == true || s.equalsIgnoreCase("u")) {
            return 1 + countVowelsRec(s.substring(1));
        } else {
            return countVowelsRec(s.substring(1));
        }
        
    }

    /**
     * determine if the given string is a palindrome. This method uses recursion
     *
     * @param s The string to test
     * @return Boolean if the string is palindrome <code>true</code> or <code>false</code>
     */
    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length()-1)) {
            return isPalindrome(s.substring(1,s.length()-1));
        }
        
        return false;
    }
    
    /**
     * swap the first and last character in the given string, only if the first and last characters are letters. Otherwise, return s unchanged. Case is preserved.
     *
     * @param s The string to swap
     * @return the string with the first and last characters swapped.
     */
    
    public static String swapFirstAndLastLetter(String s) {
        if (Character.isLetter(s.charAt(0)) == false || Character.isLetter(s.charAt(s.length()-1)) ==false) {
            return s;
        }
        else {
            if (Character.isUpperCase(s.charAt(0)) == true) {
                if (Character.isLowerCase(s.charAt(s.length()-1)) == true) {
                    return Character.toUpperCase(s.charAt(s.length()-1)) + s.substring(1,s.length()-1) + Character.toLowerCase(s.charAt(0));
                } else {
                    return s.charAt(s.length()-1) + s.substring(1,s.length()-1) + s.charAt(0);
                }
            } else {
                if (Character.isUpperCase(s.charAt(s.length()-1)) == true) {
                    return Character.toLowerCase(s.charAt(s.length()-1)) + s.substring(1,s.length()-1) + Character.toUpperCase(s.charAt(0));
                } else {
                    return s.charAt(s.length()-1) + s.substring(1,s.length()-1) + s.charAt(0);
                }
                    
              
            }
        }
                
            //return s.charAt(s.length()-1) + s.substring(1,s.length()-1) + s.charAt(0);

    }
    
    /**
     * Remove part of the string from the given string.
     *
     * @param s The string 
     * @param sRemove The string to be removed from <code>s</code>
     * @return the string with <code>sRemove</code> removed
     */
    public static String withoutString(String s, String sRemove) {
        return s.replace(sRemove, "");
    }
    
    /**
     * Sum all of the numbers that occur in the given string
     *
     * @param s The string for test
     * @return The sum of all numbers in <code>s</code>
     */
    
    public static int sumNumbersInString(String s) {
        int sum = 0;
        s=s.replaceAll("[\\D]"," ");
        String[] num = s.split(" ");
        for (int i=0;i<num.length;i++){
            try{
            sum+=Integer.parseInt(num[i]);
            }
            catch(Exception e) {
                
            }
        }
        return sum;
    }
    
    
    
    /**
     * Main program to test out each String processing method
     */
    public static void main(String[] args) {
        String sTest = "Mississippi River";
        System.out.printf("countVowels(\"%s\") = %d\n", sTest, countVowels(sTest));
        System.out.printf("countVowelsRec(\"%s\") = %d\n", sTest, countVowelsRec(sTest));
//
        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
        sTest = "amanapanama";
        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
//
        sTest = "Testing";
        System.out.printf("swapFirstAndLastLetter(\"%s\") = \"%s\"\n", sTest, swapFirstAndLastLetter(sTest));
        sTest = "Testing123";
        System.out.printf("swapFirstAndLastLetter(\"%s\") = \"%s\"\n", sTest, swapFirstAndLastLetter(sTest));
//
        sTest = "Testing Running Walking Jumping";
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "ing", withoutString(sTest, "ing"));
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "Sleep", withoutString(sTest, "Sleep"));
//
        sTest = "a1b2c3";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
        sTest = "aa12bb34cc56dd78";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
    }
}
