package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2096 {
    //    p_2096 : 내려가기
    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // alg
        Node[][] dp = new Node[n][3];
        dp[0][0] = new Node(map[0][0], map[0][0]);
        dp[0][1] = new Node(map[0][1], map[0][1]);
        dp[0][2] = new Node(map[0][2], map[0][2]);
        int min;
        int max;
        for (int i = 1; i < n; i++) {
            // left
            min = Math.min(dp[i - 1][0].min, dp[i - 1][1].min) + map[i][0];
            max = Math.max(dp[i - 1][0].max, dp[i - 1][1].max) + map[i][0];
            dp[i][0] = new Node(min, max);
            // center
            min = Math.min(dp[i - 1][0].min, Math.min(dp[i - 1][1].min, dp[i - 1][2].min)) + map[i][1];
            max = Math.max(dp[i - 1][0].max, Math.max(dp[i - 1][1].max, dp[i - 1][2].max)) + map[i][1];
            dp[i][1] = new Node(min, max);
            // right
            min = Math.min(dp[i - 1][1].min, dp[i - 1][2].min) + map[i][2];
            max = Math.max(dp[i - 1][1].max, dp[i - 1][2].max) + map[i][2];
            dp[i][2] = new Node(min, max);
        }
        min = Math.min(dp[n - 1][0].min, Math.min(dp[n - 1][1].min, dp[n - 1][2].min));
        max = Math.max(dp[n - 1][0].max, Math.max(dp[n - 1][1].max, dp[n - 1][2].max));
        // output
        System.out.print(max + " " + min);
    }

    static class Node {
        int min, max;

        Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
