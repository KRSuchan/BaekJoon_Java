package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p_11279 {
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0 && pq.isEmpty()) {
                sb.append(0).append("\n");
            } else if (x == 0) {
                sb.append(pq.poll()).append("\n");
            } else {
                pq.offer(x);
            }
        }
        System.out.print(sb);
    }
}
