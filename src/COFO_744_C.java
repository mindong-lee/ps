import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class COFO_744_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            char[][] arr = new char[N][M];
            boolean[][] visit = new boolean[N][M];
            for(int i=0; i<N; i++){
                arr[i] = br.readLine().toCharArray();
            }
            int mn = 10000;
            for(int i=N-1; i>=0; i--){
                for(int j=M-1; j>=0; j--){
                    if(arr[i][j]=='*'){
                        int cnt = 1;
                        int nr1 = i-cnt;
                        int nc1 = j-cnt;
                        int nr2 = i-cnt;
                        int nc2 = j+cnt;

                        while( (0<=nr1 && nr1<N && 0<=nc1 && nc1<M && arr[nr1][nc1]=='*')
                        && (0<=nr2 && nr2<N && 0<=nc2 && nc2<M && arr[nr2][nc2]=='*')){
//                            System.out.println(nr1+","+nc1+","+nr2+","+nc2);
                            visit[nr1][nc1]=true;
                            visit[nr2][nc2]=true;
                            nr1--;nc1--;nr2--;nc2++;
                            cnt++;
                        }
                        if(visit[i][j]) continue;
//                        System.out.println(mn);
                        mn = Math.min(mn, cnt-1);
                    }
                }
            }
//            System.out.println(t+": "+mn);
            System.out.println((mn>=K) ? "YES" : "NO");
//            for(char[] e : arr){
//                System.out.println(Arrays.toString(e));
//            }
        }
    }
}
