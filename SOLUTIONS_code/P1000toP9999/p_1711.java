package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_1711 {
    //    p_1711 : 직각삼각형
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int cnt = 0;
        // v(p1, p2) v(p2,p3) v(p3, p1) 벡터 3개 처리해야함.
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(j);
                    Point p3 = points.get(k);

                    Vector v1 = new Vector(p2.x - p1.x, p2.y - p1.y);
                    Vector v2 = new Vector(p3.x - p2.x, p3.y - p2.y);
                    Vector v3 = new Vector(p1.x - p3.x, p1.y - p3.y);

                    if (v1.dx * v2.dx + v1.dy * v2.dy == 0
                            || v2.dx * v3.dx + v2.dy * v3.dy == 0
                            || v3.dx * v1.dx + v3.dy * v1.dy == 0) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Vector {
        long dx, dy;

        public Vector(long dx, long dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }
}
