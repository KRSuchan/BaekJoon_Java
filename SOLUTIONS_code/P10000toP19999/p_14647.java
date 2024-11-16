package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14647 {
    //    p_14647 : 준오는 조류혐오야!!
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int[][] mat = new int[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                int x = Integer.parseInt(st.nextToken());
                int nines = 0;
                while (x != 0) {
                    nines = (x % 10 == 9) ? nines + 1 : nines;
                    x /= 10;
                }
                mat[i][j] = nines;
                res += mat[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < rows; i++) {
            int cnt = 0;
            for (int j = 0; j < cols; j++) {
                cnt += mat[i][j];
            }
            max = Math.max(max, cnt);
        }
        for (int i = 0; i < cols; i++) {
            int cnt = 0;
            for (int j = 0; j < rows; j++) {
                cnt += mat[j][i];
            }
            max = Math.max(max, cnt);
        }

        System.out.println(res - max);
    }
}
