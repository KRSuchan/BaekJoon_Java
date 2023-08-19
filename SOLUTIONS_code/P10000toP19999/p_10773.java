package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.Stack;

public class p_10773 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int times = Integer.parseInt(br.readLine());
        int number;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < times; i++) {
            number = Integer.parseInt(br.readLine());
            if (number != 0) stack.push(number);
            else stack.pop();
        }
        while(!stack.isEmpty()){
            sum += stack.peek();
            stack.pop();
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
