import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2458_Floyd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int INF = (int)1e9;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(arr[i],INF);
            arr[i][i]=0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1;
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(arr[i][j] > arr[i][k]+arr[k][j]){
                        arr[i][j] = arr[i][k]+arr[k][j];
                    }
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=N; i++){
            boolean flag=true;
            for(int j=1; j<=N; j++){
                if(arr[i][j]==INF && arr[j][i]==INF){
                    flag=false;
                    break;
                }
            }
            if(flag) ans++;
        }
        System.out.println(ans);
    }
}