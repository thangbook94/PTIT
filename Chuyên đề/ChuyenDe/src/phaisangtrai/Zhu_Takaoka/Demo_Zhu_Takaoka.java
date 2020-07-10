package phaisangtrai.Zhu_Takaoka;

public class Demo_Zhu_Takaoka {
    public static void main(String[] args) {
        char[] x = "AAA".toCharArray();
        char[] y = "AAAAAAA".toCharArray();
        searchZT(x, y);
    }

    static void preZtBc(char[] x, int m, int[][] ztBc) {
        int i, j;

        for (i = 0; i < 256; ++i)
            for (j = 0; j < 256; ++j)
                ztBc[i][j] = m;
        for (i = 0; i < 256; ++i)
            ztBc[i][x[0]] = m - 1;
        for (i = 1; i < m - 1; ++i)
            ztBc[x[i - 1]][x[i]] = m - 1 - i;
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


    static void searchZT(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        int i, j;
        int[] bmGs = new int[256];
        int[][] ztBc = new int[256][256];

        preZtBc(x, m, ztBc);
        preBmGs(x, m, bmGs);

        j = 0;
        while (j <= n - m) {
            i = m - 1;
            while (i >= 0 && i < m && x[i] == y[i + j])
                --i;
            if (i < 0) {
                System.out.println("index : " + j);
                j += bmGs[0];
            } else
                j += Math.max(bmGs[i],
                        ztBc[y[j + m - 2]][y[j + m - 1]]);
        }
    }
}
