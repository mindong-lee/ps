// 문자열 Pattern Matching
// KMP

import java.io.*;
import java.util.*;
public class BOJ_1786_KMP {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine(); // text
        String p = br.readLine(); // pattern
        List<Integer> ans = kmp(s,p);
        bw.write(ans.size()+"\n");
        for(int e : ans) bw.write(e+1+" ");
        bw.flush();
    }

    // pattern의 index를 저장하는 List를 반환.
    // List의 사이즈가 찾으려는 pattern의 갯수를 의미함.
    private static List<Integer> kmp(String s, String p){
        List<Integer> ret = new ArrayList<>();

        //부분일치 배열 생성
        //패턴과 패턴을 matching 한다고 생각해.
        //i는 텍스트의 index
        //j는 패턴의 index
        int[] pi = new int[p.length()];
        int j=0;
        //1부터 시작함. 왜?
        for(int i=1; i<p.length(); i++){
            while(j>0 && p.charAt(i) != p.charAt(j))
                j = pi[j-1];
            if(p.charAt(i)==p.charAt(j)) pi[i] = ++j;
            //else pi[i]=0; 들어가야 하는데 0으로 초기화되므로 생략.
        }
        //부분일치 배열로 pattern 매칭
        j=0;
        for(int i=0; i<s.length(); i++){
            while(j>0 && s.charAt(i) != p.charAt(j))
                j=pi[j-1];
            if(s.charAt(i)==p.charAt(j)){
                if(j==p.length()-1){
                    ret.add(i-p.length()+1);
                    j=pi[j];
                } else {
                    j++;
                }
            }
        }
        return ret;
    }
}