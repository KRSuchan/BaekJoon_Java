package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_11725 {
    //    p_11725 : 트리의 부모 찾기
    static ArrayList<Integer>[] list;
    static int[] parent;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }
        // alg
        dfs(1);
        // output
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int i : list[v]) {
            if (!visited[i]) {
                parent[i] = v;
                dfs(i);
            }
        }
    }
}
