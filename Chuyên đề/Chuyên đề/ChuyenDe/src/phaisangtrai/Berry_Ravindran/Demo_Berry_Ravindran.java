package phaisangtrai.Berry_Ravindran;

public class Demo_Berry_Ravindran {
    public static void main(String[] args) {
        char[] x = "AAA".toCharArray();
        char[] y = "AAAAAAA".toCharArray();
        searchBR(x, y);
    }

    static void preBrBc(char[] x, int m, int[][] brBc) {
        int a, b, i;

        for (a = 0; a < 256; ++a)
            for (b = 0; b < 256; ++b)
                brBc[a][b] = m + 2;
        for (a = 0; a < 256; ++a)
            brBc[a][x[0]] = m + 1;
        for (i = 0; i < m - 1; ++i)
            brBc[x[i]][x[i + 1]] = m - i;
        for (a = 0; a < 256; ++a)
            brBc[x[m - 1]][a] = 1;
    }


    static void searchBR(char[] x, char[] yOld) {
        int m = x.length;
        int n = yOld.length;
        char[] y = new char[n + 1];
        System.arraycopy(yOld, 0, y, 0, n);
        int j;
        int[][] brBc = new int[256][256];

        preBrBc(x, m, brBc);

        y[n] = '\0';
        j = 0;
        while (j <= n - m - 1) {
            if (new String(y).startsWith(new String(x), j))
                System.out.println("index : " + j);
            j += brBc[y[j + m]][y[j + m + 1]];
        }
    }
}
