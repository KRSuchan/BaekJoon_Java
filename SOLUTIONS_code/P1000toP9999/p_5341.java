package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_5341 {
    //    p_5341 : Pyramids
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res += i;
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
