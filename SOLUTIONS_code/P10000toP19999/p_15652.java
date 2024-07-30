package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_15652 {
    //    p_15652 : N과 M (4)
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int n;
    static int m;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(1, 0);
        System.out.print(sb);
    }

    static void dfs(int num, int depth) {
        if (depth == m) {
            for (int v : arr) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = num; i <= n; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
