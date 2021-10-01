import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11658_2dSeg {
    static int h = 1;
    static int arr[][], seg[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while(h < N) h<<= 1;
        arr = new int[N+1][N+1];
        seg = new int[2*h][2*h];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                update(i,j,arr[i][j]);
            }
        }

        for(int t=0; t<M; t++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            if(m==1){
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int tmp = 0;
                if (r1 > r2) {
                    tmp=r1;
                    r1=r2;
                    r2=tmp;
                }
                if (c1 > c2) {
                    tmp=c1;
                    c1=c2;
                    c2=tmp;
                }

                bw.write(yquery(c1, c2, 1, 1, h, r1, r2)+"\n");
            } else {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                update(r,c,k);
            }
        }
        bw.flush();
    }

    private static void update(int x1, int y1, int d){
        int i = y1+h-1;
        int j = x1+h-1;
        seg[i][j] = d;
        while (j > 1) {
            j /= 2;
            seg[i][j] = seg[i][j * 2] + seg[i][j * 2 + 1];
        }
        while (i > 1) {
            j = x1 + h - 1;
            i /= 2;
            seg[i][j] = seg[i * 2][j] + seg[i * 2 + 1][j];
            while (j > 1) {
                j /= 2;
                seg[i][j] = seg[i][j * 2] + seg[i][j * 2 + 1];
            }
        }
        return;
    }

    private static int xquery(int y, int nodeL, int nodeR, int nodeNum, int l, int r) {
        if (nodeL <= l && r <= nodeR) return seg[y][nodeNum];
        else if (nodeR < l || r < nodeL) return 0;
        int mid = (l+r)/2;
        return xquery(y, nodeL, nodeR, nodeNum * 2, l, mid) + xquery(y, nodeL,nodeR, nodeNum * 2 + 1, mid+1, r);
    }

    private static int yquery(int nodeL, int nodeR, int nodeNum, int l, int r, int x1, int x2) {
        if (nodeL <= l && r <= nodeR) return xquery(nodeNum,x1,x2,1,1,h);
        else if (nodeR < l || r < nodeL) return 0;
        int mid = (l+r) / 2;
        return yquery(nodeL, nodeR, nodeNum * 2, l, mid,x1,x2) + yquery(nodeL, nodeR, nodeNum * 2 + 1, mid+1, r,x1,x2);
    }
}
