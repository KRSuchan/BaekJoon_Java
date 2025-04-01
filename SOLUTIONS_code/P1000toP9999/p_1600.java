package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1600 {
    //    p_1600 : 말이 되고픈 원숭이
    static int K, W, H, result = -1;
    static int[][] map;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        var st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[W][H];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(result);
    }

    public static void bfs() {
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dxdk = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] dydk = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        boolean[][][] visited = new boolean[W][H][K + 1];
        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, K, 0));
        visited[0][0][K] = true;
        while (!q.isEmpty()) {
            Monkey cur = q.poll();
            if (cur.x == W - 1 && cur.y == H - 1) {
                result = cur.cnt;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nk = cur.k;
                int cnt = cur.cnt;
                if (nx >= 0 && ny >= 0 && nx < W && ny < H && !visited[nx][ny][nk] && map[nx][ny] != 1) {
                    visited[nx][ny][nk] = true;
                    q.add(new Monkey(nx, ny, nk, cnt + 1));
                }
            }
            if (cur.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + dxdk[i];
                    int ny = cur.y + dydk[i];
                    int nk = cur.k - 1;
                    int cnt = cur.cnt;
                    if (nx >= 0 && ny >= 0 && nx < W && ny < H && !visited[nx][ny][nk] && map[nx][ny] != 1) {
                        visited[nx][ny][nk] = true;
                        q.add(new Monkey(nx, ny, nk, cnt + 1));
                    }
                }
            }
        }

    }

    static class Monkey {
        int x, y, k;
        int cnt;

        public Monkey(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}
