package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_15666 {
    //    p_15666 : N과 M (12)
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr, result;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.print(sb);
    }

    private static void dfs(int idx, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }
        int prev = 0;
        for (int i = idx; i < n; i++) {
            if (prev != arr[i]) {
                prev = arr[i];
                result[depth] = arr[i];
                dfs(i, depth + 1);
            }
        }
    }
}
