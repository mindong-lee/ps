import java.io.*;
import java.util.StringTokenizer;

public class SWEA_8458 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        outer:
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int mx = 0;
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i] = Math.abs(a)+Math.abs(b);
                if(mx < arr[i]) mx = arr[i];
            }

            for(int i=0; i<N-1; i++){
                if(arr[i]%2!=arr[i+1]%2){
                    System.out.printf("#%d %d\n",t,-1);
                    continue outer;
                }
            }

            long k=0;
            int cnt=0;
            while(k<mx || (k-mx)%2!=0){
                k+=++cnt;
            }

            System.out.printf("#%d %d\n",t,cnt);
        }
    }
}
