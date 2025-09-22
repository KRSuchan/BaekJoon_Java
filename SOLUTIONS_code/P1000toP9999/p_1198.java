package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_1198 {
    //    p_1198 : 삼각형으로 자르기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            points.add(p);
        }

        double max = 0;
        for (int i = 0; i < points.size(); i++)
            for (int j = i + 1; j < points.size(); j++)
                for (int k = j + 1; k < points.size(); k++)
                    max = Math.max(max, getSize(points.get(i), points.get(j), points.get(k)));

        System.out.println(max);
    }

    public static double getSize(Point p1, Point p2, Point p3) {
        return Math.abs(p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x) / 2;
    }

    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
