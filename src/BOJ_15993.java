import java.io.*;

public class BOJ_15993 {
    private static class Info{
        int odd;
        int even;
        public Info(int o, int e){
            this.odd=o;
            this.even=e;
        }
        @Override
        public String toString() {
            return odd + " " + even + "\n";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int MOD = 1000000009;
        Info[] arr = new Info[100001];
        arr[1] = new Info(1,0);
        arr[2] = new Info(1,1);
        arr[3] = new Info(2,2);
        for(int i=4; i<=100000; i++){
            arr[i] = new Info(0,0);
            for(int j=1; j<=3; j++){
                arr[i].odd += arr[i-j].even;
                arr[i].odd %= MOD;
                arr[i].even += arr[i-j].odd;
                arr[i].even %= MOD;
            }
        }
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[n].toString());
        }
        bw.flush();
    }
}
