package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1987 {
    //    p_1987 : 알파벳
    public static int R, C;
    public static char[][] map;
    public static boolean[] visitedAlphabet = new boolean[26];
    public static boolean[][] visited;
    public static int max = 0;
    public static int[] dr = {0, 0, -1, 1};
    public static int[] dc = {-1, 1, 0, 0};

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int r, int c, int cnt) {
        max = Math.max(max, cnt);
        visitedAlphabet[map[r][c] - 'A'] = true;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc] || visitedAlphabet[map[nr][nc] - 'A'])
                continue;
            dfs(nr, nc, cnt + 1);
            visitedAlphabet[map[nr][nc] - 'A'] = false;
            visited[nr][nc] = false;
        }
    }
}
