package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_16479 {
    //    p_16479 : 컵라면 측정하기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double D1 = Double.parseDouble(st.nextToken());
        double D2 = Double.parseDouble(st.nextToken());
        double res = K * K - Math.pow(Math.abs(D1 - D2) / 2, 2);
        System.out.println(res);
    }
}
