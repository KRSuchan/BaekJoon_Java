package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class p_2346 {
    //    p_2346 : 풍선 터뜨리기
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Node> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(new Node(Integer.parseInt(st.nextToken()), i));
        }
        StringBuilder sb = new StringBuilder();
        Node x = dq.pollFirst();
        sb.append(x.idx).append(" ");
        while (!dq.isEmpty()) {
            if (x.v > 0) {
                for (int i = 1; i < x.v; i++) {
                    dq.addLast(dq.pollFirst());
                }
                x = dq.pollFirst();
            } else {
                for (int i = 1; i < -x.v; i++) {
                    dq.addFirst(dq.pollLast());
                }
                x = dq.pollLast();
            }
            sb.append(x.idx).append(" ");
        }
        System.out.println(sb);
    }

    static class Node {
        int v;
        int idx;

        Node(int v, int idx) {
            this.v = v;
            this.idx = idx;
        }
    }
}
