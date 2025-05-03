package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_9252 {
    //    p_9252 : LCS 2
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        sb.append(dp[len1][len2]).append("\n");

        Stack<Character> stack = new Stack<>();
        int i = len1, j = len2;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) i--;
            else if (dp[i][j] == dp[i][j - 1]) j--;
            else {
                stack.add(str1.charAt(i - 1));
                i--;
                j--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
