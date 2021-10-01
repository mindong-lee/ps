import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2631_LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> dp = new ArrayList<>();
        for(int i=0; i<N; i++) {
            int a = sc.nextInt();
            int idx = binarySearch(dp, a);
            if(idx>=dp.size()) dp.add(a);
            else dp.set(idx,a);
        }
        System.out.println(N-dp.size());
    }
    private static int binarySearch(List<Integer> arr, int target){
        int left = -1;
        int right = arr.size();
        while(left+1<right){
            int mid = (left+right)>>>1;
            if(arr.get(mid)<target){
                left=mid;
            } else {
                right=mid;
            }
        }
        return right;
    }
}
