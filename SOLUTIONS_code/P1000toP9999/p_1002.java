package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1002 {
    //    p_1002 : 터렛
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            if (distance == 0 && r1 == r2) {
                sb.append("-1\n");
            } else if (distance > r1 + r2) {
                sb.append("0\n");
            } else if (distance == r1 + r2) {
                sb.append("1\n");
            } else {
                if (distance == Math.abs(r1 - r2)) {
                    sb.append("1\n");
                } else if (distance < Math.abs(r1 - r2)) {
                    sb.append("0\n");
                } else {
                    sb.append("2\n");
                }
            }
        }
        System.out.println(sb);
    }
}
