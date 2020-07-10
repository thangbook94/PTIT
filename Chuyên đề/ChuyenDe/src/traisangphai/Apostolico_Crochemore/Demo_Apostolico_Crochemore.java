package traisangphai.Apostolico_Crochemore;

public class Demo_Apostolico_Crochemore {
    public static void main(String[] args) {
        char[] pat = "ABCABAB".toCharArray();
        char[] txt = "ABABDABACDABABCABAB".toCharArray();
        AC(pat, txt);
    }

    static void AC(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        int i, j, k, ell;
        int[] kmpNext = new int[265];
        preKmp(x, m, kmpNext);

        for (ell = 1; x[ell - 1] == x[ell]; ) ell++;
        if (ell == m) ell = 0;


        i = ell;
        j = k = 0;
        while (j <= n - m) {
            while (i < m && x[i] == y[i + j])
                ++i;
            if (i >= m) {
                while (k < ell && x[k] == y[j + k])
                    ++k;
                if (k >= ell)
                    System.out.println("index : " + j);
            }
            j += (i - kmpNext[i]);
            if (i == ell)
                k = Math.max(0, k - 1);
            else if (kmpNext[i] <= ell) {
                k = Math.max(0, kmpNext[i]);
                i = ell;
            } else {
                k = ell;
                i = kmpNext[i];
            }
        }
    }

    static void preKmp(char[] x, int m, int[] kmpNext) {
        int i, j;
        i = 0;
        j = kmpNext[0] = -1;
        while (i < m) {
            while (j > -1 && x[i] != x[j])
                j = kmpNext[j];
            i++;
            j++;
            if (i < m && x[i] == x[j])
                kmpNext[i] = kmpNext[j];
            else
                kmpNext[i] = j;
        }
    }
}
