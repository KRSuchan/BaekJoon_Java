package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_5522 {
    //    p_5522 : 카드 게임
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += Integer.parseInt(br.readLine());
        }
        System.out.println(res);
    }
}
