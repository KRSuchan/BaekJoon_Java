package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_24313 {
    //    p_24313 : 알고리즘 수업 - 점근적 표기 1
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        int fn = 0;
        int gn = 0;
        boolean comp = c < a1;
        for (int i = n0; i <= 100; i++) {
            fn = a1 * n0 + a0;
            gn = c * n0;
            if (fn > gn) {
                comp = true;
                break;
            }
        }
        if (!comp) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
