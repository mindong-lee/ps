import java.util.Scanner;

public class COFO_731_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        outer:
        for (int t = 0; t < T; t++) {
            String s = sc.next();
            if (!isValid(s.toCharArray())) {
                System.out.println("NO");
                continue outer;
            }
            System.out.println("YES");
        }
    }

    private static boolean isValid(char[] s) {
        int idx = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'a') {
                idx = i;
                break;
            }
        }
        if (idx == -1) return false;
        int left, right;
        left = right = idx;
        char cur = 'b';
        while ((right - left) < s.length - 1) {
            if (left - 1 >= 0 && s[left - 1] == cur) {
                left--;
            } else if (right + 1 < s.length && s[right + 1] == cur) {
                right++;
            } else {
                return false;
            }
            cur++;
        }

        return true;
    }
}
