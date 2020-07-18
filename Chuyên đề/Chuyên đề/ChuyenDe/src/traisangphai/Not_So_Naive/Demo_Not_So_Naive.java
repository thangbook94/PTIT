package traisangphai.Not_So_Naive;

public class Demo_Not_So_Naive {

    public static void main(String[] args) {
        String pattern = "ABABCABAB";
        String text = "ABABDABACDABABCABAB";
        searchNsn(pattern, text);
    }

    static void searchNsn(String pattern, String text) {
        int shiftIfEqual = 1;
        int shiftIfNotEqual = 2;
        if (pattern.charAt(0) != pattern.charAt(1)) {
            shiftIfEqual = 2;
            shiftIfNotEqual = 1;
        }

        int i = 0;
        while (i <= text.length() - pattern.length()) {
            if (pattern.charAt(1) == text.charAt(i + 1)) {
                if (text.startsWith(pattern, i)) {
                    System.out.println("index : " + i);
                }
                i += shiftIfEqual;
            } else {
                i += shiftIfNotEqual;
            }
        }

    }
}
