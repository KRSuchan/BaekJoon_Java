package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p_24444 {
    //    p_24444 : 알고리즘 수업 - 너비 우선 탐색 1
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int order = 1;
    static int[] visited;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(R);
        visited[R] = order++;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (var node : graph.get(cur)) {
                if (visited[node] == 0) {
                    visited[node] = order++;
                    q.add(node);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}
