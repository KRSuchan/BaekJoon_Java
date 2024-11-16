package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_17362 {
    //    p_17362 : 수학은 체육과목 입니다 2
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = n % 8;
        if (res == 0) res = 2;
        if (res == 6) res = 4;
        if (res == 7) res = 3;
        System.out.println(res);
    }
}
