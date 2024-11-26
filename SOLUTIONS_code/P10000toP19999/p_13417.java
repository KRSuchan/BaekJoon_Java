package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class p_13417 {
    //    p_13417 : 카드 문자열
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine());
            Deque<Character> dq = new ArrayDeque<>();
            dq.addFirst(st.nextToken().charAt(0));
            for (int i = 1; i < N; i++) {
                char c = st.nextToken().charAt(0);
                if (dq.getFirst() >= c) {
                    dq.addFirst(c);
                } else {
                    dq.addLast(c);
                }
            }
            for (int i = 0; i < N; i++) {
                sb.append(dq.removeFirst());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
