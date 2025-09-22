package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1064 {
    //    p_1064 : 평행사변형
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] points = new int[6];
        for (int i = 0; i < 6; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        // 기울기가 동일하면 일직선
        if ((points[2] - points[0]) * (points[5] - points[1]) == (points[4] - points[0]) * (points[3] - points[1])) {
            System.out.println(-1);
            return;
        }
        // 두점의 길이
        double ab = getLength(points[0], points[1], points[2], points[3]);
        double bc = getLength(points[2], points[3], points[4], points[5]);
        double ca = getLength(points[4], points[5], points[0], points[1]);

        double max = Math.max(ab, Math.max(bc, ca));
        double min = Math.min(ab, Math.min(bc, ca));

        System.out.println((max - min) * 2);
    }

    public static double getLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
