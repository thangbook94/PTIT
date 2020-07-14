package cuthe.Skip;

import java.util.ArrayList;
import java.util.HashMap;

public class Skip {
    public static HashMap<String, ArrayList<Integer>> preSkip(char[] x) {
        HashMap<String, ArrayList<Integer>> re = new HashMap<>();
        for (int i = x.length - 1; i >= 0; i--) {
            ArrayList<Integer> temp;
            if (re.containsKey(x[i] + "")) {
                temp = re.get(x[i] + "");
            } else {
                temp = new ArrayList<>();
            }
            temp.add(i);
            re.put(x[i] + "", temp);
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
        char[] x = "GCAGAGAG".toCharArray();
        char[] y = "GCATCGCAGAGAGTATACAGTACG ".toCharArray();
        HashMap<String, ArrayList<Integer>> map = preSkip(x);
        int m = x.length;
        int n = y.length;
        for (int j = m - 1; j < n; j += m) {
            ArrayList<Integer> temp = map.get(y[j] + "");
            if (temp != null) {
                for (int i : temp) {
                    j -= i;
                    if (cmp(x, y, j)) {
                        System.out.println("Các vị trí xuất hiện trong văn bản của xâu mẫu là: " + j);
                    }
                    j += i;
                }
            }
        }
    }
}
