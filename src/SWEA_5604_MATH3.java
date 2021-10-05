//
// SW Expert Academy
// ver.Java
//
// Created by GGlifer
//
// Open Source

import java.io.*;
import java.util.*;
import static java.lang.Math.*;


public class SWEA_5604_MATH3 {
    // Set up : I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb;

    // Global Variables
    static long[] dp_sum;
    static long[] dp_ofs;


    // BOJ_10165_ing Function
    public static void main(String[] args) throws IOException
    {
        // Process
        dp_sum = new long[15+1];
        dp_ofs = new long[15+1];

        dp_sum[0] = 0;
        dp_sum[1] = 45;
        dp_ofs[0] = 1;
        dp_ofs[1] = 10;

        for (int i=2; i<=15; i++) {
            dp_ofs[i] = dp_ofs[i-1] * 10;
            dp_sum[i] = dp_sum[1] * i * dp_ofs[i-1];
            System.out.printf("i, dp_sum[i] : %d, %d\n", i, dp_sum[i]);
        }

        // Set up : Input
        int TC = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=TC; tc++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            // Process
            long ans = getSum(B) - getSum(A-1);

            // Control : Output
            bw.write(String.format("#%d %d\n", tc, ans));
        }

        // Control : Output
        bw.flush();

        br.close();
        bw.close();
    }

    // Helper Functions
    static long getSum(long  n)
    {
        int idx = 15;
        long curr = 0;

        long sum = 0;
        while (curr <= n) {
            while (idx > 0 && curr + dp_ofs[idx] > n) {
                idx--;
            }
            long q = curr / dp_ofs[idx];
            long r = curr % dp_ofs[idx];

            sum += getVal(q) * dp_ofs[idx];
            sum += dp_sum[idx];
            curr += dp_ofs[idx];
        }

        return sum;
    }

    static long getVal(long n)
    {
        long ret = 0;
        while (n > 0) {
            ret += n%10;
            n /= 10;
        } return ret;
    }

    // Helper Classes
    /* None */
}

// 123456
//      0 ~  99999
// 100000 ~ 109999
// 110000 ~ 119999
// 120000 ~ 120999
// 121000 ~ 121999
// 122000 ~ 122999
// 123000 ~ 123099
// 123100 ~ 123199
// 123200 ~ 123299
// 123300 ~ 123399
// 123400 ~ 123499
// 123450 ~ 12345
