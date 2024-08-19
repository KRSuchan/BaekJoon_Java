package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_3449 {
    //    p_3449 : 해밍 거리
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            int result = 0;
            for (int i = 0, len = s1.length(); i < len; i++) {
                if (s1.charAt(i) != s2.charAt(i)) result++;
            }
            sb.append("Hamming distance is ").append(result).append(".\n");
        }
        System.out.print(sb);
    }
}
