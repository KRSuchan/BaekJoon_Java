package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_1504 {
    //    p_1504 : 특정한 최단 경로
    public static final int INF = 200_000_000;
    public static int N;
    public static ArrayList<ArrayList<Node>> map;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(s).add(new Node(e, c));
            map.get(e).add(new Node(s, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        int res2 = 0;
        int betweenV1V2 = dijkstra(v1, v2);
        res1 += dijkstra(1, v1);
        res1 += betweenV1V2;
        res1 += dijkstra(v2, N);

        res2 += dijkstra(1, v2);
        res2 += betweenV1V2;
        res2 += dijkstra(v1, N);

        int res = (res1 < INF && res2 < INF) ? Math.min(res1, res2) : -1;
        System.out.println(res);
    }

    private static int dijkstra(int from, int to) {
        int[] costs = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(costs, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(from, 0));
        costs[from] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visited[cur.num]) {
                visited[cur.num] = true;
                for (Node node : map.get(cur.num)) {
                    if (!visited[node.num] && costs[node.num] > costs[cur.num] + node.cost) {
                        costs[node.num] = costs[cur.num] + node.cost;
                        pq.add(new Node(node.num, costs[node.num]));
                    }
                }
            }
        }
        return costs[to];
    }

    static class Node implements Comparable<Node> {
        int num, cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
