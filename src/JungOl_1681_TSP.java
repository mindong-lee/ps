import java.io.*;
import java.util.StringTokenizer;

public class JungOl_1681_TSP {
    static int N, arr[][], ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        ans = (int)1e9;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==0) arr[i][j]=100000;
            }
        }

        makePermutation(0, 1, 0, new boolean[N+1]);

        System.out.println(ans);
    }

    private static void makePermutation(int cnt, int start, int tmp, boolean[] visited) {
        if(cnt==N-1){
            tmp+=arr[start][1];
            ans=Math.min(ans,tmp);
            return;
        }
        for(int i=2; i<=N; i++){
            if(!visited[i]) {
                visited[i] = true;
                tmp+=arr[start][i];
                if(tmp<ans) {
                    makePermutation(cnt + 1, i, tmp, visited);
                }
                tmp-=arr[start][i];
                visited[i] = false;
            }
        }
    }
}