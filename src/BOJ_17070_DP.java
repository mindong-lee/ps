import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_DP {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        int[][][] dp = new int[3][N+1][N+1];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=2; j<=N; j++){
                if(arr[i][j]>0) continue;
                if(i==1 && j==2) {
                    dp[0][i][j] = 1;
                    continue;
                }
                dp[0][i][j] = dp[2][i][j-1] + dp[0][i][j-1];
                dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
                if(arr[i-1][j]==0 && arr[i][j-1]==0)
                    dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
            }
        }

        System.out.println(dp[0][N][N]+dp[1][N][N]+dp[2][N][N]);
    }
}
