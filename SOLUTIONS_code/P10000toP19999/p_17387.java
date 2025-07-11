package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_17387 {
    //    p_17387 : 선분 교차 2
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Point A, B, C, D;
        A = new Point(Long.parseLong(st1.nextToken()), Long.parseLong(st1.nextToken()));
        B = new Point(Long.parseLong(st1.nextToken()), Long.parseLong(st1.nextToken()));
        C = new Point(Long.parseLong(st2.nextToken()), Long.parseLong(st2.nextToken()));
        D = new Point(Long.parseLong(st2.nextToken()), Long.parseLong(st2.nextToken()));

        int result;
        int ccw1 = ccw(A, B, C) * ccw(A, B, D); // 벡터 AB 기준 점 C와 D에 대한 교차 여부
        int ccw2 = ccw(C, D, A) * ccw(C, D, B); // 벡터 CD 기준 점 A와 B에 대한 교차 여부

        if (ccw1 == 0 && ccw2 == 0) { // 네 점 모두 한 직선에 있는 경우
            if (Math.min(A.x, B.x) <= Math.max(C.x, D.x)
                    && Math.max(A.x, B.x) >= Math.min(C.x, D.x)
                    && Math.min(A.y, B.y) <= Math.max(C.y, D.y)
                    && Math.max(A.y, B.y) >= Math.min(C.y, D.y))
                result = 1;
            else
                result = 0;
        } else if (ccw1 <= 0 && ccw2 <= 0) { // 교차 하는 경우
            result = 1;
        } else { // 교차 하지 않는 경우
            result = 0;
        }

        System.out.println(result);
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long result = ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y)) - ((p1.y * p2.x) + (p2.y * p3.x) + (p3.y * p1.x));
        return Long.compare(result, 0);
    }

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
