import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10165_ing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Info[] arr = new Info[M];

        for(int i=1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i-1] = new Info(i,s,e);
        }
    }
    private static class Info{
        int n;
        int s;
        int e;
        public Info(int n, int s, int e){
            this.n=n;
            this.s=s;
            this.e=e;
        }
    }
}