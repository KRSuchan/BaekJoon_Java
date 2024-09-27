package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_23756 {
    //    p_23756 : 노브 돌리기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < N; i++) {
            int Ai = Integer.parseInt(br.readLine());
            int diff = Math.abs(Ai - A);
            int l = 360 - diff;
            res += Math.min(l, diff);
            A = Ai;
        }
        System.out.println(res);
    }
}
