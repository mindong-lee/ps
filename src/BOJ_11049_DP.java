import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11049_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(i==0) list.add(a);
            list.add(b);
        }
        int ans = 0;
        while(list.size()>2){
            int idx = 1;
            int mx = list.get(1);
            for(int i=2; i<=list.size()-2; i++){
                if(mx < list.get(i)){
                    mx = list.get(i);
                    idx = i;
                }
            }
            ans += list.get(idx-1)*list.get(idx)*list.get(idx+1);
            list.remove(idx);
        }
        System.out.println(ans);
    }
}