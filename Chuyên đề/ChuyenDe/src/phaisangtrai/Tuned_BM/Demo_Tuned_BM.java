package phaisangtrai.Tuned_BM;

public class Demo_Tuned_BM {
    public static void main(String[] args) {
        char[] x = "ABABCABAB".toCharArray();
        char[] y = "ABABDABACDABABCABAB".toCharArray();
        searchTunedBM(x, y);
    }

    static void preBmBc(char[] x, int m, int bmBc[]) {
        int i;

        for (i = 0; i < 256; ++i)
            bmBc[i] = m;
        for (i = 0; i < m - 1; ++i)
            bmBc[x[i]] = m - i - 1;
    }

    static void searchTunedBM(char[] x, char[] yOld) {
        int m = x.length;
        int n = yOld.length;
        int j, k, shift;
        int[] bmBc = new int[256];

        preBmBc(x, m, bmBc);
        shift = bmBc[x[m - 1]];
        bmBc[x[m - 1]] = 0;
        char[] y = new char[n + m - 1];
        System.arraycopy(yOld, 0, y, 0, n);

        j = 0;
        while (j < n) {
            k = bmBc[y[j + m - 1]];
            while (k != 0) {
                j += k;
                k = (j + m - 1) < y.length ? bmBc[y[j + m - 1]] : 0;
            }
            if (new String(y).startsWith(new String(x), j))
                System.out.println("index : " + j);
            j += shift;
        }
    }
}
