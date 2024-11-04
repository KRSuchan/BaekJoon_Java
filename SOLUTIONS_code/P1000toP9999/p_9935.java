package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_9935 {
    //    p_9935 : 문자열 폭발
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String b = br.readLine();
        int len = b.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (len <= stack.size()) {
                boolean flag = true;
                for (int j = 0; j < len; j++) {
                    if (stack.get(stack.size() - len + j) != b.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < len; j++) {
                        stack.pop();
                    }
                }
            }
        }
        var sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        System.out.println(sb.isEmpty() ? "FRULA" : sb);
    }
}
