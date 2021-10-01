import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SegTree_recursive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long[] segTree = new long[N*4];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        makeSegTree(arr, segTree, 1, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int method = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(method==1){
                // b번째수를 c로 교체
                update2(segTree,1,0,N-1,b-1,c-arr[b-1]);
                arr[b-1]=c;
            }else if( method ==2){
                // b~c 합
                sb.append(sum(segTree, 1, 0, N-1, b-1, (int)c-1)).append("\n");
            }
        }
        System.out.println(sb);
    }


    // arr: array
    // tree: segment tree
    // node: node number of segTree
    // start~end: interval of sum
    private static long makeSegTree(long[] arr, long[] tree, int node, int start, int end){
        if(start==end){
            return tree[node]=arr[start];
        } else {
            return tree[node]=makeSegTree(arr, tree, node*2, start, (start+end)/2) +
                    makeSegTree(arr, tree, node*2+1, (start+end)/2+1, end);
        }
    }

    // start~end: 노드가 담당하는 구간
    // left~right: 합을 구하려는 구간
    private static long sum(long[] tree, int node, int start, int end, int left, int right){
        if(right < start || left > end) return 0;
        if(left <= start && end <= right) return tree[node];
        return sum(tree, node*2, start, (start+end)/2, left, right) +
                sum(tree, node*2+1, (start+end)/2+1, end, left, right);
    }

    private static long update1(long[] tree, int node, int start, int end, int index, long val){
        if(index < start || end < index) return 0;
        if(start==end && start==index) return tree[node] = val;

        return tree[node] =
            update1(tree,node*2, start, (start+end)/2, index, val) +
            update1(tree,node*2+1, (start+end)/2+1, end, index, val);
    }

    // for lazy propagation ?
    private static void update2(long[] tree, int node, int start, int end, int index, long diff){
        if(index < start || end < index) return;
        tree[node] = tree[node] + diff;

        //리프 노드가 아닌 경우, 자식도 변경해줘야 한다.
        if(start!=end){
            update2(tree,node*2, start, (start+end)/2, index, diff);
            update2(tree,node*2+1, (start+end)/2+1, end, index, diff);
        }
    }
}
