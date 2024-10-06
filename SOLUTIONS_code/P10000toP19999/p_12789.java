package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p_12789 {
    //    p_12789 : 도키도키 간식드리미
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> waiting = new Stack<>();
        int last = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (last + 1 == x) {
                last = x;
            } else {
                waiting.push(x);
            }
            while (!waiting.isEmpty() && waiting.peek() == last + 1) {
                last = waiting.pop();
            }
        }
        System.out.println(waiting.isEmpty() ? "Nice" : "Sad");
    }
}
