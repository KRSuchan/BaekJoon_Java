package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_2533 {
    //    p_2533 : 사회망 서비스(SNS)
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int now) {
        visited[now] = true;
        dp[now][1] = 1;
        for (int x : tree.get(now)) {
            if (!visited[x]) {
                dfs(x);
                dp[now][0] += dp[x][1];
                dp[now][1] += Math.min(dp[x][0], dp[x][1]);
            }
        }
    }
}
