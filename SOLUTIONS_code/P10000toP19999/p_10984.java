package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10984 {
    //    p_10984 : 내 학점을 구해줘
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int sumC = 0;
            double sumG = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                double G = Double.parseDouble(st.nextToken());
                sumC += C;
                sumG += G * C;
            }
            System.out.printf("%d %.1f\n", sumC, sumG / sumC);
        }
    }
}
