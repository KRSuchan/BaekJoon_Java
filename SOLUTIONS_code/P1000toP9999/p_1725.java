package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_1725 {
    //    p_1725 : 히스토그램
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N + 2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        stack.push(0);
        for (int i = 1; i < seq.length; i++) {
            while (!stack.isEmpty() && seq[stack.peek()] > seq[i]) {
                max = Math.max(max, seq[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        System.out.println(max);
    }
}
