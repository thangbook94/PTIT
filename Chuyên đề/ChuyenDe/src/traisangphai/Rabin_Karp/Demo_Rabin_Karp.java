package traisangphai.Rabin_Karp;

public class Demo_Rabin_Karp {
    static final int BASE = 3;
    static final int PRIME = 517;
    static long valueCurrent;
    static int hashCurrent;
    static long valueOrigin;
    static int hashOrigin;
    static String pattern = "ABABCABAB";
    static String text = "ABABDABACDABABCABAB";

    public static void main(String[] args) {

        hashOrigin = initHashP(pattern);
        hashCurrent = initHashT(text.substring(0, pattern.length()));

        System.out.println(pattern + " : " + hashOrigin+":"+valueOrigin);
        System.out.println(text.substring(0, pattern.length()) + " : " + hashCurrent+":"+valueCurrent);


        for (int i = 1; i < text.length() - pattern.length() + 1; i++) {
            hash(text.charAt(i - 1), text.charAt(i + pattern.length() - 1));
            System.out.println(text.substring(i, i + pattern.length()) + " : " + hashCurrent);
        }
    }

    private static int initHashP(String init) {
        char[] temp = init.toCharArray();
        int mul = 1;
        for (int i = temp.length - 1; i >= 0; i--) {
            valueOrigin += temp[i] * mul;
            mul *= BASE;
        }
        hashOrigin = (int) (valueOrigin % PRIME);
        return hashOrigin;
    }

    private static int initHashT(String init) {
        char[] temp = init.toCharArray();
        int mul = 1;
        for (int i = temp.length - 1; i >= 0; i--) {
            valueCurrent += temp[i] * mul;
            mul *= BASE;
        }
        hashCurrent = (int) (valueCurrent % PRIME);
        return hashCurrent;
    }

    private static void hash(char old, char next) {
        valueCurrent = (int) ((valueCurrent - old * Math.pow(BASE, pattern.length()-1)) * BASE + next);
        hashCurrent = (int) (valueCurrent % PRIME);
    }
}
