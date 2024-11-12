package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p_24479 {
    //    p_24479 : 알고리즘 수업 - 깊이 우선 탐색 1
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static StringBuilder sb = new StringBuilder();
    static int order = 1;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(r);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int r) {
        visited[r] = order;
        for (int x : graph.get(r)) {
            if (visited[x] == 0) {
                order++;
                dfs(x);
            }
        }
    }
}
