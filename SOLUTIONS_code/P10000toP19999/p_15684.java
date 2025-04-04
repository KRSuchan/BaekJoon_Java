package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_15684 {
    //    p_15684 : 사다리 조작
    static int N, M, H, max;
    static boolean finished = false;
    static int[][] map;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = b + 1;
            map[a][b + 1] = b;
        }
        for (int i = 0; i <= 3; i++) {
            max = i;
            dfs(1, 0);
            if (finished) break;
        }
        System.out.println(finished ? max : -1);
    }

    private static void dfs(int idx, int cnt) { //
        if (finished) return;
        if (max == cnt) { // max 만큼 만들었을 때 i to i인지 체크하기
            if (check()) finished = true;
            return;
        }

        for (int i = idx; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = j + 1;
                    map[i][j + 1] = j;
                    dfs(i, cnt + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean check() { // i to i 인가?
        for (int i = 1; i < N; i++) {
            int x = 1;
            int y = i;
            for (int j = 0; j < H; j++, x++) {
                if (map[x][y] != 0) y = map[x][y];
            }
            if (y != i) return false;
        }
        return true;
    }

}
