package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_2146 {
    //    p_2146 : 다리 만들기
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 구분하기
        int island = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)
                    dfs(i, j, island++);
            }
        }
        // 최단 다리 놓기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1)
                    bfs(i, j, map[i][j]);
            }
        }
        System.out.println(min);
    }

    private static void bfs(int y, int x, int island) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][N];
        visited[y][x] = true;
        q.add(new int[]{y, x, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curY = cur[0];
            int curX = cur[1];
            int cnt = cur[2];
            if (map[curY][curX] != 0 && map[curY][curX] != island)
                min = Math.min(min, cnt - 1);
            if (cnt > min)
                return;
            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (map[ny][nx] == island) {
                    continue;
                }
                if (visited[ny][nx]) continue;

                q.add(new int[]{ny, nx, cnt + 1});
                visited[ny][nx] = true;
            }
        }
    }

    private static void dfs(int y, int x, int island) {
        visited[y][x] = true;
        map[y][x] = island;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (visited[ny][nx] || map[ny][nx] != 1) {
                continue;
            }
            dfs(ny, nx, island);
        }
    }


}
