package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p_6549 {
    //    p_6549 : 히스토그램에서 가장 큰 직사각형
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        while (true) {
            var st = new StringTokenizer(br.readLine());
            Stack<Integer> stack = new Stack<>();
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && h[i] <= h[stack.peek()]) {
                    int height = h[stack.pop()];
                    long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                    max = Math.max(max, height * width);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int height = h[stack.pop()];
                long width = stack.isEmpty() ? n : n - 1 - stack.peek();
                max = Math.max(max, height * width);
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
