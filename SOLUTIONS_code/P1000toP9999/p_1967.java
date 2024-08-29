package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p_1967 {
    //    p_1967 : 트리의 지름
    static ArrayList<Path>[] list;
    static int n, max, num;

    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[p].add(new Path(c, w));
            list[c].add(new Path(p, w));
        }
        // alg
        dijkstra(1);
        dijkstra(num);
        // output
        System.out.print(max);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Path(start, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Path p = pq.poll();
            int cur = p.next;
            for (Path path : list[cur]) {
                if (dist[path.next] > dist[cur] + path.cost) {
                    dist[path.next] = dist[cur] + path.cost;
                    pq.add(new Path(path.next, dist[path.next]));
                }
            }
        }
        max = 0;
        num = start;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] > max) {
                max = dist[i];
                num = i;
            }
        }
    }

    static class Path {
        int next, cost;

        public Path(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}
