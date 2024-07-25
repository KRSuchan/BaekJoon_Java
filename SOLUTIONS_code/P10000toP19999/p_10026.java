package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p_10026 {
    //    p_10026 : 적록색약
    static char[][] matrix;
    static boolean[][] visited;
    static int n;
    static int cntRGB = 0;
    static int cntRRB = 0;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input
        n = Integer.parseInt(br.readLine());
        matrix = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) bfsRGB(i, j);
            }
        }
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) bfsRRB(i, j);
            }
        }
        System.out.println(cntRGB + " " + cntRRB);
    }

    private static void bfsRGB(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        cntRGB++;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && !visited[nx][ny]
                        && matrix[cur[0]][cur[1]] == matrix[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void bfsRRB(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        cntRRB++;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && !visited[nx][ny]
                        && (matrix[cur[0]][cur[1]] == matrix[nx][ny] ||
                        matrix[cur[0]][cur[1]] != 'B' && matrix[nx][ny] != 'B')) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
