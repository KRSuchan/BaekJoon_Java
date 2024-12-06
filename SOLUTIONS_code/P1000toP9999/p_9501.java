package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_9501 {
    //    p_9501 : 꿍의 우주여행
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            var st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                double v = Integer.parseInt(st.nextToken());
                double f = Integer.parseInt(st.nextToken());
                double c = Integer.parseInt(st.nextToken());
                if (v * f / c >= D) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
