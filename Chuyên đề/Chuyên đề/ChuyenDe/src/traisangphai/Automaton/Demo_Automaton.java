package traisangphai.Automaton;

public class Demo_Automaton {

    public static void main(String[] args) {
        char[] pat = "ABCABAB".toCharArray();
        char[] txt = "ABABDABACDABABCABAB".toCharArray();
        searchAtm(pat, txt);
    }

    static int getNextState(char[] pat, int M, int state, int x) {
        if (state < M && x == pat[state])
            return state + 1;
        int ns, i;
        for (ns = state; ns > 0; ns--) {
            if (pat[ns - 1] == x) {
                for (i = 0; i < ns - 1; i++)
                    if (pat[i] != pat[state - ns + 1 + i])
                        break;
                if (i == ns - 1)
                    return ns;
            }
        }
        return 0;
    }

    static void compute(char[] pat, int M, int[][] TF) {
        int state, x;
        for (state = 0; state <= M; ++state)
            for (x = 0; x < 256; ++x)
                TF[state][x] = getNextState(pat, M, state, x);
    }

    static void searchAtm(char[] pat, char[] txt) {
        int M = pat.length;
        int N = txt.length;

        int[][] TF = new int[M + 1][256];

        compute(pat, M, TF);

        int i, state = 0;
        for (i = 0; i < N; i++) {
            state = TF[state][txt[i]];
            if (state == M)
                System.out.println("Pattern found " + "at index " + (i - M + 1));
        }
    }
}
