package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_15649 {
    //    p_15649 : N과 M (1)
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visited;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[M];
        visited = new boolean[N];
        dfs(N, M, 0);
        System.out.print(sb);
    }

    private static void dfs(int n, int m, int depth) {
        if (m == depth) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}
