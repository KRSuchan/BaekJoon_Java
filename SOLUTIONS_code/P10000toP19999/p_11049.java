package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11049 {
    //    p_11049 : 행렬 곱셈 순서
    static int row = 0, col = 1;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] mat = new int[N][2];
        for (int i = 0, j = 1; i < N; i++, j++) {
            var st = new StringTokenizer(br.readLine());
            mat[i][row] = Integer.parseInt(st.nextToken());
            mat[i][col] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][N];
        for (int x = 1; x < N; x++) {
            for (int i = 0, j = x; j < N; i++, j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int mal = mat[i][row] * mat[j][col];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], mal * mat[k][col] + dp[i][k] + dp[k + 1][j]);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}
