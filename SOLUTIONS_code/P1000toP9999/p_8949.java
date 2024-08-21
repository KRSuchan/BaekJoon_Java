package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_8949 {
    //    p_8949 : 대충 더해
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder a = new StringBuilder(st.nextToken());
        StringBuilder b = new StringBuilder(st.nextToken());
        int gap = Math.abs(a.length() - b.length());
        if (a.length() > b.length()) {
            for (int i = 0; i < gap; i++) {
                b.insert(0, "0");
            }
        } else {
            for (int i = 0; i < gap; i++) {
                a.insert(0, "0");
            }
        }
        int len = Math.max(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            sb.append(a.charAt(i) - '0' + b.charAt(i) - '0');
        }
        System.out.print(sb);
    }
}
