import java.io.*;
import java.util.StringTokenizer;

public class SWEA_5604_MATH1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long point = 1;
            long[] arr = new long[10];
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            while (A <= B) {
                while (B % 10 != 9 && A <= B) {
                    calc(B, arr, point);
                    B--;
                }
                if( A>B ) break;

                while (A % 10 != 0 && A <= B) {
                    calc(A, arr, point);
                    A++;
                }

                A /= 10;
                B /= 10;

                for (int i = 0; i < 10; i++) {
                    arr[i] += (B - A + 1) * point;
                }
                point *= 10;
            }
            long ans = 0;
            for(int i=0; i<10; i++)
                ans += arr[i]*i;
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    private static void calc(long V, long[] arr, long point) {
        while (V > 0) {
            arr[(int) (V % 10)] += point;
            V /= 10;
        }
    }
}
