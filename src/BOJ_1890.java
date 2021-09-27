import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    static int N,arr[][];
    static long[][] visit;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new long[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0,0));
    }

    private static long dfs(int r, int c) {
        if(r==N-1 && c==N-1)
            return 1;
        if(arr[r][c]==0)
            return 0;
        if(visit[r][c]>0)
            return visit[r][c];

        if(c+arr[r][c]<N){
            visit[r][c] += dfs(r,c+arr[r][c]);
        }
        if(r+arr[r][c]<N){
            visit[r][c] += dfs(r+arr[r][c],c);
        }
        return visit[r][c];
    }
}