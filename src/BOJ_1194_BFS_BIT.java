import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_BFS_BIT {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        //문제를 푸는 핵심 아이디어. key 조합 별 방문 배열을 생성한다.
        boolean[][][] visit = new boolean[1<<6][N][M];
        Queue<Info> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j]=='0') {
                    queue.offer(new Info(i,j,0,0));
                    visit[0][i][j]=true;
                    map[i][j]='.';
                }
            }
        }
        //BFS로 탐색
        while(!queue.isEmpty()){
            Info ms = queue.poll();
            //BFS로 탐색하므로 가장 먼저 '1'을 발견하면 최단 경로일 것이다.
            if(map[ms.r][ms.c]=='1'){
                System.out.println(ms.cnt);
                return;
            }
            for(int i=0; i<4; i++){
                int nr = ms.r+dr[i];
                int nc = ms.c+dc[i];

                if(0<=nr && nr<N && 0<=nc && nc<M &&!visit[ms.key][nr][nc] && map[nr][nc]!='#'){
                    //열쇠를 얻는 경우.
                    if(map[nr][nc]>='a' && map[nr][nc]<='f'){
                        int nKey = (ms.key|(1<<(map[nr][nc]-'a')));
                        queue.offer(new Info(nr,nc,ms.cnt+1,nKey));
                        //새로운 키의 방문 배열도 체크해줘야 함!
                        visit[nKey][nr][nc]=true;
                    }
                    //문을 방문한 경우.
                    else if(map[nr][nc]>='A' && map[nr][nc]<='F'){
                        //열쇠를 가지고 있다면
                        if((1<<(map[nr][nc]+32-'a') & ms.key) == (1<<(map[nr][nc]+32-'a'))){
                            queue.offer(new Info(nr,nc,ms.cnt+1,ms.key));
                        }
                    } else {
                        queue.offer(new Info(nr,nc,ms.cnt+1,ms.key));
                    }
                    visit[ms.key][nr][nc]=true;
                }
            }
        }
        System.out.println("-1");
    }
    private static class Info{
        int r,c; //위치 정보
        int cnt; //이동 수
        int key; //현재 얻은 열쇠, bit masking
        public Info(int r, int c, int cnt, int key){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
            this.key=key;
        }
    }
}
