import java.io.*;
import java.util.StringTokenizer;

public class COFO_739_D_MakePowerOfTwo {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] powers = new String[30];
        for(int i=0; i<30; i++){
            powers[i] = (int)Math.pow(2,i)+"";
            System.out.println(powers[i]);
        }
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int ans = 100;
            String s = br.readLine();
            for(int k=0; k<30; k++) {
                int[][] dp = new int[powers[k].length()+1][s.length()+1];
                for (int i = 1; i <= s.length(); i++) dp[0][i] = i;
                for (int i = 1; i <= powers[k].length(); i++) dp[i][0] = i;
                for (int j = 1; j <= s.length(); j++) {
                    for (int i = 1; i <= powers[k].length(); i++) {
                        if (powers[k].charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                        else dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                    }
                }
//                System.out.print(k+","+dp[powers[k].length()][s.length()]+"\n");
                ans = Math.min(ans, dp[powers[k].length()][s.length()]);
            }
            System.out.println(ans);
        }
    }
}
