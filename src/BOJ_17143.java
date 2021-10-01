import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_17143 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dr = {0,-1,1,0,0};
        int[] dc = {0,0,0,1,-1};
        int[] cdir = {0,2,1,4,3};

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Shark>[][] map = new LinkedList[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] = new LinkedList<>();
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r-1][c-1].add(new Shark(s,d,z));
        }

        int ans = 0;
        for(int c=0; c<C; c++){
            for(int j=0; j<R; j++){
                if(map[j][c].size()>0){
                    ans += map[j][c].get(0).z;
                    map[j][c].remove(0);
                    break;
                }
            }
            boolean[][] visit = new boolean[R][C];

            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j].size()>0 && !visit[i][j]){
                        Shark sh = map[i][j].get(0);
                        map[i][j].remove(0);

                        int nr = i;
                        int nc = j;
                        
                        //시간을 줄이는 아이디어
                        if(sh.d==1 || sh.d==2) sh.s %= (R-1)*2;
                        else sh.s %= (C-1)*2;

                        for(int k=0; k<sh.s; k++){
                            nr += dr[sh.d];
                            nc += dc[sh.d];
                            if(nr<0 || nc<0 || nr>=R || nc>=C){
                                sh.d = cdir[sh.d];
                                nr += 2*dr[sh.d];
                                nc += 2*dc[sh.d];
                            }
                        }
                        map[nr][nc].add(new Shark(sh.s,sh.d,sh.z));
                        if(map[nr][nc].size()==1) visit[nr][nc]=true;
                    }
                }
            }
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j].size()>1){
                        int mxs = 0;
                        int mxd = 0;
                        int mxz = 0;
                        for(Shark sh : map[i][j]){
                            if(mxz<sh.z){
                                mxz=sh.z;
                                mxd=sh.d;
                                mxs=sh.s;
                            }
                        }
                        map[i][j].clear();
                        map[i][j].add(new Shark(mxs,mxd,mxz));
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static class Shark{
        int s;
        int d;
        int z;
        public Shark(int s, int d, int z){
            this.s=s;
            this.d=d;
            this.z=z;
        }
    }
}
