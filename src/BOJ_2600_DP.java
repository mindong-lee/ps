
import java.util.Scanner;

public class BOJ_2600_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int b3 = sc.nextInt();

        boolean[][] dp = new boolean[501][501];
        dp[0][b1] = dp[0][b2] = dp[0][b3] = true;
        dp[b1][0] = dp[b2][0] = dp[b3][0] = true;

        for (int i = 0; i <= 500; i++) {
            for (int j = b1; j <= 500; j++) {
                if (j >= b3 && (!dp[i][j - b1] || !dp[i][j - b2] || !dp[i][j - b3])) {
                    dp[i][j] = dp[j][i] = true;
                } else if (j >= b2 && (!dp[i][j - b1] || !dp[i][j - b2])) {
                    dp[i][j] = dp[j][i] = true;
                } else if (j >= b1 && (!dp[i][j - b1])) {
                    dp[i][j] = dp[j][i] = true;
                }
            }
        }

        for (int t = 0; t < 5; t++) {
            int k1 = sc.nextInt();
            int k2 = sc.nextInt();
            System.out.println(dp[k1][k2] ? "A" : "B");
        }
    }
}