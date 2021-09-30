import java.util.Scanner;

public class BOJ_2225_DP {
    public static void main(String[] args) {
        final int MOD = (int)1e9;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[N+1][K+1];

        for(int i=0; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(i==0 || j==1)
                    dp[i][j]=1;
                else
                    dp[i][j]=(dp[i-1][j]+dp[i][j-1])%MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}
