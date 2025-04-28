package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_15681 {
    //    p_15681 : 트리와 쿼리
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static int[] result;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        result = new int[N + 1];
        Arrays.fill(result, 1);
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            map.get(U).add(V);
            map.get(V).add(U);
        }

        dfs(R, -1);

        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(result[query]);
        }
    }

    private static void dfs(int cur, int prev) {
        for (int next : map.get(cur)) {
            if (prev != next)
                dfs(next, cur);
        }
        if (prev != -1) {
            result[prev] += result[cur];
        }
    }
}
