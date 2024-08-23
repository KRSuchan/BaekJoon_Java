package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_27982 {
    //    p_27982 : 큐브 더미
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][][] cube = new boolean[n + 1][n + 1][n + 1];
        for (int idx = 0; idx < m; idx++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            cube[i][j][k] = true;
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    if (cube[i][j][k]
                            && cube[i + 1][j][k] && cube[i - 1][j][k]
                            && cube[i][j + 1][k] && cube[i][j - 1][k]
                            && cube[i][j][k + 1] && cube[i][j][k - 1]) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
