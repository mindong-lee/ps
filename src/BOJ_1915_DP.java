import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            char[] s = br.readLine().toCharArray();
            for(int j=1; j<=M; j++){
                arr[i][j] = s[j-1]-'0';
            }
        }

        int mx = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(arr[i][j]!=0) {
                    arr[i][j] = min(arr[i - 1][j - 1], arr[i - 1][j], arr[i][j - 1])+1;
                    mx = Math.max(mx, arr[i][j]);
                }
            }
        }
        System.out.println(mx*mx);
    }
    private static int min(int a, int b, int c){
        int tmp = Math.min(a,b);
        return Math.min(tmp,c);
    }
}
