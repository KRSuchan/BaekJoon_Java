package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_5073 {
    //    p_5073 : 삼각형과 세 변
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (a != 0 && b != 0 && c != 0) {
            int apb = a + b;
            int bpc = b + c;
            int cpa = c + a;
            int max = Math.max(a, Math.max(b, c));

            if (max >= apb || max >= bpc || max >= cpa) {
                sb.append("Invalid");
            } else if (apb == bpc && bpc == cpa) {
                sb.append("Equilateral");
            } else if (apb != bpc && bpc != cpa && cpa != apb) {
                sb.append("Scalene");
            } else {
                sb.append("Isosceles");
            }
            sb.append("\n");
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }
}
