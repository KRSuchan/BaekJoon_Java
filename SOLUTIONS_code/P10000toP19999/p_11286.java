package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p_11286 {
    //    p_11286 : 절댓값 힙
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0 && !pq.isEmpty()) {
                sb.append(pq.poll().data).append("\n");
            } else if (x == 0) {
                sb.append("0\n");
            } else {
                pq.add(new Node(x));
            }
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int abs;
        int data;

        public Node(int data) {
            this.abs = Math.abs(data);
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            if (this.abs == o.abs) {
                return this.data - o.data;
            }
            return this.abs - o.abs;
        }
    }

}
