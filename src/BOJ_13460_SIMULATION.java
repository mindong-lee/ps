import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460_SIMULATION {
    private static class Info {
        int rr;
        int rc;
        int br;
        int bc;
        int cnt;

        public Info(int rr, int rc, int br, int bc, int cnt) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        char[][] arr = new char[N][M];
        boolean[][][][] visited = new boolean[N][M][N][M];

        int redR = 0, redC = 0;
        int blueR = 0, blueC = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'R') {redR = i; redC = j;}
                if (arr[i][j] == 'B') {blueR = i; blueC = j;}
            }
        }

        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(redR, redC, blueR, blueC, 1));
        visited[redR][redC][blueR][blueC]=true;

        while (!queue.isEmpty()) {
            Info i = queue.poll();
            redR=i.rr; redC=i.rc; blueR=i.br; blueC=i.bc;

            if(i.cnt>10) {
                System.out.println(-1);
                return;
            }
            for(int d=0; d<4; d++){
                i.rr=redR;
                i.rc=redC;
                i.br=blueR;
                i.bc=blueC;
                //flag : 공이 hole에 빠졌는지 체크
                boolean rflag=false;
                boolean bflag=false;

                while(arr[i.rr+dr[d]][i.rc+dc[d]] != '#'){
                    i.rr += dr[d];
                    i.rc += dc[d];

                    if(arr[i.rr][i.rc]=='O'){
                        rflag=true;
                        break;
                    }
                }
                while(arr[i.br+dr[d]][i.bc+dc[d]] != '#'){
                    i.br += dr[d];
                    i.bc += dc[d];

                    if(arr[i.br][i.bc]=='O'){
                        bflag=true;
                        break;
                    }
                }
                if(bflag)
                    continue;
                if(rflag){
                    System.out.println(i.cnt);
                    return;
                }
                if(i.rr==i.br && i.rc==i.bc){
                    switch(d){
                        case 0: // 상
                            if(redR > blueR) i.rr-=dr[d];
                            else i.br-=dr[d];
                            break;
                        case 1: // 하
                            if(redR > blueR) i.br-=dr[d];
                            else i.rr-=dr[d];
                            break;
                        case 2: // 좌
                            if(redC > blueC) i.rc-=dc[d];
                            else i.bc-=dc[d];
                            break;
                        case 3: // 우
                            if(redC > blueC) i.bc-=dc[d];
                            else i.rc-=dc[d];
                            break;
                    }
                }
                if(!visited[i.rr][i.rc][i.br][i.bc]){
                    visited[i.rr][i.rc][i.br][i.bc]=true;
                    queue.offer(new Info(i.rr,i.rc,i.br,i.bc,i.cnt+1));
                }
            }
        }
        System.out.println(-1);
        return;
    }
}
