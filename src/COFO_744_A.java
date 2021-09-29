import java.util.Scanner;

public class COFO_744_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            String s = sc.next();
            int acnt=0;
            int bcnt=0;
            int ccnt=0;
            for(int i=0; i<s.length(); i++){
                switch (s.charAt(i)){
                    case 'A':
                        acnt++;
                        break;
                    case 'B':
                        bcnt++;
                        break;
                    case 'C':
                        ccnt++;
                        break;
                }
            }
            if(bcnt==acnt+ccnt){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
