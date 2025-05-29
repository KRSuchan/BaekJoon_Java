package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_17413 {
    //    p_17413 : 단어 뒤집기 2
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') { // '<' 이면 저장된 stack 역순 출력하고 '>'일 때까지 순서 출력
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                while (c != '>') {
                    sb.append(c);
                    c = str.charAt(++i);
                }
                sb.append(c);
            } else if (c == ' ') { // 공백이면 저장된 stack 역순 출력하고 append(' ')
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            } else { // 그외의 경우 push
                stack.push(c);
            }
        }

        // 남은 stack 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
