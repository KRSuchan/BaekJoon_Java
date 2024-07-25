package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_7569 {
    //    p_7569 : 토마토
    static int[][][] matrix;
    static Queue<Tomato> q = new LinkedList<>();
    static int m;
    static int n;
    static int h;
    static boolean[][][] visited;

    public static void solution(String[] args) throws IOException {
//        input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 상자 가로 길이
        n = Integer.parseInt(st.nextToken()); // 상자 세로 길이
        h = Integer.parseInt(st.nextToken()); // 상자 높이
        matrix = new int[m][n][h];
        visited = new boolean[m][n][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    matrix[k][j][i] = Integer.parseInt(st.nextToken());
                    if (matrix[k][j][i] == -1) {
                        visited[k][j][i] = true;
                    } else if (matrix[k][j][i] == 1) {
                        visited[k][j][i] = true;
                        q.add(new Tomato(k, j, i));
                    }
                }
            }
        }
//        sol
        bfs();
//        output
        System.out.println(getDays());
    }

    public static int getDays() {
        int days = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (matrix[k][j][i] == 0) {
                        return -1;
                    } else {
                        days = Math.max(days, matrix[k][j][i]);
                    }
                }
            }
        }
        return days - 1;
    }

    public static void bfs() {
        int[] dx = {-1, 0, 0, 1, 0, 0};
        int[] dy = {0, -1, 0, 0, 1, 0};
        int[] dz = {0, 0, -1, 0, 0, 1};
        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            int day = matrix[tomato.x][tomato.y][tomato.z];
            visited[tomato.x][tomato.y][tomato.z] = true;
            for (int i = 0; i < 6; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                int nz = tomato.z + dz[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && nz >= 0 && nz < h // 좌표 조건
                        && !visited[nx][ny][nz] // 방문 조건
                        && matrix[nx][ny][nz] == 0) {
                    matrix[nx][ny][nz] = day + 1;
                    q.add(new Tomato(nx, ny, nz));
                }
            }
        }
    }

    static class Tomato {
        int x;
        int y;
        int z;

        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
