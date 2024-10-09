package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_2447 {
    //    p_2447 : 별 찍기 - 10
    static char[][] arr;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        star(0, 0, N, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void star(int r, int c, int N, boolean blank) {
        if (blank) {
            for (int i = r; i < r + N; i++) {
                for (int j = c; j < c + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if (N == 1) {
            arr[r][c] = '*';
            return;
        }
        int nextN = N / 3;
        int cnt = 0;
        for (int i = r; i < r + N; i += nextN) {
            for (int j = c; j < c + N; j += nextN) {
                cnt++;
                star(i, j, nextN, cnt == 5);
            }
        }
    }
}
