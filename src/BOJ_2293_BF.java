import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2293_BF {
    static int N, K, arr[], ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(ans);
    }
    private static void dfs(int sum,int start){
        for(int i=start; i<N; i++){
            sum+=arr[i];
            if(sum==K){
                ans++;
                return;
            }
            if(sum<K){
                dfs(sum,i);
            } else {
                return;
            }
            sum-=arr[i];
        }
    }
}
