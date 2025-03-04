package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_15683 {
    //    p_15683 : 감시
    static int N, M;
    static int min = Integer.MAX_VALUE;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        ArrayList<Point> cctvList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new Point(i, j, map[i][j]));
                }
            }
        }
        dfs(0, map, cctvList);
        System.out.println(min);
    }

    public static void dfs(int cnt, int[][] map, ArrayList<Point> cctvList) {
        if (cnt == cctvList.size()) {
            min = Math.min(min, getZeroCnt(map));
            return;
        }
        int cctvNum = cctvList.get(cnt).num;
        int x = cctvList.get(cnt).x;
        int y = cctvList.get(cnt).y;
        int[][] tmp;
        if (cctvNum == 1) {
            tmp = copyMap(map);
            checkUp(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);

            tmp = copyMap(map);
            checkDown(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);

            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);

            tmp = copyMap(map);
            checkRight(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);
        } else if (cctvNum == 2) {
            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);

            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);
        } else if (cctvNum == 3) {
            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);


            tmp = copyMap(map);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);


            tmp = copyMap(map);
            checkDown(tmp, x, y);
            checkLeft(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);


            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            checkUp(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);
        } else if (cctvNum == 4) {
            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);


            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);


            tmp = copyMap(map);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            checkLeft(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);


            tmp = copyMap(map);
            checkDown(tmp, x, y);
            checkLeft(tmp, x, y);
            checkUp(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);
        } else if (cctvNum == 5) {
            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkDown(tmp, x, y);
            checkLeft(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt + 1, tmp, cctvList);
        }
    }

    public static void checkUp(int[][] map, int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] == 6) return;
            if (map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static void checkDown(int[][] map, int x, int y) {
        for (int i = x + 1; i < N; i++) {
            if (map[i][y] == 6) return;
            if (map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static void checkLeft(int[][] map, int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] == 6) return;
            if (map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static void checkRight(int[][] map, int x, int y) {
        for (int i = y + 1; i < M; i++) {
            if (map[x][i] == 6) return;
            if (map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static int getZeroCnt(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

    static class Point {
        int x, y, num;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
