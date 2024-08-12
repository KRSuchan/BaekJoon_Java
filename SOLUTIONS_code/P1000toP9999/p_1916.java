package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_1916 {
    //    p_1916 : 최소비용 구하기
    static int[] dist;
    static boolean[] check;
    static int n, m;
    static ArrayList<ArrayList<Path>> pathList;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); // 도시수
        m = Integer.parseInt(br.readLine()); // 버스 노선 수

        pathList = new ArrayList<>();
        dist = new int[n + 1];
        check = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            pathList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pathList.get(from).add(new Path(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(start, end) + "\n");
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n + 1];
        pq.add(new Path(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Path p = pq.poll();
            int cur = p.next;
            if (!check[cur]) {
                check[cur] = true;
                for (Path path : pathList.get(cur)) {
                    if (!check[path.next] && dist[path.next] > dist[cur] + path.cost) {
                        dist[path.next] = dist[cur] + path.cost;
                        pq.add(new Path(path.next, dist[path.next]));
                    }
                }
            }
        }
        return dist[end];
    }

    static class Path implements Comparable<Path> {
        int next;
        int cost;

        Path(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path o) {
            return cost - o.cost;
        }
    }
}
