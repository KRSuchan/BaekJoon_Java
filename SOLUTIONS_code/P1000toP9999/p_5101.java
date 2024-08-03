package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_5101 {
    //    p_5101 : Sequences
    static int a, d, x;
    static BufferedReader br;

    public static void solution(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        input();
        while (a != 0 || d != 0 || x != 0) {
            if ((x - a) % d != 0 || a > x) sb.append("X");
            else sb.append(((x - a) / d) + 1);
            sb.append("\n");
            input();
        }
        System.out.print(sb);
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
    }
}
