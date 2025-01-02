package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1107 {
    //    p_1107 : 리모컨
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if (m > 0) {
            var st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int res = Math.abs(n - 100);
        for (int i = 0; i < 999_999; i++) {
            String num = String.valueOf(i);
            boolean isBroken = false;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }
            if (!isBroken) {
                int cnt = num.length() + Math.abs(n - i);
                res = Math.min(res, cnt);
            }
        }
        System.out.println(res);
    }
}
