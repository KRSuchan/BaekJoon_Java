package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_21313 {
    //    p_21313 : 문어
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append(i % 2 + 1).append(" ");
        }
        if (n % 2 == 1) {
            sb.append(3);
        } else {
            sb.append(2);
        }
        System.out.println(sb);
    }
}
