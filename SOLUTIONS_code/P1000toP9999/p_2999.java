package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_2999 {
    //    p_2999 : 비밀 이메일
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = s.length();
        int R = 0;
        int C = 0;
        for (int i = (int) Math.sqrt(N); i > 0; i--) {
            if (N % i == 0) {
                R = i;
                C = N / i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        String[] ss = new String[C];
        for (int i = 0; i < C; i++) {
            int idx = i * R;
            ss[i] = s.substring(idx, idx + R);
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(ss[j].charAt(i));
            }
        }
        System.out.println(sb);
    }
}
