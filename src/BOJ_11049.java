import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11049 {
    private static class Info{
        int r;
        int c;
        public Info(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static int[][] dp;
    static Info[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new Info[N];
        dp = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Info(r,c);
        }

        System.out.print(dfs(0,N-1));
    }
    private static int dfs(int s, int e){
        if(dp[s][e]>0)
            return dp[s][e];
        if(s==e)
            return dp[s][e]=0;
        if(s+1==e)
            return dp[s][e] = arr[s].r*arr[s].c*arr[e].c;

        dp[s][e]=Integer.MAX_VALUE;
        for(int i=s; i<e; i++)
            dp[s][e] = Math.min(dp[s][e], dfs(s,i)+dfs(i+1,e)+arr[s].r*arr[i].c*arr[e].c);
        return dp[s][e];
    }
}
