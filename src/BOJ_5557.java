import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long[][] dp = new long[N+1][20+1];
        for(int i=0; i<N; i++)
            Arrays.fill(dp[i],-1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(arr, dp, N-1, arr[N-1]);

        System.out.println(dp[N-1][arr[N-1]]);
    }
    private static long dfs(int[] arr, long[][] dp, int e, int ret){
        if(dp[e][ret]!=-1)
            return dp[e][ret];

        dp[e][ret]=0;

        if(e==2){
            if(arr[0]+arr[1]==ret){
                dp[2][ret]++;
            }
            if(arr[0]-arr[1]==ret){
                dp[2][ret]++;
            }
            return dp[2][ret];
        }

        if(arr[e-1]+ret<=20)
            dp[e][ret] += dfs(arr, dp, e-1, ret+arr[e-1]);

        if(ret-arr[e-1]>=0)
            dp[e][ret] += dfs(arr, dp, e-1, ret-arr[e-1]);

        return dp[e][ret];
    }
}
