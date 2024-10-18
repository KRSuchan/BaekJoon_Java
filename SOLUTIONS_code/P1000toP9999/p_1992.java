package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1992 {
    //    p_1992 : 쿼드트리
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = (int) s.charAt(j) - '0';
            }
        }
        quadtree(0, 0, N);
        System.out.println(sb);
    }

    private static void quadtree(int x, int y, int depth) {
        if (isPossible(x, y, depth)) {
            sb.append(map[x][y]);
            return;
        }
        int next = depth / 2;
        sb.append("(");
        quadtree(x, y, next);
        quadtree(x, y + next, next);
        quadtree(x + next, y, next);
        quadtree(x + next, y + next, next);
        sb.append(")");
    }

    private static boolean isPossible(int x, int y, int depth) {
        int value = map[x][y];
        for (int i = x; i < x + depth; i++) {
            for (int j = y; j < y + depth; j++) {
                if (value != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
