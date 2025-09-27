package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p_1485 {
    //    p_1485 : 정사각형
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Point[] points = new Point[4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            ArrayList<Double> distances = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    distances.add(getDistance(points[i].x, points[i].y, points[j].x, points[j].y));
                }
            }
            Collections.sort(distances);
            if (distances.get(0).equals(distances.get(1))
                    && distances.get(1).equals(distances.get(2))
                    && distances.get(2).equals(distances.get(3))
                    && distances.get(4).equals(distances.get(5))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
