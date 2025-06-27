package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_2495 {
    //    p_2495 : 연속구간
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 3;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String str = br.readLine();
            int max = 0;
            int value = 1;
            for (int i = 1; i < str.length(); i++) {
                char prev = str.charAt(i - 1);
                char cur = str.charAt(i);
                if (prev == cur) {
                    value++;
                } else {
                    max = Math.max(value, max);
                    value = 1;
                }
            }
            sb.append(Math.max(value, max)).append("\n");
        }
        System.out.println(sb);
    }
}
