package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11066 {
    //    p_11066 : 파일 합치기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            int[] sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];
            var st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                int x = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + x;
            }

            for (int x = 1; x <= K; x++) {
                for (int i = 1; i + x <= K; i++) {
                    int j = i + x;
                    dp[i][j] = 1_000_000_000;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] += sum[j] - sum[i - 1];
                }
            }
//            for (int x = 1; x < K; x++) {
//                for (int i = 1; i <= K; i++) {
//                    for (int j = i + x; j <= K; j++) {
//                        dp[i][j] = Integer.MAX_VALUE;
//                        for (int k = i; k < j; k++) {
//                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
//                        }
//                        dp[i][j] += sum[j] - sum[i - 1];
//                    }
//                }
//            }
            sb.append(dp[1][K]).append("\n");
        }
        System.out.println(sb);
    }
}
