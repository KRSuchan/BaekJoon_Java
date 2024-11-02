package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_2293 {
    //    p_2293 : 동전 1
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        ArrayList<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            if (c <= k) coins.add(c);
        }
        for (int coin : coins) {
            dp[coin]++;
            for (int i = coin + 1; i <= k; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        System.out.println(dp[k]);
    }

}
