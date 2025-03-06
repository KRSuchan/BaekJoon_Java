package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1005 {
    //    p_1005 : ACM Craft
    static int N, K, W;
    static int[] delay, indegree;
    static ArrayList<ArrayList<Integer>> map;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            var st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            delay = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }
            map = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                map.add(new ArrayList<>());
            }
            indegree = new int[N + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                map.get(s).add(e);
                indegree[e]++;
            }
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            topologySort();
        }
    }

    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = delay[i];
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i : map.get(c)) {
                result[i] = Math.max(result[i], result[c] + delay[i]);
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        System.out.println(result[W]);
    }
}
