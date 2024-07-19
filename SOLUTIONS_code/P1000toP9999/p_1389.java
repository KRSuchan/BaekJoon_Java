package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1389 {
    // p_1389 : 케빈 베이컨의 6단계 법칙
    static int n;
    static int m;
    static boolean[][] graph;

    public int bfs(int user) {
        Queue<Integer> q = new LinkedList<>();
        q.add(user);
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        visited[user] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[cur][i]) {
                    visited[i] = true;
                    dist[i] = dist[cur] + 1;
                    cnt += dist[i];
                    q.add(i);
                }
            }
        }
        return cnt;
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }
        int min = Integer.MAX_VALUE;
        int kevin = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = bfs(i);
            if (cnt < min) {
                min = cnt;
                kevin = i;
            }
        }
        System.out.println(kevin);
    }
}
