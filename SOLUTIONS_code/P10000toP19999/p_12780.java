package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_12780 {
    //    p_12780 : 원피스
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String H = br.readLine();
        String N = br.readLine();
        int count = 0;
        int index = 0;
        while ((index = H.indexOf(N, index)) != -1) {
            count++;
            index += N.length();
        }
        System.out.println(count);
    }
}
