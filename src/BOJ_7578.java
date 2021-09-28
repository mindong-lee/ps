import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 키워드 : inversion
// natural order가 아닌 수들의 개수
// 참고 자료 : https://www.quora.com/How-can-I-efficiently-compute-the-number-of-swaps-required-by-slow-sorting-methods-like-insertion-sort-and-bubble-sort-to-sort-a-given-array
// inversion의 자료형을 long으로!

public class BOJ_7578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int a = Integer.parseInt(st.nextToken());
            map.put(a,i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            arr.add(map.get(a));
        }
        Info i = merge_sort(arr);

        System.out.println(i.inv);
    }
    private static Info merge_sort(List<Integer> arr){
        if(arr.size()<=1) return new Info(0,arr);
        int mid = arr.size()/2;
        Info left = merge_sort(arr.subList(0,mid));
        Info right = merge_sort(arr.subList(mid,arr.size()));
        Info merged = merge(left.arr, right.arr);
        long inv = left.inv + right.inv + merged.inv;

        return new Info(inv, merged.arr);
    }
    private static Info merge(List<Integer> left, List<Integer> right){
        List<Integer> ret = new ArrayList<>();
        int i=0,j=0;
        long inv=0;
        while(i<left.size() && j<right.size()){
            if(left.get(i) <= right.get(j)){
                inv += j;
                ret.add(left.get(i));
                i++;
            } else {
                ret.add(right.get(j));
                j++;
            }
        }
        inv += (long)j*(left.size()-i);
        ret.addAll(left.subList(i,left.size()));
        ret.addAll(right.subList(j,right.size()));

        return new Info(inv,ret);
    }
    private static class Info{
        long inv;
        List<Integer> arr;
        public Info(long inv, List<Integer> arr){
            this.inv=inv;
            this.arr=arr;
        }
    }
}
