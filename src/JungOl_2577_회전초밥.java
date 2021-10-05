import java.io.*;
import java.util.*;

public class JungOl_2577_회전초밥 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] count = new int[D+1];
        int[] arr = new int[N];
        int ans = 0;
        int tmp = 1;

        count[C]++;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(i>=N-K){
                if(count[arr[i]]==0) tmp++;
                count[arr[i]]++;
            }
        }
        ans = tmp;

        for(int i=0; i<=N-1; i++){
            if(count[arr[i]]==0) tmp++;
            count[arr[i]]++;
            if(count[arr[(i<K) ? i+N-K : i-K]]==1) tmp--;
            count[arr[(i<K) ? i+N-K : i-K]]--;
            ans = Math.max(ans, tmp);
        }

        bw.write(ans+"");
        bw.flush();
    }
}