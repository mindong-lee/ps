import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1450 {
    static int N, C, ans;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int[][] nCr = new int[31][31];
        for(int i=1; i<=30; i++){
            for(int j=0; j<=30; j++){
                if(i==j) nCr[i][j]=1;
                else nCr[i][j]=nCr[i-1][j-1]+nCr[i-1][j];
            }
        }

        int left = 0;
        int right = (1<<N)+1;
        while(left+1<right){
            int mid = left + right >>> 1;
            int sum = 0;
            int cnt = 0;
            while(sum + nCr[N][cnt]<mid && cnt<=N){
                cnt++;
            }
            combi(arr, 0, 0, 0, mid-sum);
        }

        System.out.println(ans);
    }
    private static int combi(int[] arr, int cnt, int start, int sum, int res){
        if(sum<=C) res--;
        if(res!=0) {
            for (int i = start; i < N; i++) {
                sum += arr[i];
                if (sum <= C) {
                    combi(arr, cnt + 1, i + 1, sum, res);
                    sum -= arr[i];
                } else {
                    break;
                }
            }
        }
        return sum;
    }
}
