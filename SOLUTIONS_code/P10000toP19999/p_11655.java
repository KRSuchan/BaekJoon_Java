package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_11655 {
    //    p_11655 : ROT13
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c - 'a' >= 13) {
                    sb.append((char) (c - 13));
                } else {
                    sb.append((char) (c + 13));
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c - 'A' >= 13) {
                    sb.append((char) (c - 13));
                } else {
                    sb.append((char) (c + 13));
                }
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
