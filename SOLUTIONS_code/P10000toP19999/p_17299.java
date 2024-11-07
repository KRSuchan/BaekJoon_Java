package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p_17299 {
    //    p_17299 : 오등큰수
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] arr = new int[1_000_001];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            arr[seq[i]]++;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[seq[stack.peek()]] < arr[seq[i]]) {
                seq[stack.pop()] = seq[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }
        var sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(seq[i]).append(" ");
        }
        System.out.println(sb);
    }
}
