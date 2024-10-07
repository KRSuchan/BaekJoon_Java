package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1010 {
    //    p_1010 : 다리 놓기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long c = 1;
            long p = 1;
            int diff = Math.min(N, Math.abs(M - N));
            for (int i = M - diff + 1; i <= M; i++) {
                c *= i;
            }
            for (int i = 1; i <= diff; i++) {
                p *= i;
            }
            sb.append(c / p).append("\n");
        }
        System.out.println(sb);
    }
}
