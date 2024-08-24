package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class p_11068 {
    //    p_11068 : 회문인 수
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean isExist = false;
            for (int i = 2; i <= 64 && !isExist; i++) {
                int temp = n;
                Deque<Integer> dq = new LinkedList<>();
                while (temp > 0) {
                    dq.offer(temp % i);
                    temp /= i;
                }
                isExist = true;
                for (int j = 0, size = dq.size() / 2; j < size; j++) {
                    if (!dq.removeFirst().equals(dq.removeLast())) {
                        isExist = false;
                        break;
                    }
                }
            }
            sb.append(isExist ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
}
