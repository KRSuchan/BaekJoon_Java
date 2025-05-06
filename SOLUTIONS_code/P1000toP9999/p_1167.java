package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_1167 {
    //    p_1167 : 트리의 지름
    static ArrayList<ArrayList<Node>> tree;
    static boolean[] visited;
    static int root;
    static int max = 0;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                tree.get(from).add(new Node(to, cost));
            }
        }
        visited = new boolean[N + 1];
        dfs(1, 0);
        visited = new boolean[N + 1];
        dfs(root, 0);

        System.out.println(max);
    }

    private static void dfs(int idx, int len) {
        if (len > max) {
            max = len;
            root = idx;
        }
        visited[idx] = true;
        ArrayList<Node> children = tree.get(idx);
        for (Node cur : children) {
            if (!visited[cur.to]) {
                dfs(cur.to, len + cur.cost);
            }
        }
    }

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
