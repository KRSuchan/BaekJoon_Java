package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1484 {
    //    p_1484 : 다이어트
    public static void solution(String[] args) throws IOException {
        var b = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(b.readLine());
        long known = 1;
        long now = 2;
        boolean check = false;
        var sb = new StringBuilder();
        while (now < 100_000) {
            long ps = known * known;
            long pe = now * now;
            if (pe - ps == G) {
                sb.append(now).append("\n");
                check = true;
            }
            if (pe - ps > G) {
                known++;
            } else {
                now++;
            }
        }
        if (!check) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
