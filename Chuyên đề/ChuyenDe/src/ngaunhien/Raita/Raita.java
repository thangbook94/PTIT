package ngaunhien.Raita;

public class Raita {
    //ham so sanh 2 xau
    public static boolean cmp(char[] x, int x1, int x2, char[] y, int y1) {
        for (int i = x1; i <= x2; i++) {
            if (x[i] != y[y1++]) {
                return false;
            }
        }
        return true;
    }
    //tao mang danh dau khoang cach tu tung tu ki tu cuoi cung cua xau mau den ki tu cuoi cung cua xau (khong tinh ki tu cuoi cung)
    //vi du xau mau: GCAGAGAG
    //mang danh dau: A(1) C(6) G(2) T(8)
    public static int[] preBc(char[] x) {
        int[] bc = new int[255];
        int m = x.length;
        for (int i = 0; i < 255; i++) {
            bc[i] = m;
        }
        for (int i = 0; i < m - 1; i++) {
            bc[(int) x[i]] = m - i - 1;
        }
        return bc;
    }

    public static void search(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        int[] preBc = preBc(x);
        int i = 0;
        while (i <= n - m) {
            char c = y[i + m - 1];
            char first = x[0];
            char middle = x[m / 2];
            char last = x[m - 1];
            if (first == y[i] && middle == y[i + m / 2] && last == y[i + m - 1] && cmp(x, 1, m - 2, y, i + 1)) {
                System.out.println("Các vị trí xuất hiện trong văn bản của xâu mẫu là: " + i);
            }
            i = i + preBc[c];
        }
    }

    public static void main(String[] args) {
        char[] x = "GCAGAGAG".toCharArray();
        char[] y = "GCATCGCAGAGAGTATACAGTACG".toCharArray();
        search(x, y);
    }
}