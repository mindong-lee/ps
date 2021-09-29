import java.io.*;
import java.math.BigInteger;

public class BOJ_23046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();
        char[] query = br.readLine().toCharArray();
        boolean isReverse = false;

        BigInteger ret = new BigInteger("0");
        for(int i=0; i<query.length; i++){
            if(query[i]=='-'){
                isReverse = !isReverse;
            } else {
                if (isReverse) {
                    sb.insert(0,query[i]);
                    rsb.append(query[i]);
                    ret = ret.add(new BigInteger(rsb.toString()));
                } else {
                    sb.append(query[i]);
                    rsb.insert(0,query[i]);
                    ret = ret.add(new BigInteger(sb.toString()));
                }
            }
        }
        bw.write(ret.toString());
        bw.flush();
    }
}
