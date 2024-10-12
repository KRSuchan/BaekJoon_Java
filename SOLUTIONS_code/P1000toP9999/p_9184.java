package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_9184 {
    //    p_9184 : 신나는 함수 실행
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][][] w = new int[21][21][21];

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        w[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        w[i][j][k] = w[i][j][k - 1] + w[i][j - 1][k - 1] - w[i][j - 1][k];
                    } else {
                        w[i][j][k] = w[i - 1][j][k] + w[i - 1][j - 1][k] + w[i - 1][j][k - 1] - w[i - 1][j - 1][k - 1];
                    }
                }
            }
        }
        while (true) {
            var st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");

            int[] cond = condition(a, b, c);
            sb.append(w[cond[0]][cond[1]][cond[2]]);

            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[] condition(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return new int[]{0, 0, 0};
        }
        if (a > 20 || b > 20 || c > 20) {
            return new int[]{20, 20, 20};
        }
        return new int[]{a, b, c};
    }
}
