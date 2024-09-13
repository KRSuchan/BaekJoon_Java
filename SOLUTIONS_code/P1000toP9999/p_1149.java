package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1149 {
    //    p_1149 : RGB거리

    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        int r = 0, g = 1, b = 2;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][r] = Integer.parseInt(st.nextToken());
            cost[i][g] = Integer.parseInt(st.nextToken());
            cost[i][b] = Integer.parseInt(st.nextToken());
        }
        // alg
        for (int i = 1; i < n; i++) {
            cost[i][r] += Math.min(cost[i - 1][g], cost[i - 1][b]);
            cost[i][g] += Math.min(cost[i - 1][r], cost[i - 1][b]);
            cost[i][b] += Math.min(cost[i - 1][r], cost[i - 1][g]);
        }
        // output
        System.out.print(Math.min(cost[n - 1][r], Math.min(cost[n - 1][g], cost[n - 1][b])));
    }
}
