package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_9465 {
    //    p_9465 : 스티커
    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[n][2];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                stickers[i][0] = Integer.parseInt(st1.nextToken());
                stickers[i][1] = Integer.parseInt(st2.nextToken());
            }
            // alg
            int[][] dp = new int[n][2];
            dp[0][0] = stickers[0][0];
            dp[0][1] = stickers[0][1];
            if (n > 1) {
                dp[1][0] = stickers[1][0] + stickers[0][1];
                dp[1][1] = stickers[1][1] + stickers[0][0];
            }
            for (int i = 2; i < n; i++) {
                int a = stickers[i][0];
                int b = stickers[i][1];
                dp[i][0] = Math.max(a + dp[i - 1][1], Math.max(a + dp[i - 2][0], a + dp[i - 2][1]));
                dp[i][1] = Math.max(b + dp[i - 1][0], Math.max(b + dp[i - 2][1], b + dp[i - 2][0]));
            }
            sb.append(Math.max(dp[n - 1][0], dp[n - 1][1])).append("\n");
        }
        // output
        System.out.print(sb);
    }
}
