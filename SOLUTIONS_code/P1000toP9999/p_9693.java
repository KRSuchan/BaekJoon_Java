package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_9693 {
    //    p_9693 : 시파르
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            sb.append("Case #").append(++T).append(": ");
            int res = 0;
            for (int i = 5; i <= n; i *= 5) {
                res += n / i;
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
