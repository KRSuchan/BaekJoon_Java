package SOLUTIONS_code.P30000toP39999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_31534 {
    //    p_31534 : 현대모비스 선풍기 굴리기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());

        if (a == b) {
            System.out.println(-1);
            return;
        }

        // 길이 크기 비교
        double high = Math.max(a, b);
        double low = Math.min(a, b);

        double l2 = Math.sqrt((high - low) * (high - low) + h * h);
        double l = l2 * high / (high - low);
        double l1 = l * low / high;

        System.out.printf("%.6f", (l * l - l1 * l1) * Math.PI);
    }
}
