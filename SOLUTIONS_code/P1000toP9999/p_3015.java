package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_3015 {
    //    p_3015 : 오아시스 재결합
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }
        Stack<int[]> stack = new Stack<>();
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && seq[stack.peek()[0]] < seq[i]) {
                cnt += stack.pop()[1];
            }
            if (stack.isEmpty()) {
                stack.push(new int[]{i, 1});
            } else {
                if (seq[stack.peek()[0]] > seq[i]) {
                    stack.push(new int[]{i, 1});
                    cnt++;
                } else {
                    cnt += stack.peek()[1]++;
                    if (stack.size() > 1) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
