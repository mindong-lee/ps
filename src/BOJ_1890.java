import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    static long ans;
    static int N,arr[][];
    static int[][] visit;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(ans);
    }

    private static boolean dfs(int r, int c) {
        if(visit[r][c]>0 || (r==N-1 && c==N-1)){
            ans+=visit[r][c];
            return true;
        }
        if(arr[r][c]==0 || visit[r][c]==-1) return false;

        boolean flag = false;

        if(c+arr[r][c]<N){
            if(dfs(r,c+arr[r][c])){
                visit[r][c]++;
                flag=true;
            }
        }
        if(r+arr[r][c]<N){
            if(dfs(r+arr[r][c],c)){
                visit[r][c]++;
                flag=true;
            }
        }

        if(!flag) {
            visit[r][c]=-1;
            return false;
        } else {
            return true;
        }
    }
}
