package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_4179 {
    //    p_4179 : 불!
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        int[][] fire = new int[R][C]; // 불 번짐 시간의 맵
        int[][] jihoon = new int[R][C]; // 지훈 이동 시간의 맵
        Queue<Point> fq = new LinkedList<>();
        Queue<Point> jq = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String miro = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = miro.charAt(j);
                fire[i][j] = -1;
                jihoon[i][j] = -1;
                if (map[i][j] == 'F') {
                    fq.add(new Point(i, j));
                    fire[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    jq.add(new Point(i, j));
                    jihoon[i][j] = 0;
                }
            }
        }

        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        // 불 bfs
        while (!fq.isEmpty()) {
            Point cur = fq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (fire[nx][ny] >= 0 || map[nx][ny] == '#') continue;
                fire[nx][ny] = fire[cur.x][cur.y] + 1;
                fq.add(new Point(nx, ny));
            }
        }
        // 지훈 bfs
        while (!jq.isEmpty()) {
            Point cur = jq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    System.out.println(jihoon[cur.x][cur.y] + 1);
                    return;
                }
                if (jihoon[nx][ny] >= 0 || map[nx][ny] == '#') continue;
                if (fire[nx][ny] != -1
                        && fire[nx][ny] <= jihoon[cur.x][cur.y] + 1) continue;
                jihoon[nx][ny] = jihoon[cur.x][cur.y] + 1;
                jq.add(new Point(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
