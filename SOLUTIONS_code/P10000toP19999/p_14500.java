package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14500 {
    static int[] dn = {-1, 1, 0, 0};
    static int[] dm = {0, 0, -1, 1};
    static int answer = 0;
    static boolean[][] visited;
    static int[][] matrix;
    static int n;
    static int m;

    //    p_14500 : 테트로미노
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, matrix[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }

    static void dfs(int r, int c, int depth, int sum) {
        if (depth == 4) {
            if (answer < sum) answer = sum;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dn[i];
            int nc = c + dm[i];
            if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc])
                continue;
            if (depth == 2) {
                visited[nr][nc] = true;
                dfs(r, c, depth + 1, sum + matrix[nr][nc]);
                visited[nr][nc] = false;
            }
            visited[r][c] = true;
            dfs(nr, nc, depth + 1, sum + matrix[nr][nc]);
            visited[nr][nc] = false;
        }
    }
}
