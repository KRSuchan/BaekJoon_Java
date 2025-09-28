package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_1569 {
    //    p_1569 : 정사각형으로 가리기
    static ArrayList<Point> points = new ArrayList<>();

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxX = -1001;
        int minX = 1001;
        int maxY = -1001;
        int minY = 1001;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }
        int len = Math.max(maxX - minX, maxY - minY);
        int[][] tries = {
                {minX, minY},
                {maxX - len, maxY - len},
        };
        boolean possible = false;
        for (int[] t : tries) {
            if (onSquare(t[0], t[1], len)) {
                possible = true;
                break;
            }
        }

        System.out.println(possible ? len : -1);
    }

    private static boolean onSquare(int x0, int y0, int len) {
        int x1 = x0 + len;
        int y1 = y0 + len;
        for (Point point : points) {
            boolean onBottomTop = (x0 <= point.x || point.x <= x1) && (point.y == y0 || point.y == y1);
            boolean onLeftRight = (y0 <= point.y || point.y <= y1) && (point.x == x0 || point.x == x1);
            if (!(onBottomTop || onLeftRight)) return false;
        }
        return true;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
