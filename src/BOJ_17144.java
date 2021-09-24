import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
    private static class Dust{
        int v;
        int tmp;
        public Dust(int v){
            this.v=v;
            this.tmp=0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        Dust[][] arr = new Dust[R][C];
        int ce = 0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                 arr[i][j] = new Dust(Integer.parseInt(st.nextToken()));
                 if(arr[i][j].v==-1){
                    ce=i;
                 }
            }
        }
        int cs = ce-1;
        for(int t=0; t<T; t++) {
            //확산
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j].v > 0) {
                        int cnt = 0;
                        for(int d=0; d<4; d++){
                            int nr = i + dr[d];
                            int nc = j + dc[d];
                            if(0<=nr && nr<R && 0<=nc && nc<C && arr[nr][nc].v!=-1){
                                arr[nr][nc].tmp += (arr[i][j].v)/5;
                                cnt++;
                            }
                        }
                        arr[i][j].v -= ((arr[i][j].v)/5)*cnt;
                    }
                }
            }
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    arr[i][j].v += arr[i][j].tmp;
                    arr[i][j].tmp=0;
                }
            }
            //위쪽 순환
            int row=cs;
            int col=1;
            int ins=0;
            int tmp=0;
            while(col<C) {
                tmp = arr[row][col].v;
                arr[row][col].v = ins;
                ins=tmp;
                col++;
            }
            col--;
            row--;
            while(row>=0){
                tmp = arr[row][col].v;
                arr[row][col].v = ins;
                ins=tmp;
                row--;
            }
            row++;
            col--;
            while(col>=0){
                tmp = arr[row][col].v;
                arr[row][col].v = ins;
                ins=tmp;
                col--;
            }
            col++;
            row++;
            while(row<cs){
                tmp = arr[row][col].v;
                arr[row][col].v = ins;
                ins=tmp;
                row++;
            }
            //아래 순환
            row=ce;
            col=1;
            ins=0;
            tmp=0;
            while(col<C) {
                tmp = arr[row][col].v;
                arr[row][col].v = ins;
                ins=tmp;
                col++;
            }
            col--;
            row++;
            while(row<R){
                tmp = arr[row][col].v;
                arr[row][col].v = ins;
                ins=tmp;
                row++;
            }
            row--;
            col--;
            while(col>=0){
                tmp = arr[row][col].v;
                arr[row][col].v = ins;
                ins=tmp;
                col--;
            }
            col++;
            row--;
            while(row>ce){
                tmp = arr[row][col].v;
                arr[row][col].v = ins;
                ins=tmp;
                row--;
            }
        }

        int ans = 2;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                ans += arr[i][j].v;
            }
        }
        System.out.println(ans);
    }
}
