import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_Floyd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = (a==1) ? true : false;
            }
        }

        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!arr[i][j] && (arr[i][k] && arr[k][j]) ){
                        arr[i][j]=true;
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print((arr[i][j] ? "1 " : "0 "));
            }
            System.out.println();
        }
    }
}
