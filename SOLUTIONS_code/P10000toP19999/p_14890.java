package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14890 {
    //    p_14890 : 경사로
    static int N, L;
    static int[][] map;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (checkRow(i)) cnt++;
            if (checkCol(i)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean checkRow(int row) {
        boolean[] isIncline = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[row][i + 1] - map[row][i];
            if (diff > 1 || diff < -1) return false;
            else if (diff == 1) { // 다음 계단이 1 높다.
                for (int j = 0; j < L; j++) { // 경사면 설치 여부
                    // map 밖이거나 이미 경사로를 놓은 곳 => false
                    if (i - j < 0 || isIncline[i - j]) return false;
                    // 경사로를 놓을 곳이 높이 차가 존재 => false
                    if (map[row][i] != map[row][i - j]) return false;
                    isIncline[i - j] = true;
                }
            } else if (diff == -1) { // 다음 계단이 1 낮다.
                for (int j = 1; j <= L; j++) { // 경사면 설치 여부
                    // map 밖이거나 이미 경사로를 놓은 곳 => false
                    if (i + j >= N || isIncline[i + j]) return false;
                    // 경사로를 놓을 곳이 높이 차가 존재 => false
                    if (map[row][i] - 1 != map[row][i + j]) return false;
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }

    private static boolean checkCol(int col) {
        boolean[] isIncline = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[i + 1][col] - map[i][col];
            if (diff > 1 || diff < -1) return false;
            else if (diff == 1) { // 다음 계단이 1 높다.
                for (int j = 0; j < L; j++) { // 경사면 설치 여부
                    // map 밖이거나 이미 경사로를 놓은 곳 => false
                    if (i - j < 0 || isIncline[i - j]) return false;
                    // 경사로를 놓을 곳이 높이 차가 존재 => false
                    if (map[i][col] != map[i - j][col]) return false;
                    isIncline[i - j] = true;
                }
            } else if (diff == -1) { // 다음 계단이 1 낮다.
                for (int j = 1; j <= L; j++) { // 경사면 설치 여부
                    // map 밖이거나 이미 경사로를 놓은 곳 => false
                    if (i + j >= N || isIncline[i + j]) return false;
                    // 경사로를 놓을 곳이 높이 차가 존재 => false
                    if (map[i][col] - 1 != map[i + j][col]) return false;
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }

}
