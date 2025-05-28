package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_2098 {
    //    p_2098 : 외판원 순회
    public static final int MAX = 987654321;
    public static int N, fullBit;
    public static int[][] dp, map;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp = 방문하게될 도시의 비용 + 시작도시로 돌아가는 비용
        // i = 현재 도시 , j = 방문한 도시 비트열
        fullBit = (1 << N) - 1;
        dp = new int[N][fullBit];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(0, 1));
    }

    private static int dfs(int city, int visitBit) {
        if (visitBit == fullBit) { // 모든 도시 방문
            if (map[city][0] == 0) return MAX;
            return map[city][0]; // 현재 도시 -> 시작 도시
        }
        if (dp[city][visitBit] != -1) {
            return dp[city][visitBit];
        }
        dp[city][visitBit] = MAX;
        for (int i = 0; i < N; i++) {
            // 이미 방문한 곳 && 갈 수 없는 곳
            if (map[city][i] == 0 || (visitBit & (1 << i)) != 0) continue;
            int next = visitBit | (1 << i);
            dp[city][visitBit] = Math.min(
                    dp[city][visitBit],
                    dfs(i, next) + map[city][i]
            );
        }
        return dp[city][visitBit];
    }
}
