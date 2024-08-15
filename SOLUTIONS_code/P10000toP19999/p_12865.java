package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_12865 {
    //    p_12865 : 평범한 배낭
    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Item[] items = new Item[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // alg
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) { // i : dp 번호
            for (int j = 1; j <= k; j++) { // 무게
                if (items[i].w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i].w] + items[i].v);
                }
            }
        }
        // output
        System.out.println(dp[n][k]);
    }

    static class Item {
        int w;
        int v;

        Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
