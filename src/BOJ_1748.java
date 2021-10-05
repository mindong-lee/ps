import java.util.Scanner;

public class BOJ_1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans=0;
        int cnt=1;
        while(N>=pow(10,cnt)){
            ans += (pow(10,cnt)-pow(10,cnt-1))*(cnt);
            cnt++;
        }

        ans += (N-pow(10,cnt-1)+1)*(cnt);

        System.out.println(ans);
    }
    public static int pow(int a, int b){
        return (int)Math.pow(a,b);
    }
}
