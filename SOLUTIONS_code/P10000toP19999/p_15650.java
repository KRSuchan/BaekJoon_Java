package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_15650 {
    //    p_15650 : N과 M (2)
    static int[] arr;
    static int m;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(1, 0);
        System.out.print(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == m) {
            for (int v : arr) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
