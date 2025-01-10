package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class p_14003 {
    //    p_14003 : 가장 긴 증가하는 부분 수열 5
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        var sb = new StringBuilder();
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list.add(Integer.MIN_VALUE);
        for (int i = 1; i <= n; i++) {
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;
            if (num > list.get(right)) {
                list.add(num);
                dp[i] = list.size() - 1;
            } else {
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= num) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(right, num);
                dp[i] = right;
            }
        }
        sb.append(list.size() - 1).append("\n");
        Stack<Integer> stack = new Stack<>();
        int idx = list.size() - 1;
        for (int i = n; i > 0; i--) {
            if (dp[i] == idx) {
                idx--;
                stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
