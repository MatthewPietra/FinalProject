package util;

public class Util {
    public static String toTitleCase(String strIn) {
        String[] words = strIn.split(" ");

        String word1 = words[0].substring(0, 1).toUpperCase() + words[0].substring(1).toLowerCase();
        String word2 = words[1].substring(0, 1).toUpperCase() + words[1].substring(1).toLowerCase();

        return word1 + " " + word2;
    }
}
