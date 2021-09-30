import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956_Floyd {
    public static void main(String[] args) throws IOException {
        final int INF = (int)1e9;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] arr = new int[V][V];
        for(int i=0; i<V; i++) Arrays.fill(arr[i], INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[s-1][e-1] = c;
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (arr[i][j] > (arr[i][k] + arr[k][j])) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int mn = INF;
        for(int i=0; i<V; i++){
            mn = Math.min(mn, arr[i][i]);
        }
        System.out.println((mn==INF) ? "-1" : mn);
    }
}
