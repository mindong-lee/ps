import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070_BFS {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(0,1,0));

        int ans = 0;
        while(!queue.isEmpty()){
            Info cur = queue.poll();
            if(cur.r==N-1 && cur.c==N-1){
                ans++;
                continue;
            }
            if(cur.mode != 1 && cur.c+1<N && arr[cur.r][cur.c+1]==0)
                queue.offer(new Info(cur.r,cur.c+1,0));
            if(cur.mode != 0 && cur.r+1<N && arr[cur.r+1][cur.c]==0)
                queue.offer(new Info(cur.r+1,cur.c,1));
            if(cur.r+1<N && cur.c+1<N && arr[cur.r][cur.c+1]==0 && arr[cur.r+1][cur.c]==0 && arr[cur.r+1][cur.c+1]==0)
                queue.offer(new Info(cur.r+1,cur.c+1,2));
        }

        System.out.println(ans);
    }
    public static class Info{
        int r,c;
        int mode; //0:가로 1:세로 2:대각선
        public Info(int r, int c, int mode){
            this.r=r;
            this.c=c;
            this.mode=mode;
        }
    }
}
