package util;

public class Util {
    /**
     * Converts each word in a string to title case.
     * Title case means that the first letter of each word is capitalized,
     * while all other letters are converted to lowercase
     * @param strIn the input string containing two words separated by a single space
     * @return the input string converted to title case
     */
    public static String toTitleCase(String strIn) {
        String[] words = strIn.split(" ");

        String word1 = words[0].substring(0, 1).toUpperCase() + words[0].substring(1).toLowerCase();
        String word2 = words[1].substring(0, 1).toUpperCase() + words[1].substring(1).toLowerCase();

        return word1 + " " + word2;
    }
}
