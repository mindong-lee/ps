import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11658_recursive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] tree2d = new int[N][4*N];
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            makeSegTree(arr[i],tree2d[i],1,0,N-1);
        }

        for(int t=0; t<M; t++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            if(m==1){
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());

                int ans = 0;
                for(int i=r1-1; i<=r2-1; i++)
                    ans += sum(tree2d[i],1,0,N-1,c1-1,c2-1);

                bw.write(ans+"\n");
            } else {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                update(tree2d[r-1], 1,0, N-1,c-1, k-arr[r-1][c-1]);
                arr[r-1][c-1]=k;
            }
        }
        bw.flush();
    }

    private static void update(int[] tree, int node, int start, int end, int index, int diff){
        if(index < start || end < index) return;
        tree[node] = tree[node] + diff;

        if(start!=end){
            update(tree,node*2, start, (start+end)/2, index, diff);
            update(tree,node*2+1, (start+end)/2+1, end, index, diff);
        }
    }

    private static int sum(int[] tree, int node, int start, int end, int left, int right){
        if(right < start || left > end) return 0;
        if(left <= start && end <= right) return tree[node];
        return sum(tree, node*2, start, (start+end)/2, left, right) +
                sum(tree, node*2+1, (start+end)/2+1, end, left, right);
    }

    private static int makeSegTree(int[] arr, int[] tree, int node, int start, int end){
        if(start==end){
            return tree[node]=arr[start];
        } else {
            return tree[node]=makeSegTree(arr, tree, node*2, start, (start+end)/2) +
                    makeSegTree(arr, tree, node*2+1, (start+end)/2+1, end);
        }
    }
}
