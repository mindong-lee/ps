import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int r,c; // 위치
    int v; // 시작점에서 r,c 까지의 비용
    public Point(int r, int c, int v){
        this.r=r;
        this.c=c;
        this.v=v;
    }
    @Override
    public int compareTo(Point o){
        return v - o.v;
    }
}
public class BOJ_4485_BFS_Dijk {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dr = {-1,1,0,0}; //r 방향
        int[] dc = {0,0,-1,1}; //c 방향
        int t=1; //tc 

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            int[][] arr = new int[N][N]; //비용 저장 공간
            boolean[][] visit = new boolean[N][N]; //방문 배열

            //입력 받기
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            //우선순위 큐를 이용한 BFS (Dijkstra)
            //비용이 가장 적은 지점부터 꺼내는 그리디 방법.

            PriorityQueue<Point> queue = new PriorityQueue<>();
            queue.add(new Point(0,0,arr[0][0]));
            visit[0][0]=true;

            while(!queue.isEmpty()){
                Point p = queue.poll();
                //현재 위치가 목적지라면 종료한다.
                //PriorityQueue로 비용이 가장 적게 드는 순서로 뽑았기 때문에
                //현재 비용이 최소 비용이라고 볼 수 있다.
                if(p.r==N-1 && p.c==N-1) {
                    System.out.printf("Problem %d: %d\n", t++, p.v);
                    break;
                }
                for(int i=0; i<4; i++){
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];
                    if( 0<=nr && nr<N && 0<=nc && nc<N && !visit[nr][nc]){
                        visit[nr][nc]=true;
                        queue.add(new Point(nr,nc,p.v+arr[nr][nc]));
                    }
                }
            }
        }
    }
}