import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BOJ_14891 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);
        int[] wheel = new int[5];
        for(int i=1; i<=4; i++)
            wheel[i] = dec(sc.next());

        int k = sc.nextInt();

        for(int i=0; i<k; i++){
            int[] state = new int[5];
            int n = sc.nextInt();
            int d = sc.nextInt();
            state[n]=d;

            for(int j=n; j<4; j++){
                if((((wheel[j]>>5)&1)^((wheel[j+1]>>1)&1))==1){
                    state[j+1]=-state[j];
                }
            }
            for(int j=n-1; j>=1; j--){
                if((((wheel[j]>>5)&1)^((wheel[j+1]>>1)&1))==1){
                    state[j]=-state[j+1];
                }
            }
            for(int j=1; j<=4; j++){
                wheel[j]=rotate(wheel[j],state[j]);
            }

        }

        int ans = 0;
        for(int i=1; i<=4; i++){
            if(wheel[i]>=128) ans += Math.pow(2,i-1);
        }

        System.out.println(ans);
    }
    private static int rotate(int wheel, int state){
        int tmp;
        if(state==0) return wheel;

        if(state>0) {
            tmp = wheel & 1;
            wheel = (wheel>>1)&255;
            wheel += (tmp<<7);
        }
        else {
            tmp = (wheel>>7) & 1;
            wheel = (wheel<<1)&255;
            wheel += tmp;
        }
        return wheel;
    }
    private static int dec(String s){
        int ret=0;
        int cnt=1;
        for(int i=s.length()-1; i>=0; i--){
            ret += (s.charAt(i)-'0')*cnt;
            cnt*=2;
        }
        return ret;
    }
}
