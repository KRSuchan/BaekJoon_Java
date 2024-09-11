package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_2206 {
    //    p_2206 : 벽 부수고 이동하기
    static boolean[][] map;
    static int N, M;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) == '0';
            }
        }
        System.out.print(bfs());
    }

    private static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2]; // 하나라도 부순 벽의 dimension이 생김
        q.add(new Pos(0, 0, 1, false));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            if (pos.x == N - 1 && pos.y == M - 1) return pos.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny]) { // 길
                    if (!pos.destroyed && !visited[nx][ny][0]) {
                        q.add(new Pos(nx, ny, pos.cnt + 1, false));
                        visited[nx][ny][0] = true;
                    } else if (pos.destroyed && !visited[nx][ny][1]) {
                        q.add(new Pos(nx, ny, pos.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                } else { // 벽
                    if (!pos.destroyed) {
                        q.add(new Pos(nx, ny, pos.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        return -1;
    }

    static class Pos {
        int x, y;
        int cnt;
        boolean destroyed;

        public Pos(int x, int y, int cnt, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }
}
