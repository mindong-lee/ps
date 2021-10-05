
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_Improved {
    static int ans;
    static int N,C,R;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            ans = (int)1e9;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            int[][] map = new int[R][C];


            for(int i=0; i<R; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            go(0,map);

            System.out.printf("#%d %d\n",t,ans);
        }
    }
    private static void go(int cnt, int[][] map){
        if(cnt==N){
            int tmp = 0;
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j]>0) tmp++;
                }
            }
            ans=Math.min(tmp,ans);
            return;
        }
        int[][] cmap = new int[R][C];

        for(int c=0; c<C; c++){
            int r = 0;
            while(r<R && map[r][c]==0) r++;
            if(r==R)
                go(cnt+1,map);
            else{
                for(int i=0; i<R; i++) cmap[i] = Arrays.copyOf(map[i], C);
                drop(r,c,cmap);
                go(cnt+1,cmap);
            }
        }
    }
    private static void drop(int r, int c, int[][] map){
        Queue<Info> queue = new LinkedList<>();
        if(map[r][c]>1)
            queue.offer(new Info(r,c,map[r][c]));
        map[r][c] = 0;
        //벽돌 부수기
        while(!queue.isEmpty()){
            Info cur = queue.poll();
            for(int i=0; i<4; i++){
                int nr = cur.r;
                int nc = cur.c;
                for(int j=0; j<cur.p-1; j++){
                    nr += dr[i];
                    nc += dc[i];
                    if(0<=nr && nr<R && 0<=nc && nc<C && map[nr][nc]!=0){
                        if(map[nr][nc]>1)
                            queue.offer(new Info(nr,nc,map[nr][nc]));
                        map[nr][nc]=0;
                    }
                }
            }
        }

        //벽돌 내리기
        for(int j=0; j<C; j++){
            int[] tmp = new int[R];
            int cnt = 0;
            for(int i=R-1; i>=0; i--){
                if(map[i][j]>0)
                    tmp[cnt++]=map[i][j];
            }
            for(int i=R-1; i>=0; i--){
                map[i][j]=tmp[R-1-i];
            }
        }
    }

    private static class Info{
        int r;
        int c;
        int p;
        public Info(int r, int c, int p){
            this.r=r;
            this.c=c;
            this.p=p;
        }
    }
}