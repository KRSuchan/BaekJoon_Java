package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_1912 {
    //    p_1912 : 연속합
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        var st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + x, x);
            max = Math.max(max, dp[i]);
        }
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "");
        bw.flush();
    }
}
