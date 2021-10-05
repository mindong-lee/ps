import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class COFO_731_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        outer:
        for (int t = 0; t < T; t++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                arr.add(a);
            }

            int idx = 0;
            int kk = k;
            for (int cnt = 0; cnt < m; cnt++) {
                int a = sc.nextInt();
                if (a == 0) {
                    arr.add(idx, a);
                    kk++;
                } else {
                    while (idx < arr.size() && kk < a) {
                        if (arr.get(idx) == 0) kk++;
                        idx++;
                    }
                    arr.add(idx, a);
                }
                idx++;
            }

            for (int i = 0; i < n + m; i++) {
                if (arr.get(i) == 0) k++;
                else {
                    if (arr.get(i) > k) {
                        System.out.println(-1);
                        continue outer;
                    }
                }
            }

            for (int e : arr)
                System.out.printf("%d ", e);
            System.out.println();
        }
    }
}