import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1305_KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String p = br.readLine();

        int[] pi = new int[p.length()];
        for(int i=1,j=0; i<p.length(); i++){
            while(j>0 && p.charAt(i)!=p.charAt(j))
                j=pi[j-1];
            if(p.charAt(i)==p.charAt(j)) {
                pi[i]=++j;
            }
        }

        System.out.println(L-pi[L-1]);
    }
}