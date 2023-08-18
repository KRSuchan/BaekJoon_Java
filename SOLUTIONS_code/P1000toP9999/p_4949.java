package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.Stack;

public class p_4949 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "start";
        Stack<Character> stack = new Stack<>();
        while (true) {
            boolean isBalanced = true;
            s = br.readLine();
            if (s.length()==1 && s.charAt(0)=='.') break;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') stack.push('(');
                else if (s.charAt(i) == '[') stack.push('[');
                else if (s.charAt(i) == ')' && (stack.isEmpty() || !stack.peek().equals('('))) {
                    isBalanced =false;
                    break;
                }
                else if (s.charAt(i) == ']' && (stack.isEmpty() || !stack.peek().equals('['))) {
                    isBalanced = false;
                    break;
                }
                else if (s.charAt(i) == ')' && stack.peek().equals('(')) stack.pop();
                else if (s.charAt(i) == ']' && stack.peek().equals('[')) stack.pop();
            }
            if (stack.isEmpty()&&isBalanced) bw.write("yes\n");
            else bw.write("no\n");
            stack.removeAllElements();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
