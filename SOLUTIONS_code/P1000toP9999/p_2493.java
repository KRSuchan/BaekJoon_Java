package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p_2493 {
    //    p_2493 : 탑
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();
        var sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Top(i, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Top(i, height));
                        break;
                    }
                    Top top = stack.peek();
                    if (top.height > height) {
                        sb.append(top.num).append(" ");
                        stack.push(new Top(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }

    static class Top {
        int num;
        int height;

        public Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
}
