package cuthe.AlphaSkip;

import java.util.ArrayList;
import java.util.HashMap;

public class AlphaSkip {
    public static HashMap<String, ArrayList<Integer>> preAlphaSkip(char[] x, int k) {
        HashMap<String, ArrayList<Integer>> re = new HashMap<>();
        for (int i = x.length - 1; i >= k - 1; i--) {
            StringBuilder tem = new StringBuilder();
            for (int j = i - k + 1; j <= i; j++) {
                tem.append(x[j]);
            }
            ArrayList<Integer> temp;
            if (re.containsKey(tem + "")) {
                temp = re.get(tem + "");
            } else {
                temp = new ArrayList<>();
            }
            temp.add(i - k + 1);
            re.put(tem + "", temp);
        }
        return re;
    }


    public static boolean cmp(char[] x, char[] y, int y1) {
        for (char c : x) {
            if (c != y[y1++]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[] x = "CAGAGAGT".toCharArray();
        char[] y = "GCATCGCAGAGAGTATACAGTACG ".toCharArray();
        int k = 3;
        HashMap<String, ArrayList<Integer>> map = preAlphaSkip(x, k);
        for (String i : map.keySet()) {
            System.out.print(i + " : ");
            for (int j : map.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        int m = x.length;
        int n = y.length;
        for (int j = m - 1; j < n; j += m - k + 1) {
            StringBuilder tem = new StringBuilder();
            for (int l = j - k + 1; l <= j; l++) {
                tem.append(y[l]);
            }
            ArrayList<Integer> temp = map.get(tem.toString());
            if (temp != null) {
                for (int i : temp) {
                    if (cmp(x, y, j - i - k + 1)) {
                        System.out.println("Các vị trí xuất hiện trong văn bản của xâu mẫu là: " + (j - i - k + 1));
                    }
                }
            }
        }
    }
}
