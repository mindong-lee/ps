import java.io.*;
import java.util.Arrays;

public class BOJ_5052_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        outer:
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            for(int i=0; i<N; i++){
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);
            for(int i=0; i<N-1; i++){
                if(arr[i+1].startsWith(arr[i])){
                    bw.write("NO\n");
                    continue outer;
                }
            }
            bw.write("YES\n");
        }
        bw.flush();
    }
}
