package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_12813 {
    //    p_12813 : 이진수 연산
    static StringBuilder sb = new StringBuilder();

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        and(A, B);
        or(A, B);
        xor(A, B);
        not(A);
        not(B);
        System.out.print(sb);
    }

    private static void and(String a, String b) {
        for (int i = 0; i < 100000; i++) {
            if (a.charAt(i) == '1' && a.charAt(i) == b.charAt(i)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        sb.append("\n");
    }

    private static void or(String a, String b) {
        for (int i = 0; i < 100000; i++) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        sb.append("\n");
    }

    private static void xor(String a, String b) {
        for (int i = 0; i < 100000; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        sb.append("\n");
    }

    private static void not(String b) {
        for (int i = 0; i < 100000; i++) {
            if (b.charAt(i) == '1') {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        sb.append("\n");
    }
}
