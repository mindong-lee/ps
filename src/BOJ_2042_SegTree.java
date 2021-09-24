import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2042_SegTree {
    static long[] segTree,arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new long[N];
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        segTree = new long[N*4];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        makeSegTree(1,0,N-1);

        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1) {
                updateSegTree(1,0,N-1,b-1,c-arr[b-1]);
                arr[b-1]=c;
            } else {
                bw.write(getSum(1, 0, N-1, b-1, (int)c-1)+"\n");
            }
        }
        bw.flush();
    }

    private static long makeSegTree(int Node, int start, int end) {
        if(start==end) {
            return segTree[Node] = arr[start];
        }
        int mid = (start+end)/2;
        long left = makeSegTree(Node*2, start, mid);
        long right = makeSegTree(Node*2+1, mid+1, end);
        segTree[Node] = left+right;

        return segTree[Node];
    }

    private static long getSum(int Node, int start, int end, int left, int right){
        if(left > end || right < start) return 0;
        if(left <=start && end <= right) return segTree[Node];

        int mid = (start + end) / 2;
        long leftSum = getSum(Node*2, start, mid, left, right);
        long rightSum = getSum(Node*2+1, mid+1, end, left, right);

        return leftSum + rightSum;
    }

    private static void updateSegTree(int Node, int start, int end, int idx, long diff){
        if(idx < start || idx > end) return;
        segTree[Node] += diff;

        if(start != end){
            int mid = (start+end)/2;
            updateSegTree(Node*2, start, mid, idx, diff);
            updateSegTree(Node*2+1, mid+1, end, idx, diff);
        }
    }
}