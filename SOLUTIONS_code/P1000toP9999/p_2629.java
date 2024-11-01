package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2629 {
    //    p_2629 : 양팔저울
    static boolean[][] dp = new boolean[31][40001];
    static int[] w;
    static int N;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        w = new int[N + 1];
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        dfs(0, 0);
        st = new StringTokenizer(br.readLine());
        var sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[N][b] ? 'Y' : 'N').append(' ');
        }
        System.out.println(sb);
    }

    private static void dfs(int idx, int weight) {
        if (dp[idx][weight]) return;
        dp[idx][weight] = true;
        if (idx == N) return;
        dfs(idx + 1, weight + w[idx]);
        dfs(idx + 1, weight);
        dfs(idx + 1, Math.abs(weight - w[idx]));
    }
}
