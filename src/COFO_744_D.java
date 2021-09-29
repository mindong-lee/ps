import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class COFO_744_D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Info> queue = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Info> ansarr = new ArrayList<>();
            for(int i=1; i<=N; i++){
                int a = Integer.parseInt(st.nextToken());
                if(a!=0)
                    queue.add(new Info(i,a));
            }
            while(queue.size()>=2){
                Info a = queue.poll();
                Info b = queue.poll();
                ansarr.add(new Info(a.n,b.n));
                if(a.p-1>0)
                    queue.offer(new Info(a.n,a.p-1));
                if(b.p-1>0)
                    queue.offer(new Info(b.n,b.p-1));
            }

            System.out.println(ansarr.size());
            for(Info e : ansarr){
                System.out.println(e.n+" "+e.p);
            }
        }
    }
    private static class Info implements Comparable<Info>{
        int n;
        int p;
        public Info(int n, int p){
            this.n=n;
            this.p=p;
        }
        @Override
        public int compareTo(Info o) {
            return o.p-this.p;
        }
    }
}
