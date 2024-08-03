package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_14928 {
    //    p_14928 : 큰 수 (BIG)
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long temp = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            temp = (temp * 10 + s.charAt(i) - '0') % 20000303;
        }
        System.out.println(temp);
    }
}
