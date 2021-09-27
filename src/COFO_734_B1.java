import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class COFO_734_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int[] check = new int[26];
            int red = 0;
            int green = 0;
            char[] arr = br.readLine().toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (check[arr[i] - 'a'] < 2) {
                    check[arr[i] - 'a']++;
                    if (red > green) green++;
                    else red++;
                }
            }
            System.out.println(Math.min(red, green));
        }
    }
}
