import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17484 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+2];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=M+1; j++){
                if(j==0||j==M+1) arr[i][j]=10000;
                else arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[3][N+1][M+2];
        for(int i=0; i<3; i++){
            for(int j=1; j<=N; j++){
                Arrays.fill(dp[i][j],10000);
            }
        }
        for(int i=0; i<3; i++){
            for(int j=1; j<=M; j++) {
                dp[i][1][j] = arr[1][j];
            }
        }
        for(int i=2; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[0][i][j] = Math.min(dp[0][i][j], arr[i][j]+dp[1][i-1][j-1]);
                dp[0][i][j] = Math.min(dp[0][i][j], arr[i][j]+dp[2][i-1][j-1]);
                dp[1][i][j] = Math.min(dp[1][i][j], arr[i][j]+dp[0][i-1][j]);
                dp[1][i][j] = Math.min(dp[1][i][j], arr[i][j]+dp[2][i-1][j]);
                dp[2][i][j] = Math.min(dp[2][i][j], arr[i][j]+dp[0][i-1][j+1]);
                dp[2][i][j] = Math.min(dp[2][i][j], arr[i][j]+dp[1][i-1][j+1]);
            }
        }
        int ans = 100000;
        for(int i=0; i<3; i++){
            for(int j=1; j<=M; j++){
                ans = Math.min(ans, dp[i][N][j]);
            }
        }

        System.out.println(ans);
    }
}
