import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1]=1;
        for(int i=2; i<=1000; i++){
            for(int j=1; j<i; j++){
                if(gcd(j,i)==1){
                    dp[i]++;
                }
            }
            dp[i]+=dp[i-1];
        }
        for(int t=0;t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N]*2+1+"\n");
        }
        bw.flush();
    }
    private static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
}
