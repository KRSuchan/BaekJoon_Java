package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1267 {
    //    p_1267 : 핸드폰 요금
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        int sumY = 0;
        int sumM = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            sumY += (x / 30 + 1) * 10;
            sumM += (x / 60 + 1) * 15;
        }
        var sb = new StringBuilder();
        if (sumY > sumM) {
            sb.append("M ").append(sumM);
        } else if (sumY == sumM) {
            sb.append("Y M ").append(sumM);
        } else {
            sb.append("Y ").append(sumY);
        }
        System.out.println(sb);
    }
}
