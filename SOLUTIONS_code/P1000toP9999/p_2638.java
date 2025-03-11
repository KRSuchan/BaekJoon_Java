package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_2638 {
    //    p_2638 : 치즈
    static boolean[][] visited;
    static int[][] map;
    static int N, M, cheeseCnt;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Point> cheese;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cheese = new ArrayList<>();
        cheeseCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese.add(new Point(i, j));
                    cheeseCnt++;
                }
            }
        }
        int time = 0;
        while (cheeseCnt > 0) {
            time++;
            visited = new boolean[N][M];
            bfs();
            melting();
        }
        System.out.println(time);
    }

    private static void melting() {
        for (int i = 0; i < cheese.size(); i++) {
            int x = cheese.get(i).x;
            int y = cheese.get(i).y;
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (map[nx][ny] == 2) cnt++;
            }
            if (cnt >= 2) {
                map[x][y] = 0;
                cheeseCnt--;
                cheese.remove(i);
                i--;
            }
        }
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visited[0][0] = true;
        map[0][0] = 2; // 외부는 2로 표기
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;
                map[nx][ny] = 2;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
