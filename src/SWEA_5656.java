
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656 {
    static int ans;
    static int N,C,R,map[][],omap[][],select[];
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
            map = new int[R][C];
            omap = new int[R][C];
            select = new int[N];

            for(int i=0; i<R; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++){
                    omap[i][j] = Integer.parseInt(st.nextToken());
                    map[i][j] = omap[i][j];
                }
            }

            perm(0);

            System.out.printf("#%d %d\n",t,ans);
        }
    }
    private static void perm(int cnt){
        if(cnt==N){
            int tmp = 0;
            for(int i=0; i<N; i++) {
                drop(select[i]);
            }
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j]>0) tmp++;
                }
            }
            ans=Math.min(tmp,ans);
            reset();
            return;
        }
        for(int i=0; i<C; i++){
            select[cnt]=i;
            perm(cnt+1);
        }
    }
    private static void drop(int c){
        Queue<Info> queue = new LinkedList<>();
        for(int r = 0; r<R; r++){
            if(map[r][c]>0){
                queue.offer(new Info(r,c,map[r][c]));
                map[r][c]=0;
                break;
            }
        }

        //벽돌 부수기
        while(!queue.isEmpty()){
            Info cur = queue.poll();
            for(int i=0; i<4; i++){
                int nr = cur.r;
                int nc = cur.c;
                for(int j=0; j<cur.p-1; j++){
                    nr += dr[i];
                    nc += dc[i];
                    if(0<=nr && nr<R && 0<=nc && nc<C && map[nr][nc]>0){
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
    private static void reset(){
        for(int i=0; i<R; i++){
            map[i] = Arrays.copyOf(omap[i], C);
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