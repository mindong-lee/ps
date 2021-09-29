import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 문제를 보고 위상 정렬이 떠올랐다. (직접적인 연관은 없지만..)
* DFS로 각 노드를 탐색하면서
* 탐색 중 자신을 거쳐 들어온 노드의 개수(in)와
* 노드에서 탐색을 시작하여 찾은 노드의 개수(out)를 더해서 N-1개가 되면
* 모든 학생과 키 비교를 할 수 있다고 생각했다.
* AC를 받았지만 수행 시간이 맘에 안 들어서 찾아보니 Floyd-warshall 풀이도 존재했다.
* */

public class BOJ_2458_DFS {
    private static class Node {
        int v;
        Node next;

        public Node(int v, Node n) {
            this.v = v;
            this.next = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[] adjList = new Node[N+1];
        int[] in = new int[N+1];
        int[] out = new int[N+1];
        boolean[] visit;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
        }

        for(int i=1; i<=N; i++) {
            visit=dfs(adjList, N, i, in, new boolean[N + 1]);
            for(int j=1; j<=N; j++){
                if(visit[j]) out[i]++;
            }
        }

        int ans = 0;
        for(int i=1; i<=N; i++){
            if(in[i]+out[i]==N){
                ans++;
            }
        }
        System.out.println(ans);
    }
    private static boolean[] dfs(Node[] adjList, int N, int v, int[] in, boolean[] visit){
        visit[v]=true;
        for(Node tmp = adjList[v]; tmp!=null; tmp=tmp.next){
            if(!visit[tmp.v]) {
                in[tmp.v]++;
                visit = dfs(adjList, N, tmp.v, in, visit);
            }
        }
        return visit;
    }
}
