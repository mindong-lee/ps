import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class COFO_734_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] check = new int[200001];
            int[] group = new int[K+1];
            int[] arr = new int[N];
            int[] ans = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < arr.length; i++) {
                if (check[arr[i]] < K) {
                    check[arr[i]]++;
                    int mingroup=1;
                    for(int j=2; j<=K; j++){
                        mingroup = Math.min(group[mingroup],group[i]);
                    }
                    group[mingroup]++;
                    ans[i]=mingroup;
                }
            }

            for(int e : ans) System.out.print(e+" ");
            System.out.println();
        }
    }
}
