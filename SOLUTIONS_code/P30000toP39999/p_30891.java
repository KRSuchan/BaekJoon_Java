package SOLUTIONS_code.P30000toP39999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_30891 {
    //    p_30891 : 볶음밥 지키기
    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            if (x[i] < minX) minX = x[i];
            if (x[i] > maxX) maxX = x[i];
            if (y[i] < minY) minY = y[i];
            if (y[i] > maxY) maxY = y[i];
        }
        // alg
        int result = 0;
        int resX = 0;
        int resY = 0;
        int r2 = r * r;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                int temp = 0;
                for (int k = 0; k < n; k++) {
                    double distance = (Math.pow(i - x[k], 2) + Math.pow(j - y[k], 2));
                    if (distance <= r2) temp++;
                }
                if (result < temp) {
                    result = temp;
                    resX = i;
                    resY = j;
                }
            }
        }
        // output
        StringBuilder sb = new StringBuilder();
        sb.append(resX).append(" ").append(resY);
        System.out.print(sb);
    }
}
