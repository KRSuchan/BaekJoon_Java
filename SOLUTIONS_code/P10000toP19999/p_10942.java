package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10942 {
    //    p_10942 : 팰린드롬?
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N + 1];
        boolean[][] dp = new boolean[N + 1][N + 1];
        var st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++)
            dp[i][i] = true;
        for (int i = 1; i <= N - 1; i++)
            if (input[i] == input[i + 1]) dp[i][i + 1] = true;
        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (input[j] == input[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] ? "1" : "0").append("\n");
        }
        System.out.println(sb);
    }
}
