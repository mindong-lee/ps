import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_20056_wrong {
    private static class Fire {
        int m;
        int s;
        int d;

        public Fire(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Fire>[][] arr = new LinkedList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = new LinkedList();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[r - 1][c - 1].add(new Fire(m, s, d));
        }

        for (int t = 0; t < K; t++) {
            LinkedList<Fire>[][] next = new LinkedList[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    next[i][j] = new LinkedList();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j].size() > 0) {
                        //이동
                        for(Fire fb : arr[i][j]) {
                            int nr = i + dr[fb.d] * (fb.s)%N;
                            int nc = j + dc[fb.d] * (fb.s)%N;
                            while(nr<0) nr+=N;
                            while(nc<0) nc+=N;
                            next[nr % N][nc % N].add(new Fire(fb.m,fb.s,fb.d));
                        }
                    }
                }
            }
            arr = next;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j].size() >= 2) {
                        int sm = 0;
                        int ss = 0;
                        boolean even = true;
                        boolean odd = true;

                        for( Fire fb : arr[i][j] ) {
                            sm += fb.m;
                            ss += fb.s;
                            if (fb.d % 2 == 0) odd = false;
                            else even = false;
                        }

                        sm /= 5;
                        ss /= arr[i][j].size();
                        arr[i][j].clear();

                        if (sm > 0) {
                            int s = (even || odd) ? 0 : 1;
                            for (int d = s; d < 8; d += 2) {
                                int nr = i + dr[d] * ss;
                                int nc = j + dc[d] * ss;
                                while (nr < 0) nr += N;
                                while (nc < 0) nc += N;
                                arr[nr % N][nc % N].add(new Fire(sm, ss, d));
                            }
                        }
                    }
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for(Fire fb : arr[i][j]){
                    ret += fb.m;
                }
            }
        }
        System.out.println(ret);
    }
}

