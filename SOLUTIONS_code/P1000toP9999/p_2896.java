package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2896 {
    //    p_2896 : 무알콜 칵테일
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double I = Double.parseDouble(st.nextToken());
        double J = Double.parseDouble(st.nextToken());
        double K = Double.parseDouble(st.nextToken());

        double a = A / I;
        double b = B / J;
        double c = C / K;
        double min = Math.min(a, Math.min(b, c));

        System.out.printf("%.6f %.6f %.6f", A - I * min, B - J * min, C - K * min);
    }
}
