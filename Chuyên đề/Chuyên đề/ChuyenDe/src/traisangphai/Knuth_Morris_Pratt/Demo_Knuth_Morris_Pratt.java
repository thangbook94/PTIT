package traisangphai.Knuth_Morris_Pratt;

public class Demo_Knuth_Morris_Pratt {

    public static void main(String[] args) {
        String pattern = "ABCABAB";
        String text = "ABABDABACDABABCABAB";
        searchKMP(pattern, text);
    }

    static void searchKMP(String pattern, String text) {
        int[] kmpNext = preKMP(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                System.out.println("index : " + (i - j));
                j = kmpNext[j - 1];
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = kmpNext[j - 1];
                else {
                    i++;
                }
            }
        }
    }

    static int[] preKMP(String pattern) {
        int[] kmpNext = new int[pattern.length()];
        int i = 0;
        int len = i;
        kmpNext[i] = len;
        i++;
        char[] X = pattern.toCharArray();
        while (i < kmpNext.length) {
            if (X[i] == X[len]) {
                len++;
                kmpNext[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = kmpNext[len - 1];
                } else {
                    kmpNext[len] = 0;
                    i++;
                }
            }
        }
        return kmpNext;
    }
}
