package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1027 {
    //    p_1027 : 고층 건물
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        // 기준 빌딩 번호 : i
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            // 좌측 시야
            double maxSlope = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (buildings[j] - buildings[i]) / (j - i);
                if (slope < maxSlope) {
                    maxSlope = slope;
                    cnt++;
                }
            }
            // 우측 시야
            maxSlope = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double slope = (double) (buildings[j] - buildings[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
