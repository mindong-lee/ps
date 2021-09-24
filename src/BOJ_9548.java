import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringBuilder sb = new StringBuilder(br.readLine());
            StringTokenizer st;
            outer:
            while(true){
                st = new StringTokenizer(br.readLine());

                switch (st.nextToken()){
                    case "P":
                        int b = Integer.parseInt(st.nextToken());
                        int c = Integer.parseInt(st.nextToken());
                        bw.write(sb.substring(b,c+1)+"\n");
                        break;
                    case "I":
                        String d = st.nextToken();
                        int e = Integer.parseInt(st.nextToken());
                        sb.insert(e, d);
                        break;
                    case "END":
                        break outer;
                }
            }
        }
        bw.flush();
    }
}
