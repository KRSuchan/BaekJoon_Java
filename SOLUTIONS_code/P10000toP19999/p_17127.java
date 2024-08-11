package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_17127 {
    //    p_17127 : 벚꽃이 정보섬에 피어난 이유
    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] blossom = new int[n];
        for (int i = 0; i < n; i++) {
            blossom[i] = Integer.parseInt(st.nextToken());
        }
        // alg
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * blossom[i - 1];
        }
        int max = 0;
        for (int i = 1; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = dp[i] + dp[j] / dp[i] + dp[k] / dp[j] + dp[n] / dp[k];
                    max = Math.max(max, sum);
                }
            }
        }
        // output
        System.out.println(max);
    }
}
