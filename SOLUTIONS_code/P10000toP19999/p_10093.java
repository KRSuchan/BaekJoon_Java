package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10093 {
    //    p_10093 : 숫자
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        if (A == B) {
            System.out.println(0);
        } else {
            System.out.println(Math.abs(A - B) - 1);
        }

        StringBuilder sb = new StringBuilder();
        long min = Math.min(A, B);
        long max = Math.max(A, B);
        for (long i = min + 1; i < max; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
