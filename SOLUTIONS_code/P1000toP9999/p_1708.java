package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class p_1708 {
    //    p_1708 : 볼록 껍질
    static Point p1 = new Point(40001, 40001);

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (Point point : points) {
            if (point.y < p1.y) p1 = point;
            else if (point.y == p1.y && point.x < p1.x) p1 = point;
        }

        points.sort((p2, p3) -> {
            int ccwR = ccw(p1, p2, p3);
            if (ccwR > 0) return -1;
            else if (ccwR < 0) return 1;
            else {
                long dist1 = dist(p1, p2);
                long dist2 = dist(p1, p3);
                if (dist1 > dist2) return 1;
            }
            return -1;
        });

        Stack<Point> stack = new Stack<>();
        stack.add(p1);
        for (int i = 1; i < points.size(); i++) {
            while (stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i)) <= 0) {
                stack.pop();
            }
            stack.add(points.get(i));
        }
        System.out.println(stack.size());
    }

    public static long dist(Point a, Point b) {
        return (long) (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static int ccw(Point a, Point b, Point c) {
        long ccwR = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
        if (ccwR > 0) return 1;
        if (ccwR < 0) return -1;
        return 0;
    }

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
