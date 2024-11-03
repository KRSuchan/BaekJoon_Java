package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_7579 {
    //    p_7579 : 앱
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[][] apps = new int[N + 1][2];
        st1 = new StringTokenizer(br.readLine());
        var st2 = new StringTokenizer(br.readLine());
        int size = 0;
        for (int i = 1; i <= N; i++) {
            apps[i][0] = Integer.parseInt(st1.nextToken());
            apps[i][1] = Integer.parseInt(st2.nextToken());
            size += apps[i][1];
        }
        int[][] dp = new int[N + 1][size + 1];
        int res = 0;
        for (int i = 1; i <= N; i++) {
            int m = apps[i][0];
            int c = apps[i][1];
            for (int j = 0; j <= size; j++) {
                if (j >= c)
                    dp[i][j] = Math.max(dp[i - 1][j - c] + m, dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        for (int i = 0; i <= size; i++) {
            if (dp[N][i] >= M) {
                res = i;
                break;
            }
        }
        System.out.println(res);

    }

}
