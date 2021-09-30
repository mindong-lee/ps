import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11780_Floyd {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        final int INF = (int) 1e9;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int[][] arr = new int[V][V];
        String[][] path = new String[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[s - 1][e - 1] = Math.min(arr[s-1][e-1], c);
            path[s - 1][e - 1] = " ";
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (arr[i][j] > (arr[i][k] + arr[k][j])) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        path[i][j] = path[i][k] + (k+1) + path[k][j];
                    }
                }
            }
        }

        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                bw.write((arr[i][j]==INF) ? "0 ": arr[i][j]+" ");
            }
            bw.newLine();
        }

        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(path[i][j]==null){
                    bw.write("0");
                } else {
                    bw.write(Math.max(1,path[i][j].split(" ").length)+1+" ");
                    bw.write((i+1)+path[i][j]+(j+1));
                }
                bw.newLine();
            }
        }
        bw.flush();
    }
}