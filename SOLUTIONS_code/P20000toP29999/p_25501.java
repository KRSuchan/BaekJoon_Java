package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_25501 {
    //    p_25501 : 재귀의 귀재
    static int n;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while (T-- > 0) {
            n = 0;
            sb.append(isPalindrome(br.readLine())).append(" ").append(n).append("\n");
        }
        System.out.println(sb);
    }

    private static int recursion(String s, int l, int r) {
        n++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    private static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}
