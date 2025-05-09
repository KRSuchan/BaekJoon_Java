package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_17070 {
    //    p_17070 : 파이프 옮기기 1
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] wall = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                wall[i][j] = st.nextToken().equals("1");
            }
        }
        int[][][] dp = new int[N][N][3];
        for (int i = 1; i < N && !wall[0][i]; i++) {
            dp[0][i][0] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (wall[i][j]) continue;
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
                if (!wall[i - 1][j] && !wall[i][j - 1])
                    dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
            }
        }
        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }
}
