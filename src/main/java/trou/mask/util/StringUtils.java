package trou.mask.util;

public class StringUtils {
    public static String firstLetterToUpper(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
