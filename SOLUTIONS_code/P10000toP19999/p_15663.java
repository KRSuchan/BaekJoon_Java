package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_15663 {
    //    p_15663 : N과 M (9)
    static int n, m;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // alg
        Arrays.sort(arr);
        dfs(0);

        // output
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[i] != prev) {
                result[depth] = arr[i];
                visited[i] = true;
                prev = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
