import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_BFS {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][][] dir = {
                {},
                {{-1,0},{1,0},{0,-1},{0,1}},
                {{-1,0},{1,0},{0,0},{0,0}},
                {{0,0},{0,0},{0,-1},{0,1}},
                {{-1,0},{0,0},{0,0},{0,1}},
                {{0,0},{1,0},{0,0},{0,1}},
                {{0,0},{1,0},{0,-1},{0,0}},
                {{-1,0},{0,0},{0,-1},{0,0}}
        };

        String[] move = {"1256","1247","1345","1367"};

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            boolean[][] visit = new boolean[N][M];
            int ans = 1;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<Info> queue = new LinkedList<>();
            queue.offer(new Info(R,C,1));
            visit[R][C]=true;

            while(!queue.isEmpty()){
                Info cur = queue.poll();

                if(cur.cnt==L){
                    break;
                }
                int sn = map[cur.r][cur.c]; // 구조물 번호
                int[][] ddir = dir[sn];
                for(int i=0; i<ddir.length; i++){
                    int nr = cur.r + ddir[i][0];
                    int nc = cur.c + ddir[i][1];
                    if(0<= nr && nr<N && 0<=nc && nc<M && map[nr][nc]>0 && !visit[nr][nc]){
                        if(move[i].contains(map[nr][nc]+"")) {
                            visit[nr][nc] = true;
                            queue.offer(new Info(nr, nc, cur.cnt + 1));
                            ans++;
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n",t,ans);
        }
    }
    private static class Info{
        int r;
        int c;
        int cnt;

        public Info(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }
}