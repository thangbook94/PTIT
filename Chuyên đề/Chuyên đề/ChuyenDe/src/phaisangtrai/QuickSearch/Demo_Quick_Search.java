package phaisangtrai.QuickSearch;

public class Demo_Quick_Search {

    public static void main(String[] args) {
        char[] x = "AAA".toCharArray();
        char[] y = "AAAAAAA".toCharArray();
        searchQuickSearch(x, y);
    }

    public static int[] preQsBc(char[] x) {
        int[] bc = new int[255];
        int m = x.length;
        for (int i = 0; i < 255; i++) {
            bc[i] = m + 1;
        }
        for (int i = 0; i < m; i++) {
            bc[(int) x[i]] = m - i;
        }
        return bc;
    }

    public static void searchQuickSearch(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        int[] preBc = preQsBc(x);
        System.out.println();
        int i = 0;
        while (i <= n - m) {
            if (cmp(x, y, i)) {
                System.out.println("index: " + i);
            }
            i = i + preBc[y[i + m]];
        }
    }

    public static boolean cmp(char[] x, char[] y, int y1) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[y1++]) {
                return false;
            }
        }
        return true;
    }
}
