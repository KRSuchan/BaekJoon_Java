package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.Stack;

public class p_9012 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "";
        boolean isVPS;
        Stack<Character> stack = new Stack<>();
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++) {
            s = br.readLine();
            isVPS = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') stack.push('(');
                else if (s.charAt(j) == ')' && (stack.isEmpty() || !stack.peek().equals('('))) {
                    isVPS =false;
                    break;
                }
                else if (s.charAt(j) == ')' && stack.peek().equals('(')) stack.pop();
            }
            if (stack.isEmpty()&&isVPS) bw.write("YES\n");
            else bw.write("NO\n");
            stack.removeAllElements();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
