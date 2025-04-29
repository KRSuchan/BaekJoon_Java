package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p_1647 {
    //    p_1647 : 도시 분할 계획
    static int[] parent;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Way> map = new ArrayList<>();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // from (to)
            int b = Integer.parseInt(st.nextToken()); // to (from)
            int c = Integer.parseInt(st.nextToken()); // cost

            map.add(new Way(a, b, c));
        }
        Collections.sort(map);

        int result = 0;
        int max = 0;
        for (Way way : map) {
            if (find(way.from) != find(way.to)) {
                result += way.cost;
                union(way.from, way.to);
                max = way.cost;
            }
        }

        System.out.println(result - max);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static class Way implements Comparable<Way> {
        int from;
        int to;
        int cost;

        public Way(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Way o) {
            return this.cost - o.cost;
        }
    }
}
