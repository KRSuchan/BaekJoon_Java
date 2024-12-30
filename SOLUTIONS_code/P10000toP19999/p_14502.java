package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_14502 {
    //    p_14502 : 연구소
    static int r, c;
    static int[][] map;
    static int result = Integer.MIN_VALUE;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);

        System.out.println(result);
    }

    // 벽 세우기
    private static void dfs(int walls) {
        if (walls == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(walls + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 전파
    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] copy = new int[r][c];
        for (int i = 0; i < r; i++) {
            copy[i] = Arrays.copyOf(map[i], c);
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int dr = row + dx[i];
                int dc = col + dy[i];
                if (dr >= 0 && dr < r && dc >= 0 && dc < c) {
                    if (copy[dr][dc] == 0) {
                        q.offer(new int[]{dr, dc});
                        copy[dr][dc] = 2;
                    }
                }
            }
        }
        countSafeArea(copy);
    }

    private static void countSafeArea(int[][] copy) {
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (copy[i][j] == 0) {
                    res++;
                }
            }
        }
        result = Math.max(res, result);
    }
}
