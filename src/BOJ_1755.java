import java.util.*;

public class BOJ_1755 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<String,Integer> map = new HashMap<>();
        List<String> arr = new ArrayList<>();
        for(int i=N; i<=M; i++){
            String s = convert(i);
            map.put(s,i);
            arr.add(s);
        }
        Collections.sort(arr);
        for(int i=0; i<arr.size(); i++){
            System.out.print(map.get(arr.get(i)));
            if(i%10==9) System.out.println();
            else System.out.print(" ");
        }
    }
    private static String convert(int a){
        String[] arr = {"zero","one","two","three","four","five",
        "six","seven","eight","nine"};
        String ret = "";
        if(a<10) ret = arr[a];
        else {
            ret += arr[a/10];
            ret += " ";
            ret += arr[a%10];
        }
        return ret;
    }
}
