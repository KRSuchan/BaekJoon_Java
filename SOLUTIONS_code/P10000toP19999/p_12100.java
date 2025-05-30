package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_12100 {
    //    p_12100 : 2048 (Easy)
    public static final int MAX_MOVE = 5;
    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    public static int N;
    public static int max = 0;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        game(map, 0);
        System.out.println(max);
    }

    public static void game(int[][] map, int cnt) {
        if (cnt == MAX_MOVE) {
            findMax(map);
            return;
        }
        // 상태 저장
        int[][] copy = new int[N][N];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                copy[j] = map[j].clone();
            }
            move(copy, i);
            game(copy, cnt + 1);
        }
    }

    private static void findMax(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
    }

    private static void move(int[][] map, int dir) {
        switch (dir) {
            case UP:
                for (int i = 0; i < N; i++) {
                    int[] block = new int[N];
                    int idx = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[j][i] == 0) continue;
                        if (block[idx] == 0) {
                            block[idx] = map[j][i];
                        } else if (block[idx] == map[j][i]) {
                            block[idx++] += map[j][i];
                        } else {
                            block[++idx] = map[j][i];
                        }
                    }
                    for (int j = 0; j < N; j++) {
                        map[j][i] = block[j];
                    }
                }
                break;
            case DOWN:
                for (int i = 0; i < N; i++) {
                    int[] block = new int[N];
                    int idx = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[j][i] == 0) continue;
                        if (block[idx] == 0) {
                            block[idx] = map[j][i];
                        } else if (block[idx] == map[j][i]) {
                            block[idx--] += map[j][i];
                        } else {
                            block[--idx] = map[j][i];
                        }
                    }
                    for (int j = 0; j < N; j++) {
                        map[j][i] = block[j];
                    }
                }
                break;
            case LEFT:
                for (int i = 0; i < N; i++) {
                    int[] block = new int[N];
                    int idx = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == 0) continue;
                        if (block[idx] == 0) {
                            block[idx] = map[i][j];
                        } else if (block[idx] == map[i][j]) {
                            block[idx++] += map[i][j];
                        } else {
                            block[++idx] = map[i][j];
                        }
                    }
                    for (int j = 0; j < N; j++) {
                        map[i][j] = block[j];
                    }
                }
                break;
            case RIGHT:
                for (int i = 0; i < N; i++) {
                    int[] block = new int[N];
                    int idx = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[i][j] == 0) continue;
                        if (block[idx] == 0) {
                            block[idx] = map[i][j];
                        } else if (block[idx] == map[i][j]) {
                            block[idx--] += map[i][j];
                        } else {
                            block[--idx] = map[i][j];
                        }
                    }
                    for (int j = 0; j < N; j++) {
                        map[i][j] = block[j];
                    }
                }
                break;
        }
    }
}
