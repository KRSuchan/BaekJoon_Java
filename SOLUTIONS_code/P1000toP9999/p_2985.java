package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2985 {
    //    p_2985 : 세 수

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char leftOp = '.';
        char rightOp = '.';
        // A와 B의 사칙연산 결과가 C인가
        if (A + B == C) {
            leftOp = '+';
            rightOp = '=';
        } else if (A - B == C) {
            leftOp = '-';
            rightOp = '=';
        } else if (A * B == C) {
            leftOp = '*';
            rightOp = '=';
        } else if (A / B == C) {
            leftOp = '/';
            rightOp = '=';
        }
        // B와 C의 사칙연산 결과가 A인가
        else if (A == B + C) {
            leftOp = '=';
            rightOp = '+';
        } else if (A == B - C) {
            leftOp = '=';
            rightOp = '-';
        } else if (A == B * C) {
            leftOp = '=';
            rightOp = '*';
        } else if (A == B / C) {
            leftOp = '=';
            rightOp = '/';
        }
        // output
        StringBuilder sb = new StringBuilder();
        sb.append(A).append(leftOp).append(B).append(rightOp).append(C);
        System.out.println(sb);
    }
}
