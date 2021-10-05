import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10999_SegTree_Lazy {
    static long[] tree, lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        tree = new long[4*N];
        lazy = new long[4*N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());

        init(arr, 1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                update_range(1, 0, N - 1, b-1, c-1, d);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                bw.write(sum(1, 0, N - 1, b-1, c-1)+"\n");
            }
        }
        bw.flush();
    }

    private static long init(long[] arr, int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) >>> 1;

        return tree[node] = init(arr, node * 2, start, mid)
                + init(arr, node * 2 + 1, mid + 1, end);
    }

    private static long sum(int node, int start, int end, int left, int right) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (left > end || right < start) return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) >>> 1;

        return sum(node * 2, start, mid, left, right)
                + sum(node * 2 + 1, mid + 1, end, left, right);
    }

    private static void update_range(int node, int start, int end, int left, int right, long diff) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if(right < start || left > end) return;

        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * diff;
            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }

        int mid = (start + end) >>> 1;
        update_range(node * 2, start, mid, left, right, diff);
        update_range(node * 2 + 1, mid + 1, end, left, right, diff);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}