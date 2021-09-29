import java.util.Scanner;

public class BOJ_1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = 1;
        int B = sc.nextInt();
        long[] arr = new long[10];
        long point = 1;

        while (A <= B) {
            while (B % 10 != 9 && A <= B) {
                calc(B, arr, point);
                B--;
            }

            if (B < A) break;

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
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

    private static void calc(int V, long[] arr, long point) {
        while (V > 0) {
            arr[V % 10] += point;
            V /= 10;
        }
    }
}
