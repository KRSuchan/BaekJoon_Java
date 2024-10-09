package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_11729 {
    //    p_11729 : 하노이 탑 이동 순서
    static int cnt = 0;
    static StringBuilder sb;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        hanoi(1, 2, 3, N);
        System.out.println(cnt);
        System.out.print(sb);
    }

    private static void hanoi(int s, int m, int e, int n) {
        if (n == 1) {
            sb.append(s).append(" ").append(e).append("\n");
            cnt++;
            return;
        }
        hanoi(s, e, m, n - 1);
        sb.append(s).append(" ").append(e).append("\n");
        cnt++;
        hanoi(m, s, e, n - 1);
    }
}
