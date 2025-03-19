package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_9466 {
    //    p_9466 : 텀 프로젝트
    static boolean[] visited, isCycle;
    static int[] arr;
    static int cnt;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            isCycle = new boolean[n + 1];
            cnt = 0;
            var st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                dfs(i);
            }
            System.out.println(n - cnt);
        }
    }

    private static void dfs(int idx) {
        if (visited[idx]) {
            return;
        }
        visited[idx] = true;
        int next = arr[idx];

        if (!visited[next]) {
            dfs(next);
        } else if (!isCycle[next]) {
            cnt++;
            for (int i = next; i != idx; i = arr[i]) {
                cnt++;
            }
        }
        isCycle[idx] = true;
    }
}
