import java.io.*;

public class BOJ_1958_LCS {
    static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                for(int k=1; k<=c.length(); k++){
                    LCS(a,b,c,i,j,k);
                }
            }
        }

        System.out.println(dp[a.length()][b.length()][c.length()]);
    }

    private static void LCS(String a, String b, String c, int i, int j, int k){
        if(a.charAt(i-1)==b.charAt(j-1) && b.charAt(j-1)==c.charAt(k-1)){
            if(i==1 || j==1 || k==1){
                dp[i][j][k] = 1;
            } else {
                dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
            }
        } else {
            dp[i][j][k] = Math.max(dp[i][j][k-1], dp[i][j-1][k]);
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k]);
        }
    }
}
