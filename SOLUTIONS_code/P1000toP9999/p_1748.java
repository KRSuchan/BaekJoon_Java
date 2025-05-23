package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1748 {
    //    p_1748 : 수 이어 쓰기 1
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int len = N.length();
        int res = 0;
        for (int i = 1; i < len; i++) {
            res += (int) (9 * Math.pow(10, i - 1) * (i));
        }
        System.out.println(res + ((Integer.parseInt(N) - (int) Math.pow(10, len - 1)) * len + 1 * len));
    }
}
