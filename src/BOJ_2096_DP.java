import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int mn1, mn2, mn3;
        int mx1, mx2, mx3;

        st = new StringTokenizer(br.readLine());
        mn1 = mx1 = Integer.parseInt(st.nextToken());
        mn2 = mx2 = Integer.parseInt(st.nextToken());
        mn3 = mx3 = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int tmp1, tmp2, tmp3;

            tmp1 = Math.max(a + mx1, a + mx2);
            tmp2 = max(b + mx1, b + mx2, b + mx3);
            tmp3 = Math.max(c + mx2, c + mx3);

            mx1 = tmp1; mx2 = tmp2; mx3 = tmp3;

            tmp1 = Math.min(a + mn1, a + mn2);
            tmp2 = min(b + mn1, b + mn2, b + mn3);
            tmp3 = Math.min(c + mn2, c + mn3);

            mn1 = tmp1; mn2 = tmp2; mn3 = tmp3;
        }

        System.out.printf("%d %d", max(mx1, mx2, mx3), min(mn1, mn2, mn3));
    }

    private static int min(int a, int b, int c) {
        int tmp = Math.min(a, b);
        return Math.min(tmp, c);
    }

    private static int max(int a, int b, int c) {
        int tmp = Math.max(a, b);
        return Math.max(tmp, c);
    }
}