package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_1238 {
    //    p_1238 : 파티
    static int n, m, x;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Path>> goMap = new ArrayList<>();
        ArrayList<ArrayList<Path>> backMap = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            goMap.add(new ArrayList<>());
            backMap.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            goMap.get(s).add(new Path(e, t));
            backMap.get(e).add(new Path(s, t));
        }
        int[] distance1 = dijkstra(goMap);
        int[] distance2 = dijkstra(backMap);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distance1[i] + distance2[i]);
        }
        System.out.println(max);
    }

    private static int[] dijkstra(ArrayList<ArrayList<Path>> map) {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(x, 0));

        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;
        while (!pq.isEmpty()) {
            Path p = pq.poll();
            int cur = p.next;
            if (check[cur]) continue;
            check[cur] = true;
            for (Path path : map.get(cur)) {
                if (dist[path.next] > dist[cur] + path.time) {
                    dist[path.next] = dist[cur] + path.time;
                    pq.add(new Path(path.next, dist[path.next]));
                }
            }
        }
        return dist;
    }

    static class Path implements Comparable<Path> {
        int next;
        int time;

        public Path(int next, int time) {
            this.next = next;
            this.time = time;
        }

        @Override
        public int compareTo(Path o) {
            return time - o.time;
        }
    }
}
