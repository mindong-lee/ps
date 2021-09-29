import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class COFO_744_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int ans = 0;
            List<Info> ansarr = new ArrayList<>();
            //1. find minimun value index.
            //2. move frontside
            //3. repeat 1-2
            for(int i=1; i<=N-1; i++) {
                int midx = findMin(arr, i);
                if(i!=midx) {
                    rotate(arr, i, midx);
                    ans++;
                    ansarr.add(new Info(i, midx,midx-i));
                }
            }
            System.out.println(ans);
            for(Info i : ansarr)
                System.out.println(i);
        }

    }
    private static void rotate(int[] arr, int from, int to){
        int tmp=arr[to];
        for(int i=to; i>from; i--){
            arr[i]=arr[i-1];
        }
        arr[from]=tmp;
    }
    private static int findMin(int[] arr, int start){
        int val = arr[start];
        int ret = start;
        for(int i=start+1; i<arr.length; i++){
            if(val>arr[i]) {
                val=arr[i];
                ret=i;
            }
        }
        return ret;
    }
    private static class Info{
        int l;
        int r;
        int d;
        public Info(int l, int r, int d){
            this.l=l;
            this.r=r;
            this.d=d;
        }
        @Override
        public String toString() {
            return l+" "+r+" "+d;
        }
    }
}
