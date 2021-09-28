import java.io.*;
import java.util.StringTokenizer;

public class SWEA_5604 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long ans = 0;
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            for(long i=A; i<=B; i++){
                long r = i;
                while(r>0){
                    ans += r%10;
                    r /= 10;
                }
            }
            System.out.printf("#%d %d\n",t,ans);
        }
    }
}
