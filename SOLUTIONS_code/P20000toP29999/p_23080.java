package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_23080 {
    //    p_23080 : 스키테일 암호
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i += K) {
            sb.append(S.charAt(i));
        }
        System.out.println(sb);
    }
}
