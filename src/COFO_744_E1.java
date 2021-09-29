import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class COFO_744_E1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            Deque<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(Integer.parseInt(st.nextToken()));
            for(int i=1; i<N; i++){
                int a = Integer.parseInt(st.nextToken());
                if(queue.getFirst()>=a){
                    queue.addFirst(a);
                } else {
                    queue.addLast(a);
                }
            }
            while(!queue.isEmpty()){
                System.out.print(queue.poll()+" ");
            }
            System.out.println();
        }
    }
}
