package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_13549 {
    //    p_13549 : 숨바꼭질 3
    static int n, k;
    static int min = Integer.MAX_VALUE;
    static int range = 100000;
    static boolean[] visited;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[range + 1];
        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.v] = true;

            if (cur.v == k)
                min = Math.min(min, cur.time);

            if (cur.v * 2 <= range && !visited[cur.v * 2])
                q.add(new Node(cur.v * 2, cur.time));
            if (cur.v + 1 <= range && !visited[cur.v + 1])
                q.add(new Node(cur.v + 1, cur.time + 1));
            if (cur.v - 1 >= 0 && !visited[cur.v - 1])
                q.add(new Node(cur.v - 1, cur.time + 1));

        }
    }

    static class Node {
        int v;
        int time;

        Node(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }
}
