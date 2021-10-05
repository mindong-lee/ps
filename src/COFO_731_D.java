import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class COFO_731_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int[] x = new int[N];
            int[] y = new int[N];

            for(int i=0; i<N; i++){
                x[i] = sc.nextInt();
            }

            for(int i=1; i<N; i++){
                y[i] = (x[i-1]^y[i-1])&~x[i];
            }

            for(int i=0; i<N; i++){
                System.out.printf("%d ",y[i]);
            }
            System.out.println();
        }
    }
}