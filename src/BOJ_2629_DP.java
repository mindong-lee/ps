import java.io.*;
import java.util.*;

public class BOJ_2629_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            for(int e : map.keySet()){
                queue.offer(a+e);
                if(a-e>0)
                    queue.offer(a-e);
                if(e-a>0)
                    queue.offer(e-a);
            }
            while(!queue.isEmpty()) map.put(queue.poll(),1);
            map.put(a,1);
        }
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int b = Integer.parseInt(st.nextToken());
            if(map.containsKey(b)) bw.write("Y ");
            else bw.write("N ");
        }
        bw.flush();
    }
}