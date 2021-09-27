import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class COFO_734_D1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            if(K%2==0){ //K가 짝수
                if(N%2==1){
                    if(K==0){
                        if(N%2==0)
                            System.out.println("YES");
                        else
                            System.out.println("NO");
                    }
                    else if((M/2)%2==0)
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                } else {
                        System.out.println("YES");
                }
            } else { //K가 홀수
                if((M/2)%2==1 && N%2==1){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
