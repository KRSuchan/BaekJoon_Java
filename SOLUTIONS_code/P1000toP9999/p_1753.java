package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_1753 {
    //    p_1753 : 최단경로
    static int V, E, K;
    static int[] dist;
    static ArrayList<Path>[] paths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());
        paths = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= V; i++) {
            paths[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            paths[u].add(new Path(v, w));
        }
        StringBuilder sb = new StringBuilder();
        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        pq.add(new Path(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Path p = pq.poll();
            int cur = p.next;
            if (check[cur]) continue;
            check[cur] = true;
            for (Path path : paths[cur]) {
                if (dist[path.next] > dist[cur] + path.cost) {
                    dist[path.next] = dist[cur] + path.cost;
                    pq.add(new Path(path.next, dist[path.next]));
                }
            }
        }
    }

    static class Path implements Comparable<Path> {
        int next;
        int cost;

        public Path(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path o) {
            return cost - o.cost;
        }
    }
}
