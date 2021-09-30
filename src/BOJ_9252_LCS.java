import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9252_LCS {
    static int[][] dp = new int[1001][1001];
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                LCS(a, b, i, j);
            }
        }

        //table을 역추적해서 문자열을 생성하는 함수
        getString(a,b,a.length(),b.length());

        System.out.println(dp[a.length()][b.length()]);
        System.out.println(ans.reverse());
    }

    private static void getString(String a, String b, int i, int j){
        if(i<=0 || j<=0) return;

        if(a.charAt(i-1)==b.charAt(j-1)){
            ans.append(a.charAt(i-1));
            getString(a,b,i-1,j-1);
        } else {
            if(dp[i][j-1]>dp[i-1][j]){
                getString(a,b,i,j-1);
            } else {
                getString(a,b,i-1,j);
            }
        }
    }

    private static void LCS(String a, String b, int i, int j) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            if (i == 1 || j == 1) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
}
