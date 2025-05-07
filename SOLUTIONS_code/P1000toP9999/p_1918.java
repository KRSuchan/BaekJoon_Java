package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_1918 {
    //    p_1918 : 후위 표기식
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> op = new Stack<>();

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        for (char input : chars) {
            toPostfix(input);
        }
        while (!op.isEmpty()) sb.append(op.pop());
        System.out.println(sb);
    }

    private static void toPostfix(char input) {
        // 피연산자
        if (input >= 'A' && input <= 'Z') {
            sb.append(input);
            return;
        }
        // 연산자 '('
        if (input == '(') {
            op.push(input);
            return;
        }
        // 연산자 ')'
        if (input == ')') {
            while (!op.isEmpty() && op.peek() != '(') {
                sb.append(op.pop());
            }
            if (!op.isEmpty()) op.pop();
            return;
        }
        // 연산자 +-*/
        while (!op.isEmpty() && priority(op.peek()) >= priority(input)) {
            sb.append(op.pop());
        }
        op.push(input);
    }

    private static int priority(char op) {
        return switch (op) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }
}
