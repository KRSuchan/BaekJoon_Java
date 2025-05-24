package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1051 {
    //    p_1051 : 숫자 정사각형
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int res = 0;
        int size = 0;
        while (size < N && size < M) {
            for (int i = 0; i < N - size; i++) {
                for (int j = 0; j < M - size; j++) {
                    if (map[i][j] == map[i + size][j]
                            && map[i + size][j] == map[i][j + size]
                            && map[i][j + size] == map[i + size][j + size])
                        res = Math.max(res, (size + 1) * (size + 1));
                }
            }
            size++;
        }
        System.out.println(res);
    }
}
