package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p_15685 {
    //    p_15685 : 드래곤 커브
    static final int RIGHT = 0;
    static final int UP = 1;
    static final int LEFT = 2;
    static final int DOWN = 3;

    static boolean[][] map = new boolean[101][101];

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            draw(x, y, getDirections(d, g));
        }
        System.out.println(getSquareCnt());
    }

    private static int getSquareCnt() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
                    cnt++;
            }
        }
        return cnt;
    }

    private static void draw(int x, int y, List<Integer> directions) {
        map[x][y] = true;
        for (Integer direction : directions) {
            switch (direction) {
                case RIGHT -> map[++x][y] = true;
                case UP -> map[x][--y] = true;
                case LEFT -> map[--x][y] = true;
                case DOWN -> map[x][++y] = true;
            }
        }
    }

    private static List<Integer> getDirections(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);
        while (g-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int direction = (directions.get(i) + 1) % 4;
                directions.add(direction);
            }
        }
        return directions;
    }
}
