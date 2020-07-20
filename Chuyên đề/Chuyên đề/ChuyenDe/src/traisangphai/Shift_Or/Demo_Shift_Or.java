package traisangphai.Shift_Or;

public class Demo_Shift_Or {
    public static void main(String[] args) {
        char[] pat = "ABCABAB".toCharArray();
        char[] txt = "ABABDABACDABABCABAB".toCharArray();
        searchSO(pat, txt);
    }

    static int preSo(char[] x, int m, long[] S) {
        long j, lim;
        int i;
        for (i = 0; i < 256; ++i)
            S[i] = ~0;
        for (lim = i = 0, j = 1; i < m; ++i, j <<= 1) {
            S[x[i]] &= ~j;
            lim |= j;
        }
        lim = ~(lim >> 1);
        return (int) lim;
    }

    static void searchSO(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;

        long lim, state;
        long[] S = new long[256];
        int j;

        lim = preSo(x, m, S);

        for (state = ~0, j = 0; j < n; ++j) {
            state = (state << 1) | S[y[j]];
            if (state < lim)
                System.out.println(j - m + 1);
        }
    }
}
