import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = 0;
        for(int i=0; i<s.length()-1; i++){
            ans = Math.max(ans, kmp(s.substring(i)));
        }
        System.out.println(ans);
    }
    private static int kmp(String p){
        int ret = 0;
        int[] pi = new int[p.length()];
        for(int i=1,j=0; i<p.length(); i++){
            while(j>0 && p.charAt(i)!=p.charAt(j)){
                j=pi[j-1];
            }
            if(p.charAt(i)==p.charAt(j)){
                pi[i]=++j;
                if(j>ret) ret=j;
            }
        }
        return ret;
    }
}
