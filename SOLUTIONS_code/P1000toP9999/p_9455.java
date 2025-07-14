package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_9455 {
    //    p_9455 : 박스
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[m][n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 0; i < n; i++)
                for (int j = m - 1; j >= 0; j--)
                    if (map[j][i] == 0)
                        for (int k = j - 1; k >= 0; k--)
                            if (map[k][i] == 1) {
                                map[j][i] = 1;
                                map[k][i] = 0;
                                cnt += j - k;
                                break;
                            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
