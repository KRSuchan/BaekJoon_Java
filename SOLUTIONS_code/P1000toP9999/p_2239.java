package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p_2239 {
    //    p_2239 : 스도쿠
    static final int N = 9;
    static boolean completed = false;
    static int[][] map;
    static ArrayList<int[]> blanks = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 0)
                    blanks.add(new int[]{i, j});
            }
        }

        play(0);
    }

    private static void play(int index) {
        if (blanks.size() == index) {
            build();
            System.out.println(sb);
            System.exit(0);
        }
        int[] pos = blanks.get(index);
        int x = pos[0];
        int y = pos[1];

        for (int i = 1; i <= 9; i++) {
            if (isValid(x, y, i)) {
                map[x][y] = i;
                play(index + 1);
                map[x][y] = 0;
            }
        }
    }

    private static void build() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }

    private static boolean isValid(int x, int y, int value) {
        // 가로 세로
        for (int i = 0; i < N; i++) {
            if (map[x][i] == value || map[i][y] == value) return false;
        }

        // 3*3 block
        int br = (x / 3) * 3;
        int bc = (y / 3) * 3;
        for (int i = br; i < br + 3; i++) {
            for (int j = bc; j < bc + 3; j++) {
                if (map[i][j] == value) return false;
            }
        }

        return true;
    }
}
