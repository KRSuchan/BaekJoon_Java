package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p_20301 {
    //    p_20301 : 반전 요세푸스
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int cnt = 0;
        boolean isLtoR = true;
        while (!dq.isEmpty()) {
            idx++;
            if (isLtoR) {
                int n = dq.removeFirst();
                if (idx % K == 0) {
                    sb.append(n).append("\n");
                    cnt++;
                } else {
                    dq.addLast(n);
                }
            } else {
                int n = dq.removeLast();
                if (idx % K == 0) {
                    sb.append(n).append("\n");
                    cnt++;
                } else {
                    dq.addFirst(n);
                }
            }
            if (cnt == M) {
                isLtoR = !isLtoR;
                cnt = 0;
            }
        }
        System.out.println(sb);
    }
}
