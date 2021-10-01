import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5052_Trie_debug {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        outer:
        for(int t=0; t<T; t++){
            Trie trie = new Trie();
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                if(!trie.insert(br.readLine())){
                    bw.write("NO\n");
                    continue outer;
                }
            }
            bw.write("YES\n");
        }
        bw.flush();
    }

    private static class Trie{
        Node root;

        public Trie(){
            this.root = new Node();
        }

        public boolean insert(String s){
            Node cur = root;
            for(int i=0; i<s.length(); i++){
                int id = s.charAt(i)-'0';
                if(cur.child[id]==null){
                    cur.child[id] = new Node();
//                    if(cur.flag) return false;
                } else {
                    if(cur.child[id].flag && i != s.length()-1){
                        return false;
                    }
                    if(i==s.length()-1){
                        return false;
                    }
                }

                cur = cur.child[id];
            }
//            for(Node n : cur.child){
//                if(n!=null) return false;
//            }
            cur.flag=true;
            return true;
        }
    }

    private static class Node{
        boolean flag;
        Node[] child;

        public Node(){
            this.flag = false;
            this.child = new Node[10];
        }
    }
}
