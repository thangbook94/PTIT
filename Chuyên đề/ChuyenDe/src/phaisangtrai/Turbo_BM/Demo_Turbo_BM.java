package phaisangtrai.Turbo_BM;

public class Demo_Turbo_BM {
    public static void main(String[] args) {
        char[] x = "AAA".toCharArray();
        char[] y = "AAAAAAA".toCharArray();
        searchTurboBM(x, y);
    }

    static void preBmBc(char[] x, int m, int bmBc[]) {
        int i;

        for (i = 0; i < 256; ++i)
            bmBc[i] = m;
        for (i = 0; i < m - 1; ++i)
            bmBc[x[i]] = m - i - 1;
    }

    static void preBmGs(char[] x, int m, int bmGs[]) {
        int i, j;
        int[] suff = new int[256];


        int f = 0, g, h;
        suff[m - 1] = m;
        g = m - 1;
        for (h = m - 2; h >= 0; --h) {
            if (h > g && suff[h + m - 1 - f] < h - g)
                suff[h] = suff[h + m - 1 - f];
            else {
                if (h < g)
                    g = h;
                f = h;
                while (g >= 0 && x[g] == x[g + m - 1 - f])
                    --g;
                suff[h] = f - g;
            }
        }


        for (i = 0; i < m; ++i)
            bmGs[i] = m;
        j = 0;
        for (i = m - 1; i >= 0; --i)
            if (suff[i] == i + 1)
                for (; j < m - 1 - i; ++j)
                    if (bmGs[j] == m)
                        bmGs[j] = m - 1 - i;
        for (i = 0; i <= m - 2; ++i)
            bmGs[m - 1 - suff[i]] = m - 1 - i;
    }

    static void searchTurboBM(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        int bcShift, i, j, shift, u, v, turboShift;
        int[] bmGs = new int[256];
        int[] bmBc = new int[256];

        preBmGs(x, m, bmGs);
        preBmBc(x, m, bmBc);

        j = u = 0;
        shift = m;
        while (j <= n - m) {
            i = m - 1;
            while (i >= 0 && x[i] == y[i + j]) {
                --i;
                if (u != 0 && i == m - 1 - shift)
                    i -= u;
            }
            if (i < 0) {
                System.out.println("index : " + j);
                shift = bmGs[0];
                u = m - shift;
            } else {
                v = m - 1 - i;
                turboShift = u - v;
                bcShift = bmBc[y[i + j]] - m + 1 + i;
                shift = Math.max(turboShift, bcShift);
                shift = Math.max(shift, bmGs[i]);
                if (shift == bmGs[i])
                    u = Math.min(m - shift, v);
                else {
                    if (turboShift < bcShift)
                        shift = Math.min(shift, u + 1);
                    u = 0;
                }
            }
            j += shift;
        }
    }
}
