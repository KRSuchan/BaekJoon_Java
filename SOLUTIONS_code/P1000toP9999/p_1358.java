package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1358 {
    //    p_1358 : 하키
    public static double radius = 0;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        radius = (double) H / 2;
        int cnt = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x >= X && y >= Y && x <= X + W && y <= Y + H) {
                cnt++;
            } else if (radius >= getDistance(x, y, X, Y + radius) || radius >= getDistance(x, y, X + W, Y + radius)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }
}
