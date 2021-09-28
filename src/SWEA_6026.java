/*
* 조합론의 포함 배제의 원리를 이용한 풀이
* 문제 입력의 범위가 작아서 조합은 DP로(O(NR)), 거듭제곱은 O(N) 방식으로
* 구현했는데 더 빠르게 구현할 수 있다.
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6026 {
    static int MOD = (int)1e9+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] nCr = new long[101][101];
        for(int i=1; i<=100; i++){
            for(int j=0; j<=100; j++){
                if(j==0 || i==j) nCr[i][j]=1;
                else nCr[i][j] = (nCr[i-1][j-1] + nCr[i-1][j])%MOD;
            }
        }

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            long[] arr = new long[M];
            for(int i=0; i<M; i++){
                arr[i] = power(M-i,N);
            }
            long ret = arr[0];
            for(int i=1; i<M; i++){
                ret = (ret + (power(-1,i)*(nCr[M][i]*arr[i])%MOD)%MOD)%MOD;
            }
            System.out.printf("#%d %d\n",t,ret>=0?ret:ret+MOD);
        }
    }
    private static long power(int a, int b){
        long ret = 1;
        for(int i=0; i<b; i++){
            ret*=a;
            ret%=MOD;
        }
        return ret;
    }
}