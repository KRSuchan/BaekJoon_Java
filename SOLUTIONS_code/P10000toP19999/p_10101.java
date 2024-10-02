package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_10101 {
    //    p_10101 : 삼각형 외우기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        boolean aeqb = a == b;
        boolean beqc = b == c;
        boolean ceqa = c == a;
        StringBuilder sb = new StringBuilder();
        if (a + b + c != 180) {
            sb.append("Error");
        } else if (aeqb && beqc) {
            sb.append("Equilateral");
        } else if (!aeqb && !beqc && !ceqa) {
            sb.append("Scalene");
        } else {
            sb.append("Isosceles");
        }
        System.out.println(sb);
    }
}
