import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1005_Topological_Sort {
    static int N, cost[], arr[][], dp[];
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            cost = new int[N+1];
            dp = new int[N+1];
            arr = new int[N+1][N+1];
            visit = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
                dp[i] = cost[i];
            }
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                arr[from][to]=1;
            }
            int w = Integer.parseInt(br.readLine());
            dfs(w);
            bw.write(dp[w]+"\n");
        }
        bw.flush();
    }
    private static void dfs(int w){
        for(int i=1; i<=N; i++){
            if(arr[w][i]!=0){
                if(!visit[i]) dfs(i);
                dp[w] = Math.max(dp[w], cost[w]+dp[i]);
            }
        }
        visit[w]=true;
    }
}
