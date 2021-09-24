import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11062_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
            //fb(first best) : 근우가 선택 가능한 경우의 수(최선)
            //sb(second best) : 명우가 선택 가능한 경우의 수(차선)
            int[][] fb = new int[N][N];
            int[][] sb = new int[N][N];
            for(int i=0; i<N; i++) fb[i][i]=sb[i][i]=arr[i];
            for(int i=0; i<N-1; i++){
                fb[i][i+1] = Math.max(arr[i],arr[i+1]);
                sb[i][i+1] = Math.min(arr[i],arr[i+1]);
            }
            for(int i=2; i<N; i++){
                for(int j=0; j+i<N; j++){
                        fb[j][j + i] = Math.max(arr[j+i]+sb[j][j+i-1], arr[j]+sb[j+1][j+i]);
                        sb[j][j + i] = Math.min(fb[j][j+i-1],fb[j+1][j+i]);
                }
            }
            bw.write(fb[0][N-1]+"\n");
        }
        bw.flush();
    }
}
