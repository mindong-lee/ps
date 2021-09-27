import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890_improved {
    int N;
    int[][] map;
    long[][] dp;
    public static void main(String[] args) throws IOException {
        BOJ_1890_improved main = new BOJ_1890_improved();
        main.solve();
    }
    void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        dp[0][0] = 1;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                int t = map[i][j];
                if(map[i][j] == 0) continue;
                if(i+t < N) dp[i+t][j] += dp[i][j];
                if(j+t < N) dp[i][j+t] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}