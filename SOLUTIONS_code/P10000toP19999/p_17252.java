package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_17252 {
    //    p_17252 : 삼삼한 수
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println("NO");
            return;
        }
        for (int i = 19; i >= 0; i--) {
            int val = (int) Math.pow(3, i);
            if (N >= val) N -= val;
        }
        if (N == 0) System.out.println("YES");
        else System.out.println("NO");
    }
}
