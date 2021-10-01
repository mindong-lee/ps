import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11505_SegTree {

    static final int MOD = (int)(1e9)+7;
    static int start;
    static long tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (start = 1; start < N; start *= 2) ;
        tree = new long[2 * start];
        Arrays.fill(tree, 1);

        for (int i = 0; i < N; i++) {
            tree[start + i] = Integer.parseInt(br.readLine());
        }

        make_seg();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int method = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (method == 1) {
                // b번째 수를 c로 교체
                update(b, c);
            } else if (method == 2) {
                // b~c 합
                sb.append(mul(b, c, 1, 1, start - 1)).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static long mul(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_R < L || temp_L > R) return 1;
        if (L <= temp_L && temp_R <= R) return tree[idx];
        int mid = (temp_R + temp_L) / 2;
        return (mul(L, R, idx * 2, temp_L, mid) * mul(L, R, idx * 2 + 1, mid + 1, temp_R))%MOD;
    }

    public static void update(int idx, long val) {
        int index = start + idx - 1;
        tree[index] = val;
        while (index > 1) {
            index /= 2;
            tree[index] = (tree[index * 2] * tree[index * 2 + 1])%MOD;
        }
    }

    public static void make_seg() {
        int idx = start - 1;
        while (idx > 0) {
            tree[idx] = (tree[idx * 2] * tree[(idx * 2) + 1])%MOD;
            idx--;
        }
    }
}