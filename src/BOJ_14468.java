import java.util.Scanner;

public class BOJ_14468 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        Info[] arr = new Info[26];

        for(int i=0; i<52; i++){
            int id = s[i] - 'A';
            if(arr[id]==null) arr[id] = new Info(i,0);
            else arr[id].e = i;
        }

        int ans = 0;
        for(int i=0; i<26; i++){
            for(int j=i+1; j<26; j++){
                int s1 = arr[i].s;
                int e1 = arr[i].e;
                int s2 = arr[j].s;
                int e2 = arr[j].e;
                if(s1<s2 && s2<e1 && e1<e2) ans++;
            }
        }

        System.out.println(ans);
    }
    private static class Info{
        int s;
        int e;
        public Info(int s, int e){
            this.s=s;
            this.e=e;
        }
    }
}
