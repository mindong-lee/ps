import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10868_SegTree {
    static int[] segTree,arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int M = Integer.parseInt(st.nextToken());

        segTree = new int[N*4];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        makeSegTree(1,0,N-1);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(getMin(1,0,N-1,a-1,b-1)+"\n");
        }
        bw.flush();
    }

    private static int makeSegTree(int Node, int start, int end) {
        if(start==end) {
            return segTree[Node] = arr[start];
        }
        int mid = (start+end)/2;
        int left = makeSegTree(Node*2, start, mid);
        int right = makeSegTree(Node*2+1, mid+1, end);
        segTree[Node] = Math.min(left, right);

        return segTree[Node];
    }

    private static int getMin(int Node, int start, int end, int left, int right){
        if(left > end || right < start) return (int)1e9+1;
        if(left <=start && end <= right) return segTree[Node];

        int mid = (start + end) / 2;
        int leftMin = getMin(Node*2, start, mid, left, right);
        int rightMin = getMin(Node*2+1, mid+1, end, left, right);

        return Math.min(leftMin, rightMin);
    }
}