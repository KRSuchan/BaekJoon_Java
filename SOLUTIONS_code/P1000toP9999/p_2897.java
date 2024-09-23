package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2897 {
    //    p_2897 : 몬스터 트럭
    static char[][] matrix;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        matrix = new char[C][R];
        int[] cars = new int[5];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                matrix[j][i] = s.charAt(j);
            }
        }
        for (int j = 0; j < R - 1; j++) {
            for (int i = 0; i < C - 1; i++) {
                int c = spaceNumber(i, j);
                if (c == -1) continue;
                cars[c]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : cars) {
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }

    private static int spaceNumber(int x, int y) {
        int cars = 0;
        int[] dx = {0, 1, 0, 1};
        int[] dy = {0, 0, 1, 1};
        for (int i = 0; i < 4; i++) {
            switch (matrix[x + dx[i]][y + dy[i]]) {
                case '#':
                    return -1;
                case 'X':
                    cars++;
            }
        }
        return cars;
    }
}
