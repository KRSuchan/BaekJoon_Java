package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1669 {
    //    p_1669 : 멍멍이 쓰다듬기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (x == y) {
            System.out.println(0);
            return;
        }
        int diff = y - x;
        int val = (int) Math.sqrt(diff);
        if (diff == val * val) {
            System.out.println(val * 2 - 1);
        } else if (diff <= val * val + val) {
            System.out.println(val * 2);
        } else {
            System.out.println(val * 2 + 1);
        }
    }
}
