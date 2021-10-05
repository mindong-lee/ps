import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10972_NextPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        if(nextPermutation(arr)){
            for(int e : arr) System.out.print(e+" ");
        } else {
            System.out.println(-1);
        }
    }

    private static boolean nextPermutation(int[] numbers) {
        int N = numbers.length;
        //뒤쪽부터 탐색하며 교환위치(i-1) 찾기 (i:꼭대기)
        int i = N-1;
        while(i>0 && numbers[i-1]>=numbers[i]) i--;

        if(i==0) return false;
        //뒤쪽부터 탐색하며 교환위치(i-1)보다 큰 처음으로 나오는 값 위치(j) 찾기
        //j는 항상 존재하므로 예외 처리 안 해도 됨
        int j = N-1;
        while(numbers[i-1]>=numbers[j]) j--;

        //두 위치(i-1,j) 교환
        swap(numbers,i-1,j);

        //꼭대기 위치(i)부터 맨 뒤까지 오름차순 정렬
        int k = N-1;
        while(i<k){
            swap(numbers, i++, k--);
        }
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
