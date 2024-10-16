package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_25682 {
    //    p_25682 : 체스판 다시 칠하기 2

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean coloring = false;
        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                char c = s.charAt(j - 1);
                if ((c == 'B' && coloring) || (c == 'W' && !coloring)) {
                    map[i][j] = map[i][j - 1] + 1;
                } else {
                    map[i][j] = map[i][j - 1];
                }
                coloring = !coloring;
            }
            for (int j = 1; j <= M; j++) {
                map[i][j] += map[i - 1][j];
            }
            if (M % 2 == 0) coloring = !coloring;
        }
        int min = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int res = map[i][j] - map[i - K][j] - map[i][j - K] + map[i - K][j - K];
                min = Math.min(min, Math.min(res, K * K - res));
            }
        }
        System.out.println(min);
    }
}
