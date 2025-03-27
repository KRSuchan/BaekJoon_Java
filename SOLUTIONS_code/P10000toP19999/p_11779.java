package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_11779 {
    //    p_11779 : 최소비용 구하기 2
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 수
        int M = Integer.parseInt(br.readLine()); // 버스 수
        ArrayList<ArrayList<Node>> map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            var st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map.get(s).add(new Node(e, w));
        }

        var st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        int[] route = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, 1_000_000_001); // 최대 도시 수 * 최대 버스 비용 + 1

        // 출발지 to 도착지 버스 비용 최소화 -> dijkstra
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        route[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.e]) continue;
            visited[cur.e] = true;
            for (int i = 0; i < map.get(cur.e).size(); i++) {
                Node next = map.get(cur.e).get(i);
                if (dist[next.e] > dist[cur.e] + next.c) {
                    dist[next.e] = dist[cur.e] + next.c;
                    pq.add(new Node(next.e, dist[next.e]));
                    route[next.e] = cur.e;
                }
            }
        }
        // 출력 1. start -> end 최소 비용
        System.out.println(dist[end]);

        // 출력 2. 최소 비용에 포함된 도시의 개수
        ArrayList<Integer> routes = new ArrayList<>();
        int cur = end;
        while (cur != 0) {
            routes.add(cur);
            cur = route[cur];
        }
        System.out.println(routes.size());

        // 출력 3. 최소 비용 경로의 방문 도시 순
        for (int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    static class Node implements Comparable<Node> {
        int e; // 방향
        int c; // e 방향의 비용

        public Node(int e, int c) {
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
}
