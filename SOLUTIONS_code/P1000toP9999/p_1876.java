package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1876 {
    //    p_1876 : 튕기는 볼링공
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double laneWidth = 105.0;
        double ball = 10.0;
        double pin = 6.0;
        double range = ball + pin;
        double validWidth = laneWidth - 2 * ball; // 중심 기준 너비
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double T = Double.parseDouble(st.nextToken()) * 100; // 미터법->cm
            double X = Double.parseDouble(st.nextToken());
            double radian = Math.toRadians(X);

            double left = T - (range / Math.sin(radian));
            double right = T + (range / Math.sin(radian));
            double move = validWidth / Math.tan(radian);
            double dist = 0;
            while (dist < right) {
                if (left < dist) {
                    System.out.println("yes");
                    break;
                }
                dist += move;
            }
            if (dist >= right)
                System.out.println("no");
        }
    }
}
