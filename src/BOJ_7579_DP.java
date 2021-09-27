import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] mem = new int[N];
        int[] cost = new int[N];

        int memsum=0;
        int costsum=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            mem[i] = Integer.parseInt(st.nextToken());
            memsum += mem[i];
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            costsum += cost[i];
        }

        int[] dp = new int[memsum-M+1];

        for(int i=0; i<N; i++) {
            for (int j = memsum - M; j >= mem[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-mem[i]]+cost[i]);
            }
        }
        System.out.println(costsum-dp[memsum-M]);
    }
}
